package org.example.service;


import org.example.dtos.AuthResponse;
import org.example.dtos.LoginRequest;
import org.example.dtos.RegisterRequest;
import org.example.entities.UserEntity;
import org.example.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest registerRequest){
        if(userRepository.existsByUsername(registerRequest.username())){
            throw  new RuntimeException("UserName already exists");
        }
        UserEntity user=new UserEntity();
        user.setUsername(registerRequest.username());
        user.setPassword(passwordEncoder.encode(registerRequest.password()));

        user.setRole("USER");
        UserEntity savedUser=userRepository.save(user);
        String token=jwtService.generateToken(savedUser);

        return new AuthResponse(token, savedUser.getUsername(), savedUser.getRole());
    }

    public AuthResponse login(LoginRequest loginRequest){
        UserEntity user=userRepository.findByUsername(loginRequest.username())
                .orElseThrow(()->new RuntimeException("User not Found "));

        if(!passwordEncoder.matches(loginRequest.password(),user.getPassword())){
            throw new RuntimeException("Invalid Username or password");
        }
        String token= jwtService.generateToken(user);

        return new AuthResponse(token, user.getUsername(), user.getRole());
    }
}
