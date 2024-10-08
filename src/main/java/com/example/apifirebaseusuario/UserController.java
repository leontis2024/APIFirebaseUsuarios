package com.example.apifirebaseusuario;
import com.google.firebase.auth.UserRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final FirebaseAuthService firebaseAuthService;

    public UserController(FirebaseAuthService firebaseAuthService) {
        this.firebaseAuthService = firebaseAuthService;
    }

    @PostMapping("criar")
    public ResponseEntity<?> createUser(@RequestBody Usuario user) {
        try {
            UserRecord userRecord = firebaseAuthService.createUser(user.getEmail(), user.getSenha());
            return new ResponseEntity<>(userRecord, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}