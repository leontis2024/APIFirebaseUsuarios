package com.example.apifirebaseusuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import org.springframework.stereotype.Service;

@Service
public class FirebaseAuthService {

    public UserRecord createUser(String email, String password) throws Exception {
        CreateRequest request = new CreateRequest()
                .setEmail(email)
                .setPassword(password);

        return FirebaseAuth.getInstance().createUser(request);
    }
}
