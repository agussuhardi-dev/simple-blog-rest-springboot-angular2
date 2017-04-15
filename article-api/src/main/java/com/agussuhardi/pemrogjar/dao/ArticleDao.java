package com.agussuhardi.pemrogjar.dao;

import com.agussuhardi.pemrogjar.entity.ArticleModel;
import com.agussuhardi.pemrogjar.entity.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Iterator;


/**
 * Created by agussuhardi on 26/11/16.
 */
public interface ArticleDao extends PagingAndSortingRepository<ArticleModel, Integer>{


    //search status != trash
    //@Query("select a from ArticleModel a where a.status <> :status AND a.userName = :username")
    @Query ("SELECT a FROM ArticleModel a JOIN a.userName au WHERE au.userName= :userName AND a.status <> 'trash' AND a.status <> 'delete' ORDER BY a.updateDate DESC ")
    Iterable<ArticleModel> findByUserNameNoTrashDeleteForeverYes(
            @Param("userName") String userName
    );



    //search by status
    @Query ("SELECT a FROM ArticleModel a JOIN a.userName au WHERE au.userName= :userName AND a.status= :status AND a.status <> 'delete' ORDER BY a.updateDate DESC ")
    Iterable<ArticleModel> findByUserNameStatusDeleteForeverYes(
            @Param("userName") String userName,
            @Param("status") String status
    );


    //search by status
    //@Query ("SELECT a FROM ArticleModel a " +
      //      "JOIN a.userName au " +
        //    "JOIN a.userAccessList al " +
          //  "WHERE al.userName.userName = :userName AND a.status='publish' AND a.status <> 'delete' AND au.userName <> :userName")
    @Query("SELECT a FROM ArticleModel a join a.userAccessList al WHERE al.userName = :userName AND a.userName <> :userName AND a.status <> 'trash' AND a.status <> 'private' ORDER BY a.updateDate DESC ")
    Iterable<ArticleModel> findByShare(
            @Param("userName") String userName
    );

    @Query("SELECT a FROM ArticleModel a WHERE a.userName.userName= :userName ORDER BY a.updateDate DESC ")
    Iterable<ArticleModel> findByUserName(
            @Param("userName") String userName
    );


    @Query("SELECT a FROM ArticleModel a where a.status = 'Published' ORDER BY a.updateDate DESC ")
    public Iterable<ArticleModel> findPublish();



}