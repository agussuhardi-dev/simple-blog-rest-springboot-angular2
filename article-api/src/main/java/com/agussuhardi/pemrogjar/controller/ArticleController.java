package com.agussuhardi.pemrogjar.controller;

import com.agussuhardi.pemrogjar.dao.ArticleDao;
import com.agussuhardi.pemrogjar.dao.HistoryDao;
import com.agussuhardi.pemrogjar.dao.UserDao;
import com.agussuhardi.pemrogjar.entity.ArticleModel;
import com.agussuhardi.pemrogjar.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by agussuhardi on 28/11/16.
 */
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/article")
public class ArticleController {

    @Autowired
    private ArticleDao dao;
    @Autowired
    private UserDao userDao;

    //gets article by user and status - 1
    @RequestMapping(value = "gets", method = RequestMethod.GET)
    public Iterable<ArticleModel> gets(
            @RequestParam String username,
            @RequestParam(required = false) String status
    ) {
        if (status.equalsIgnoreCase("") || status.isEmpty() || status.equalsIgnoreCase("null")) {
            return dao.findByUserNameNoTrashDeleteForeverYes(username);
        }else if(status.equalsIgnoreCase("share")){
            return dao.findByShare(username);
        } else {
            return dao.findByUserNameStatusDeleteForeverYes(username, status);
        }
    }

    //gets article share by other user on share to me(username) - 2
    @RequestMapping(value = "share", method = RequestMethod.GET)
    public Iterable<ArticleModel> share(
            @RequestParam String username
    ) {
        return dao.findByShare(username);
    }

    //get article by Id - 3
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ArticleModel get(
            @RequestParam int id
    ) {
        return dao.findOne(id);
    }

    //save article - 4
    @RequestMapping(value = "save", method = RequestMethod.PUT)
    public void save(
            @RequestBody ArticleModel data
    ) {
        ArticleModel oldData = dao.findOne(data.getId());
        data.setOnEdit(false);


        if (oldData== null){
            data.setOnEdit(false);
            data.setInformationChange("new Article");
            dao.save(data);
        }else if (oldData!= null){
            oldData.setOnEdit(false);
            oldData.setInformationChange("update Article");
            oldData.setTitle(data.getTitle());
            oldData.setArticle(data.getArticle());
            oldData.setStatus(data.getStatus());
            dao.save(oldData);
        }
    }

    //on Request Edit, set active = 1 - 5
    @RequestMapping(value = "onedit", method = RequestMethod.GET)
    public void onEdit(
            @RequestParam int id,
            @RequestParam String username
    ) {
        ArticleModel data = dao.findOne(id);

        data.setOnEdit(true);
        data.setUserNameChange(username);
        data.setUpdateDate(new Date());
        data.setInformationChange("Start Edit");
        dao.save(data);
    }

//add or remove user access content - 6
    //@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "accessuser", method = RequestMethod.GET)
    public String saveUserAccessArticle(
            @RequestParam int article,
            @RequestParam String user,
            @RequestParam String access
    ) {
        ArticleModel data = dao.findOne(article);
        UserModel userModel = userDao.findOne(user);

        if (access.equalsIgnoreCase("true")) {
            data.getUserAccessList().add(userModel);
        }else if (access.equalsIgnoreCase("false")){
            data.getUserAccessList().remove(userModel);
        }
        data.setInformationChange("Change User Access");
        dao.save(data);

        ArticleModel articleModel = dao.findOne(article);
        return "OK";
    }


    //restore content - 7
    @RequestMapping(value = "restore", method = RequestMethod.GET)
    public ArticleModel restore(
            @RequestParam int id,
            @RequestParam String status
    ){
        ArticleModel data = dao.findOne(id);
        data.setInformationChange("Move to "+status);
        data.setStatus(status);
        dao.save(data);
        return data;
    }

}


