package org.mykola.spilcaSecurityStudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.Date;


@Configuration
//@EnableWebSecurity
public class ProjectConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    AuthenticationProvider customAuthenticationProvider; // Its wired to our CustomAuthProvider!!!

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(customAuthenticationProvider);//Load our CustomAuthenticationProvider into config
    }

//    Replace Realm
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String s = new Date().toString();
        http.httpBasic(c->
                c.realmName("CustomName"+s)
        );
        http.authorizeRequests().anyRequest().authenticated();
    }


//Replacement from author
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        String usersByUsernameQuery =
//                "select username, password, enabled from spilcaSecurity.users where username = ?";
//        String authsByUserQuery =
//                "select username, authority from spilcaSecurity.authorities where username = ?";
//        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
//        userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
//        return userDetailsManager;
//    }



//@Bean
//public UserDetailsService userDetailsService(DataSource dataSource) {
//    return new JdbcUserDetailsManager(dataSource);
//}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
