package com.agussuhardi.pemrogjar.controller;

import com.agussuhardi.pemrogjar.dao.ArticleDao;
import com.agussuhardi.pemrogjar.dao.HistoryDao;
import com.agussuhardi.pemrogjar.entity.ArticleModel;
import com.agussuhardi.pemrogjar.entity.HistoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by agussuhardi on 30/11/16.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/history")
public class HistoryController {


    @Autowired
    private HistoryDao dao;

    @Autowired
    ArticleDao articleDao;

    @RequestMapping(value = "gets", method = RequestMethod.GET)
    public Iterable<ArticleModel> gets(
            @RequestParam String username
    ){
        return articleDao.findByUserName(username);
    }

    @RequestMapping(value = "gets/id", method = RequestMethod.GET)
    public Iterable<HistoryModel> getIds(
            @RequestParam int id
    ){
                return dao.findHistoryByArticleId(id);
    }



    @RequestMapping(value = "get", method = RequestMethod.GET)
    public HistoryModel get(
            @RequestParam int id
    ){
                return dao.findOne(id);
    }

}
