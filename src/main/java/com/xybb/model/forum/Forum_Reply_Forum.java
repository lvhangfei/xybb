package com.xybb.model.forum;

/**
 * Created by lw on 14-6-19.
 * 帖子回复-帖子直接回复
 */
public class Forum_Reply_Forum extends Abstract_Forum_Reply {

    private int praise_Num = 1;//回复被赞次数
    private boolean isOtherUserRead = true;//是否让他人看到对帖子回复-默认为true

    public int getPraise_Num() {
        return praise_Num;
    }

    public void setPraise_Num(int praise_Num) {
        this.praise_Num = praise_Num;
    }

    public boolean isOtherUserRead() {
        return isOtherUserRead;
    }

    public void setOtherUserRead(boolean isOtherUserRead) {
        this.isOtherUserRead = isOtherUserRead;
    }
}
