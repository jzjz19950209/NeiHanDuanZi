package com.example.qf.neihanduanzi;

/**
 * Created by qf on 2016/11/5.
 */
public class VideoBean {
    private String userName;
    private String userIcon;
    private String content;
    private String videoUrl;
    private String videoImage;
    private int digg_count;
    private int bury_count;
    private int commentCount;
    private int share_count;
    private String shareUrl;
    private String commentIcon;
    private String conmentName;
    private String commentContent;
    private int zan;
    private int width;
    private int height;

    @Override
    public String toString() {
        return "VideoBean{" +
                "userName='" + userName + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", content='" + content + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", videoImage='" + videoImage + '\'' +
                ", digg_count=" + digg_count +
                ", bury_count=" + bury_count +
                ", commentCount=" + commentCount +
                ", shareUrl='" + shareUrl + '\'' +
                ", commentIcon='" + commentIcon + '\'' +
                ", conmentName='" + conmentName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", zan=" + zan +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
    public void setShare_count(int i){
        share_count=i;
    }
    public int getShare_count(){
        return share_count;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
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

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getCommentIcon() {
        return commentIcon;
    }

    public void setCommentIcon(String commentIcon) {
        this.commentIcon = commentIcon;
    }

    public String getConmentName() {
        return conmentName;
    }

    public void setConmentName(String conmentName) {
        this.conmentName = conmentName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
