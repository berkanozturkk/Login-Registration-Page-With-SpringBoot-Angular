package securedlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import securedlogin.repo.UserRepo;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("user/{username}/{password}")
    public int UserLogin(@PathVariable("username") String submittedusername, @PathVariable("password") String submittedpassword){
        int flag = userRepo.logincheck(submittedusername,submittedpassword);
        if (flag == 0) {
            return 0;
        }
        return flag;
    }
}
