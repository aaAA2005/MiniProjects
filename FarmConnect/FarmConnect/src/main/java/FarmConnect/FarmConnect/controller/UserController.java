package FarmConnect.FarmConnect.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import FarmConnect.FarmConnect.dto.AuthResponse;
import FarmConnect.FarmConnect.dto.LoginRequest;
import FarmConnect.FarmConnect.entity.UserEntity;
import FarmConnect.FarmConnect.service.JwtService;
import FarmConnect.FarmConnect.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public String register(@RequestBody @Valid UserEntity user){

         service.register(user);
         return "succesfuly";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){

        Optional<UserEntity> user = service.login(request.getGmail());

        if(user.isPresent() && user.get().getPassword().equals(request.getPassword())){

            String token = jwtService.generateToken(request.getGmail());

            return new AuthResponse(token);
        }

        throw new RuntimeException("Invalid credentials");
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {
        UserEntity updatedUser = service.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    // Optional: get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Integer id) {
        UserEntity user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }
}

