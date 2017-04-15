package com.agussuhardi.pemrogjar.controller;


import com.agussuhardi.pemrogjar.dao.ArticleDao;
import com.agussuhardi.pemrogjar.entity.ArticleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/post")
public class PostController{

    @Autowired
    private ArticleDao dao;

    @RequestMapping(value = "gets", method = RequestMethod.GET)
    public Iterable<ArticleModel> gets(){
        return dao.findPublish();
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ArticleModel get(
            @RequestParam int id
    ){
        return dao.findOne(id);
    }
}