package org.mykola.spilcaSecurityStudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFilter;

//@Configuration
public class UserManagementConfig {


//
//    @Bean
//    public UserDetailsService userDetailsService() {
////
//
//
//        User.UserBuilder builder1 = User.withUsername("Bill");
//        UserDetails u1 = builder1
//                .password("123")
//                .authorities("read", "write")
////                .passwordEncoder(p -> encode(p))//it is NOT A BEAN of PassEncoder!!!
//                .accountExpired(false)
//                .disabled(true)
//                .build();
////=================
//        UserDetails u = User.withUsername("bill")
//                .password("12345")
//                .authorities("read", "write")
//                .accountExpired(false)
//                .disabled(true)
//                .build();
//
//        User.UserBuilder builder2 = User.withUserDetails(u);
//        UserDetails u2 = builder2.build();
////================
////
//        AuthenticationFilter af;
//        var userDetailsService = new InMemoryUserDetailsManager();
//        var user = User.withUsername("john")
//                .password("12345")
//                .authorities("read")
//                .build();
//        userDetailsService.createUser(user);
//
//
//        return userDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
}
