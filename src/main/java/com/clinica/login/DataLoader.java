package com.clinica.login;

import com.clinica.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordAdmin = passwordEncoder.encode("admin");
        String passwordUser = passwordEncoder.encode("user");

        userRepository.save(new User("admin", "admin", "admin@mail.com", passwordAdmin, Roles.ADMIN));
        userRepository.save(new User("user", "user", "user@mail.com", passwordUser, Roles.USER));
    }
}
