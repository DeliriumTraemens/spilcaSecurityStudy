package org.mykola.spilcaSecurityStudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProjectConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
//        Map<String, PasswordEncoder> encoders = new HashMap<>();
//        encoders.put("noop", NoOpPasswordEncoder.getInstance());
//        encoders.put("bcrypt", new BCryptPasswordEncoder());
//        encoders.put("scrypt", new SCryptPasswordEncoder());

//        PasswordEncoder instance = NoOpPasswordEncoder.getInstance();
        return NoOpPasswordEncoder.getInstance();
//        return new DelegatingPasswordEncoder("bcrypt", encoders);
    }

    @Bean
    public UserDetailsService userDetailsService(){
        var userDetailsService = new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("Nick")
                .password("12345")
                .authorities("read")
                .build();
        userDetailsService.createUser(user);
        return userDetailsService;
    }

}
