package org.alexov.otus.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserDetailsManager userDetailsManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("confirm-password") String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return ResponseEntity.badRequest().body("password and confirmPassword is mismatched");
        }
        MyUserDetails userMy = new MyUserDetails();
        userMy.setUsername(username);
        userMy.setPassword(password);
        userDetailsManager.createUser(userMy);
        return ResponseEntity.ok().build();
    }
}
