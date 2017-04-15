package com.agussuhardi.pemrogjar.dao;

import com.agussuhardi.pemrogjar.entity.HistoryModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by agussuhardi on 30/11/16.
 */
public interface HistoryDao extends PagingAndSortingRepository<HistoryModel, Integer>{
/*

    //get no dublicate data
    @Query ("SELECT DISTINCT h FROM HistoryModel h JOIN h.userName u where u.userName = :username")
    Iterable<HistoryModel> findAllNotDuplicateDataUser(
            @Param("username") String userName);



    @Query ("SELECT h FROM HistoryModel h JOIN h.article a JOIN h.userName u where a.id = :id_article AND u.userName= :user_name")
    Iterable<HistoryModel> findByArticleUser(
            @Param("id_article") int idArticle,
            @Param("user_name") String userName);




    //get History by user group article id
    @Query("SELECT h FROM HistoryModel h JOIN h.article ha WHERE h.userName.userName= :userName GROUP BY ha.id")
    Iterable<HistoryModel> findHistoryByUserGroupByArticle(
            @Param("userName") String userName
    );
*/


    //get History by user group article id
    //@Query("SELECT h FROM HistoryModel h JOIN h.article a WHERE a.id= :id")
    @Query("SELECT h FROM HistoryModel h WHERE h.article.id= :id ORDER BY h.updateDate DESC ")
    Iterable<HistoryModel> findHistoryByArticleId(
            @Param("id") int id
    );


    @Query("SELECT h FROM HistoryModel h WHERE h.id= :id")
    List<HistoryModel> findById(@Param("id") int id);













}