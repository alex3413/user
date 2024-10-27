package org.alexov.otus.user;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final CredRepo credRepo;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody OtusUser user) throws BadRequestException {
        if(userRepository.findById(user.getId()).isPresent()){
            throw new BadRequestException("Username is already in use");
        }
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody OtusUser user, Authentication authentication) throws BadRequestException {
        var principal = authentication.getPrincipal().toString();
        OtusUser otusUser = userRepository.findById(id).orElseThrow();
        otusUser.setUsername(user.getUsername());
        otusUser.setFirstName(user.getFirstName());
        otusUser.setLastName(user.getLastName());
        otusUser.setEmail(user.getEmail());
        otusUser.setPhone(user.getPhone());
        return ResponseEntity.ok(userRepository.save(otusUser));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserCred user) throws BadRequestException {
        if(credRepo.findById(user.getUsername()).isPresent()){
            throw new BadRequestException("Username is already in use");
        }
        userRepository.save(OtusUser.builder().username(user.getUsername()).credentials(user).build());
        return ResponseEntity.ok().build();
    }
}