package org.alexov.otus.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsManager {
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public void createUser(UserDetails user) {

        MyUserDetails userMy = new MyUserDetails();
        userMy.setUsername(user.getUsername());
        userMy.setPassword(user.getPassword());
        userRepo.save(userMy);
    }

    @Override
    @Transactional
    public void updateUser(UserDetails user) {
        MyUserDetails myUserDetails = userRepo.findByUsername(user.getUsername()).orElseThrow();
        myUserDetails.setPassword(user.getPassword());
        myUserDetails.setUsername(user.getUsername());
    }

    @Override
    public void deleteUser(String username) {
        userRepo.deleteByUsername(username);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean userExists(String username) {
        return userRepo.findByUsername(username).isPresent();
    }
}
