package com.example.qf.neihanduanzi;

/**
 * Created by qf on 2016/10/14.
 */
public class UserBean {
    private String username;
    private String avatar_url;//用户头像

    private int digg_count;//赞
    private int bury_count;//踩
    private String id;
    private String share_url;
    private String content;//正文
    private int comment_count;//评论数
    private int share_count;
    private String category_name;

    private String avatar_url_comment;//评论用户头像
    private String user_name;//评论用户名
    private String text;//评论内容
    private int digg_count_comment;//评论用户赞
    private String share_url_comment;//分享用户神评

    private int type;//item类型
    private long createTime;//评论时间
    private int total_number;//新鲜评论的总数

    public UserBean() {
    }

    public UserBean(String username, String avatar_url, int digg_count, int bury_count, String id, String share_url, String content, int comment_count, int share_count, String category_name) {
        this.username = username;
        this.avatar_url = avatar_url;
        this.digg_count = digg_count;
        this.bury_count = bury_count;
        this.id = id;
        this.share_url = share_url;
        this.content = content;
        this.comment_count = comment_count;
        this.share_count = share_count;
        this.category_name = category_name;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public String getAvatar_url_comment() {
        return avatar_url_comment;
    }

    public void setAvatar_url_comment(String avatar_url_comment) {
        this.avatar_url_comment = avatar_url_comment;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDigg_count_comment() {
        return digg_count_comment;
    }

    public void setDigg_count_comment(int digg_count_comment) {
        this.digg_count_comment = digg_count_comment;
    }

    public String getShare_url_comment() {
        return share_url_comment;
    }

    public void setShare_url_comment(String share_url_comment) {
        this.share_url_comment = share_url_comment;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "username='" + username + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", digg_count=" + digg_count +
                ", bury_count=" + bury_count +
                ", id='" + id + '\'' +
                ", share_url='" + share_url + '\'' +
                ", content='" + content + '\'' +
                ", comment_count=" + comment_count +
                ", share_count=" + share_count +
                ", category_name='" + category_name + '\'' +
                ", avatar_url_comment='" + avatar_url_comment + '\'' +
                ", user_name='" + user_name + '\'' +
                ", text='" + text + '\'' +
                ", digg_count_comment=" + digg_count_comment +
                ", share_url_comment='" + share_url_comment + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", total_number=" + total_number +
                '}';
    }
}
