package com.xybb.mvc.repository;

import com.xybb.model.user.UserRegister;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lw on 14-6-21.
 * 用户临时注册记录
 */
@Repository
public interface RegisterRository extends MongoRepository<UserRegister, String> {

    @Query("{'emailName':?0 ,'tag':?1}")
    public UserRegister getUserByEmailName(String emailName, String tag);

    @Query("{'registerTime':{'$lt':?0}}")
    public List<UserRegister> getUserRegistersByTime(long now);

}
