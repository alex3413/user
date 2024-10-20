package org.alexov.otus.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
//    private final DiscoveryClient discoveryClient;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody OtusUser user) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody OtusUser user) {
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
}