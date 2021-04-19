//package fr.simplon.picone.login.service;
//
//import fr.simplon.picone.login.dto.PasswordsDto;
//import fr.simplon.picone.login.model.AppUser;
//import fr.simplon.picone.login.repository.AppUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContextException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//public class AppUserServiceImpl implements AppUserService{
//    @Autowired
//    AppUserRepository repository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    @Override
//    public List<AppUser> findAllUsers(String name, String email) {
//        if (! "" .equals(name))
//            return repository.findByUsernameStartingWith(name);
//        else if (! "" .equals(email))
//            return repository.findByEmailStartingWith(email);
//        return repository.findAll();
//
//    }
//
//    @Override
//    public Optional<AppUser> findById(Long id) {
//        return repository.findById(id);
//    }
//
//    @Override
//    public Optional<AppUser> findByName(String name) {
//        return repository.findByUsername(name);
//    }
//
//    @Override
//    public AppUser insert(AppUser user) {
//        user.setPassword(passwordEncoder.encode("password"));
//        user.setCreatedDate(LocalDateTime.now());
//        return repository.save(user);
//    }
//
//    @Override
//    public AppUser update(Long id, AppUser user) {
//        Optional<AppUser> optionalAppUser = this.findById(id);
//        if (optionalAppUser.isPresent()){
//            user.setPassword(optionalAppUser.get().getPassword());
//            return repository.save(user);
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//        Optional<AppUser> user = this.findById(id);
//        user.ifPresent(appUser -> repository.delete(appUser));
//    }
//
//    @Override
//    public void changePassword(Long id, PasswordsDto password) {
//        AppUser user = repository.findById(id).orElseThrow();
//
//        if (!password.isForcePwdChange()){
//            if (passwordEncoder.matches(password.getNewPassword(), user.getPassword()))
//                throw new ApplicationContextException("User password");
//        }
//        user.setPassword(passwordEncoder.encode(password.getNewPassword()));
//        repository.save(user);
//    }
//}
