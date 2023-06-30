package org.mykola.spilcaSecurityStudy.config;

import org.mykola.spilcaSecurityStudy.model.SimpleUser;
import org.mykola.spilcaSecurityStudy.security.CustomAuthenticationProvider;
import org.mykola.spilcaSecurityStudy.service.InMemoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

//@Configuration
//@EnableWebSecurity
public class ProjectConfig extends WebSecurityConfigurerAdapter {

//
@Bean
public UserDetailsService userDetailsService() {
    UserDetails u = new SimpleUser("Nick", "12345", "read");
    List<UserDetails> users = List.of(u);
    return new InMemoryUserDetailsService(users);
}
//

//
@Autowired
private CustomAuthenticationProvider authenticationProvider;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
//

    //alternative way
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        var userDetailsService = new InMemoryUserDetailsManager();
//        var user = User.withUsername("Nick")
//                .password("12345")
//                .authorities("read")
//                .build();
//        userDetailsService.createUser(user);
//
//        var user1 = User.withUsername("Nicky")
//                .password("123456")
//                .authorities("read")
//                .build();
//        userDetailsService.createUser(user1);
//
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.httpBasic();
//        http.formLogin();
//        http.authorizeRequests()
//                .anyRequest().authenticated();//or instead .permitAll() - no auth for all requests
//
//    }

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

//    @Bean
//    public UserDetailsService userDetailsService(){
//        var userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("Nicky")
//                .password("123456")
//                .authorities("read")
//                .build();
//        userDetailsService.createUser(user);
//        return userDetailsService;
//    }

}
