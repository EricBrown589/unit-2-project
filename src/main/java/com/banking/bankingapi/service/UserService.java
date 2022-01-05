package com.banking.bankingapi.service;

import com.banking.bankingapi.exception.InformationExistsException;
import com.banking.bankingapi.model.Request.LoginRequest;
import com.banking.bankingapi.model.Response.LoginResponse;
import com.banking.bankingapi.model.User;
import com.banking.bankingapi.repository.UserRepository;
import com.banking.bankingapi.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {
    private UserRepository userRepository;
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User userObject){
        LOGGER.info("calling createUser method from service");
        if (!userRepository.existsByEmailAddress(userObject.getEmailAddress())) {
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            return userRepository.save(userObject);
        } else {
            throw new InformationExistsException("user with email address " +
                    userObject.getEmailAddress() + " already exists");
        }
    }

    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        final String jwt = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(jwt));
    }

    public User findUserByEmailAddress(String email) {
        return userRepository.findUserByEmailAddress(email);
    }
}