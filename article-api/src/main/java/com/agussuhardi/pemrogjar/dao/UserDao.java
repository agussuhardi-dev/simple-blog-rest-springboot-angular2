package com.agussuhardi.pemrogjar.dao;

import com.agussuhardi.pemrogjar.entity.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by agussuhardi on 02/12/16.
 */
public interface UserDao extends PagingAndSortingRepository<UserModel, String> {

    //login
    @Query("select u from UserModel u where u.userName= :userName AND u.password= :password")
    UserModel login(
            @Param("userName") String userName,
            @Param("password") String password
    );
}
