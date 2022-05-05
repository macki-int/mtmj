package pl.trollsystems.mtms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.trollsystems.mtms.model.User;
import pl.trollsystems.mtms.repository.UserRepository;

import java.util.Optional;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isPresent()) {
            return ResponseEntity.ok().body(userOptional);
        }
        
        return ResponseEntity.noContent().build();
    }
}
