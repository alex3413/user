package org.alexov.otus.user.controller;

import lombok.RequiredArgsConstructor;
import org.alexov.otus.user.model.CredRepo;
import org.alexov.otus.user.model.OtusUser;
import org.alexov.otus.user.model.UserCred;
import org.alexov.otus.user.model.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final CredRepo credRepo;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/user/profile")
    public ResponseEntity<Long> getUserProfile(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(name)
                .map(u -> ResponseEntity.ok(u.getId()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) throws AccessDeniedException {
              Optional<OtusUser> byId = userRepository.findById(id);


        return ResponseEntity.ok(byId);
    }

    private static ResponseEntity<String> isForbidden(Optional<OtusUser> byId, String username) {
        try{
            byId.map(OtusUser::getUsername).filter(u -> u.equals(username))
                    .orElseThrow(() -> new AccessDeniedException("Access denied"));
        } catch (AccessDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
        return null;
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
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody OtusUser user) throws BadRequestException {
        var otusUserOptional = userRepository.findById(id);


        var otusUser = otusUserOptional.orElseThrow();
        otusUser.setUsername(user.getUsername());
        otusUser.setFirstName(user.getFirstName());
        otusUser.setLastName(user.getLastName());
        otusUser.setEmail(user.getEmail());
        otusUser.setPhone(user.getPhone());
        return ResponseEntity.ok(userRepository.save(otusUser));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        return ResponseEntity.ok().build();
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserCred user) throws BadRequestException {
        if(credRepo.findById(user.getUsername()).isPresent()){
            throw new BadRequestException("Username is already in use");
        }
        OtusUser save = userRepository.save(OtusUser.builder().username(user.getUsername()).credentials(UserCred.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .build()).build());
        return ResponseEntity.ok(save.getId());
    }

    @GetMapping("/registration")
    public ResponseEntity<?> registerUser() {
        return ResponseEntity.ok("test");
    }
}