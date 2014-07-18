package com.xybb.mvc.repository;

import com.xybb.model.user.UserInfo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;

/**
 * Created by lw on 14-6-28.
 */
public class UserInfoRositoryImpl implements UserInfoRositoryTailored {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 删除用户的cookie记录
     *
     * @param id
     */
    public void del_CookieById(String id) {
        Query query = Query.query(Criteria.where("id").is(id));
        Update update = Update.update("cookie", null);
        mongoTemplate.updateFirst(query, update, UserInfo.class);
    }
}
