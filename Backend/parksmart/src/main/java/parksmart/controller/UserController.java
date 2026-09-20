package parksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parksmart.model.User;
import parksmart.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null &&
            existingUser.getPassword().equals(user.getPassword())) {

            return "Login successful";
        }

        return "Invalid email or password";
    }
} 