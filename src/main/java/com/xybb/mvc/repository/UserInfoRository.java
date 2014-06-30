package com.xybb.mvc.repository;

import com.xybb.model.user.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by lw on 14-6-21.
 * 用户dao
 */
@Repository
public interface UserInfoRository extends MongoRepository<UserInfo, String>, UserInfoRositoryTailored {

    @Query("{'emailName':?0}")
    public UserInfo getUserByEmailName(String emailName);

    @Query("{'emailName':?0,'password':?1}")
    public UserInfo getUserByEmailNameAndPassword(String emailName, String password);

    @Query("{'cookie':?0}")
    public UserInfo getUserByCookie(String cookie);

    @Query("{'userDetailedInfo':{'$ref':'userDetailedInfo', '$id':{'$oid':?0}}}")
    public UserInfo getUserByUserDetailedInfoId(String userDetailedInfoId);

}
