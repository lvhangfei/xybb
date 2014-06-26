package com.xybb.model.forum;

import com.xybb.model.user.UserInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by lw on 14-6-19.
 * 帖子内容
 */
@Component
//@CompoundIndex(name = "blocked_inx", def = "{read_Num : 1, praise_Num : 1}")
public class Forum {

    @Id
    private String id;

    private String title;//标题
    private List<String> keyword;//关键字
    private String content;//内容

    private int read_Num;//阅读次数
    private int praise_Num;//被赞次数
    private int reply_Num;//回复次数
    private int Favorite_Num;//收藏次数


    @DBRef
    private Forum_Theme forum_theme;//所属主题
    @DBRef
    private Forum_Classify forum_classify;//所属分类
    @DBRef
    private UserInfo creator;//创建者

    private Date createTime;//创建时间

    private boolean isDel = false;//是否删除-逻辑删除

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRead_Num() {
        return read_Num;
    }

    public void setRead_Num(int read_Num) {
        this.read_Num = read_Num;
    }

    public int getPraise_Num() {
        return praise_Num;
    }

    public void setPraise_Num(int praise_Num) {
        this.praise_Num = praise_Num;
    }

    public int getReply_Num() {
        return reply_Num;
    }

    public void setReply_Num(int reply_Num) {
        this.reply_Num = reply_Num;
    }

    public int getFavorite_Num() {
        return Favorite_Num;
    }

    public void setFavorite_Num(int favorite_Num) {
        Favorite_Num = favorite_Num;
    }

    public Forum_Theme getForum_theme() {
        return forum_theme;
    }

    public void setForum_theme(Forum_Theme forum_theme) {
        this.forum_theme = forum_theme;
    }

    public Forum_Classify getForum_classify() {
        return forum_classify;
    }

    public void setForum_classify(Forum_Classify forum_classify) {
        this.forum_classify = forum_classify;
    }

    public UserInfo getCreator() {
        return creator;
    }

    public void setCreator(UserInfo creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean isDel) {
        this.isDel = isDel;
    }
}
