//package fr.simplon.picone.login;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@ConditionalOnProperty(prefix = "app", name = "security", havingValue = "false")
//public class DisableSecurityConfig extends WebSecurityConfigurerAdapter {
//    protected void configure (HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .anyRequest().authenticated();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder getEncoder(){return new BCryptPasswordEncoder();}
//
//}
