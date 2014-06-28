package com.xybb.mvc.repository;

import com.xybb.model.user.UserDetailedInfo;
import com.xybb.model.user.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by lw on 14-6-21.
 * 用户详细信息dao
 */
@Repository
public interface UserDetailedInfoRository extends MongoRepository<UserDetailedInfo, String> {


}
