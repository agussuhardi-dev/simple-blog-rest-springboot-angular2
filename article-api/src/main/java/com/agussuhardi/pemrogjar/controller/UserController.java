package com.agussuhardi.pemrogjar.controller;

import com.agussuhardi.pemrogjar.dao.UserDao;
import com.agussuhardi.pemrogjar.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by agussuhardi on 02/12/16.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    private UserDao dao;

    //get all content
    @RequestMapping(value = "gets", method = RequestMethod.GET)
    public Iterable<UserModel> list() {
        Iterable<UserModel> list = dao.findAll();
        return list;
    }

    //save or edit user
    @RequestMapping(value = "save", method = RequestMethod.PUT)
    public void saveUser(
            @RequestBody UserModel user
    ) {
        dao.save(user);
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public UserModel login(
            @RequestParam String username,
            @RequestParam String password

    ) {
        return dao.login(username, password);
    }

    @RequestMapping(value = "savelogin", method = RequestMethod.GET)
    public void logout(
            @RequestParam String username,
            @RequestParam String request,
            @RequestParam String mac,
            @RequestParam String ip
    ) {
        UserModel user = dao.findOne(username);
        if(request.equalsIgnoreCase("login")){
            user.setStartLogin(new Date());
            user.setMacAddressChange(mac);
            user.setLocalIpChange(ip);
            user.setLogin(true);
            dao.save(user);
        }else if(request.equalsIgnoreCase("logout")){
            user.setStopLogin(new Date());
            user.setMacAddressChange(null);
            user.setLocalIpChange(ip);
            user.setLogin(false);
            dao.save(user);
        }

    }


    @RequestMapping(value = "get", method = RequestMethod.GET)
    public UserModel get(
            @RequestParam String username
    ) {
        return dao.findOne(username);
    }
}
