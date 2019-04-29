package com.galvanize.gmdbmonolith.Controllers;

import com.galvanize.gmdbmonolith.Models.Login;
import com.galvanize.gmdbmonolith.Models.User;
import com.galvanize.gmdbmonolith.Services.GmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class APIController {

    private final GmdbService service;

    @Autowired
    public APIController(GmdbService service)
    {
        this.service = service;

    }

    @GetMapping(path="/welcome")
    public String showWelcomePage(){
        return "Hello world";
    }

    @PostMapping("/login")
    public String getCredentials(@RequestBody(required = false) Login login){
        System.out.println(login.getEmail());
        System.out.println(login.getPassword());
        User user = service.validateUser(login.getEmail(), login.getPassword());
        if (user == null) {
            return "Invalid";
        }
        else{
            return "Successful";
        }
    }

    @PostMapping(path="/create-account")
    public String getAccountDetails(@RequestBody User user){
        Boolean b=service.createUser(user);
        if(b==true){
            return "User Created";

        }
        else{
            return "Error in user creation";
        }
    }

//    @GetMapping(path="/api/create-account")
//    public String getAccountDetsild(  String email, String password, String screenName, String repeatPassword){
//    }



}
