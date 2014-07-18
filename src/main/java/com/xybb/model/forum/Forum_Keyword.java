package com.xybb.model.forum;

import com.xybb.model.area.Area;
import com.xybb.model.area.City;
import com.xybb.model.area.School;
import com.xybb.model.user.UserInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by lw on 14-6-21.
 * 帖子--发布细节--关键字--建立搜索引擎
 * ---------------
 * 使用户可以快速查询
 */
public class Forum_Keyword {

    @Id
    private String id;

    @DBRef
    private Forum forum;//帖子Id
    private String forum_Title;//帖子标题
    @DBRef
    private UserInfo userInfo;//帖子-发布人
    @DBRef
    private School school;//帖子-发布的学校
    @DBRef
    private Area area;//帖子-发布的地区
    @DBRef
    private City city;//帖子-发布的市

    private List<String> keywords;//帖子自定义-关键字

}
