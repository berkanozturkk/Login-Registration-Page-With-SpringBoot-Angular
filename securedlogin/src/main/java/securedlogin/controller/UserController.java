package securedlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("user/{username}/{email}/{password}")
    public int UserRegist(@PathVariable("username") String submittedusername, @PathVariable("email") String submittedemail, @PathVariable("password") String submittedpassword){
        int flag = userRepo.registcheck(submittedusername,submittedemail,submittedpassword);
        if (flag == 0) {
            flag = 1; //The successful post method returns 0, so we need to return the flag to 1 again so that we can write a logically correct code in the frontend
            return flag;
        }
        return flag;
    }
}
