//package fr.simplon.picone.login.service;
//
//import fr.simplon.picone.login.model.AppUser;
//import fr.simplon.picone.login.repository.AppUserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@Service("userDetailsService")
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
//
//    @Autowired
//    private AppUserRepository userRepository;
//
//    @Transactional(readOnly = true)
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<AppUser> user = userRepository.findByUsername(username);
//
//        if (user.isEmpty()) {
//            throw new UsernameNotFoundException("AppUser '" + username + "' not found");
//        }
//
//        log.info("loadUserByUsername() : {}", username);
//
//        return User
//                .withUsername(username)
//                .password(user.get().getPassword())
//                .authorities(user.get().getAuthorities())
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
//
//    }
//}
