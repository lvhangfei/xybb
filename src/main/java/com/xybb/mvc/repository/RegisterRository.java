package com.xybb.mvc.repository;

import com.xybb.model.user.UserInfo;
import com.xybb.model.user.UserRegister;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by lw on 14-6-21.
 * 用户dao
 */
@Repository
public interface RegisterRository extends MongoRepository<UserRegister, String> {

    @Query("{'name':?0,'password':?1}")
    public UserInfo getUserByNameAndPassword(String name, String password);

}
