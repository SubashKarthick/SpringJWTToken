package com.example.learnSpring.springJWTexample.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnSpring.springJWTexample.Utils.JwtTokenUtils;
import com.example.learnSpring.springJWTexample.services.ValidateUserServices;
import com.example.learnSpring.springJWTexample.vo.JWTResponse;
import com.example.learnSpring.springJWTexample.vo.JWTUserName;

@RestController
@CrossOrigin
@RequestMapping("/springJWTexample")
public class GenerateAuthTokenController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtils tokenUtils;
	
	@Autowired
	private ValidateUserServices userServices;
	
	
	@RequestMapping(path="/authenticator", method = RequestMethod.POST)
	public JWTResponse getAuthToken(@RequestBody JWTUserName requestUser) throws Exception {
		
		authenticateUser(requestUser.getUserName(), requestUser.getPassword());
		
		final UserDetails userDetails = userServices.loadUserByUsername(requestUser.getUserName()); 
		
		final String token = tokenUtils.generateToken(userDetails);

		JWTResponse jwtResponse = new JWTResponse();
		jwtResponse.setAuthToken(token);
		
		return jwtResponse;	
	}
	
	private void authenticateUser(String userName, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		} catch(DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch(BadCredentialsException e) {
			throw new Exception("bad credential exception -- > ", e);
		}
	}
}
