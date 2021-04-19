package fr.simplon.picone.controller;


import fr.simplon.picone.model.Admin;
import fr.simplon.picone.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @GetMapping(value = "/admins")
    public List<Admin> findAdmins()throws Exception{
        return adminService.findNodes();
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @GetMapping(value = "/admin/{id}")
    public Optional<Admin> findAdminById(@PathVariable Long id)throws Exception{
        return adminService.findNodesById(id);
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @GetMapping(value = "/admin/{id}/{relation}")
    public List<Admin> findAdminByIdAndRelation(@PathVariable Long id, @PathVariable String relation)throws Exception{
        return adminService.findByIdAndByRelation(id, relation);
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @PostMapping(value = "/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin)throws Exception{
          return adminService.addAdmin(admin);
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/deleteAdmin/{id}")
    public void Admin (@PathVariable(value = "id") Long id) throws Exception{
        adminService.deleteAdmin(id);
    }


    @CrossOrigin(value = "*", allowedHeaders = "*")
    @PutMapping(value = "/updateAdmin/{id}")
    public @ResponseBody
    Admin updateAdmin(@RequestBody Admin admin, @PathVariable(value = "id") Long id)throws Exception{
    Optional <Admin> e = adminService.findNodesById(id);
    if (e.isPresent()){
        Admin currentAdmin = e.get();
        String firstName = admin.getFirstName();

        if (firstName != null){
            currentAdmin.setFirstName(firstName);
        }
        String lastName = admin.getLastName();
        if (lastName != null){
            currentAdmin.setLastName(lastName);
        }
        String email = admin.getEmail();
        if (email != null){
            currentAdmin.setEmail(email);
        }
        String password = admin.getPassword();
        if (password != null){
            currentAdmin.setPassword(password);
        }
        String confirmPassword = admin.getConfirmPassword();
        if (confirmPassword != null){
            currentAdmin.setConfirmPassword(confirmPassword);
        }
        adminService.upadateAdmin(currentAdmin);
        return currentAdmin;
    } else {
        return null;
    }
}
}
