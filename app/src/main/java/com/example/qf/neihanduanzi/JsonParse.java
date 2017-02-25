package com.example.qf.neihanduanzi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qf on 2016/10/14.
 */
public class JsonParse {
    public static List<UserBean> parseJsonList(String json){
        List<UserBean> list=new ArrayList<>();
        UserBean userBean = null;
        try {
            JSONObject jsonObject1=new JSONObject(json).getJSONObject("data");
            JSONArray data=jsonObject1.getJSONArray("data");
            for(int i=0;i<data.length();i++){
                JSONObject jsonObject2=data.getJSONObject(i);
                if(!jsonObject2.has("ad")&&!jsonObject2.has("data")) {
                    JSONObject group=jsonObject2.getJSONObject("group");
                    String group_id=group.getString("group_id");
                    String share_url=group.getString("share_url");
                    String content=group.getString("content");
                    int comment_count=group.getInt("comment_count");
                    int share_count=group.getInt("share_count");
                    int digg_count=group.getInt("digg_count");
                    int bury_count=group.getInt("bury_count");
                    String category_name=group.getString("category_name");
                    JSONObject user=group.getJSONObject("user");
                    String username=user.getString("name");
                    String avatar_url=user.getString("avatar_url");
                    int type;
                    String avatar_url_comment=null;
                    String user_name=null;
                    String text=null;
                    int digg_count_comment=0;
                    String share_url_comment=null;
                    userBean=new UserBean(username,avatar_url,digg_count,bury_count,group_id,share_url,content,comment_count,share_count,category_name);
                    if (jsonObject2.getJSONArray("comments").length() ==0) {
                        if (username.equals("匿名用户")){
                            type=3;
                        }else {
                            type=1;
                        }
                    }else {
                        JSONArray comments_Arr=jsonObject2.getJSONArray("comments");
                        JSONObject comments=comments_Arr.getJSONObject(0);
                        avatar_url_comment=comments.getString("avatar_url");
                        user_name=comments.getString("user_name");
                        text=comments.getString("text");
                        digg_count_comment=comments.getInt("digg_count");
                        share_url_comment=comments.getString("share_url");
                        if (username.equals("匿名用户")){
                            type=4;
                        }else {
                            type=2;
                        }
                    }
                    userBean.setType(type);
                    userBean.setAvatar_url_comment(avatar_url_comment);
                    userBean.setUser_name(user_name);
                    userBean.setText(text);
                    userBean.setDigg_count_comment(digg_count_comment);
                    userBean.setShare_url_comment(share_url_comment);
                    userBean.setId(group_id);
                }
                if(!list.contains(userBean)){
                    list.add(userBean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return list;
    }

    public static List<UserBean> parseJson2List(String json){
        List<UserBean> list=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(json);
            int total_number=jsonObject.getInt("total_number");
            JSONObject data=jsonObject.getJSONObject("data");
            JSONArray  recent_comments=data.getJSONArray("recent_comments");
            for (int i=0;i<recent_comments.length();i++){
                JSONObject item=recent_comments.getJSONObject(i);
                UserBean userBean=new UserBean();
                String user_name=item.getString("user_name");
                String user_profile_image_url=item.getString("user_profile_image_url");
                int digg_count=item.getInt("digg_count");
                String share_url=item.getString("share_url");
                long create_time=item.getLong("create_time");
                String text=null;
                if (item.has("reply_comments")){
                    JSONArray jsonArray=item.getJSONArray("reply_comments");
                    JSONObject jo=jsonArray.getJSONObject(0);
                    String reply_user_name=jo.getString("user_name");
                    String reply_text=jo.getString("text");
                    text=item.getString("text")+"//@"+reply_user_name+"："+reply_text;
                }else {
                    text=item.getString("text");
                }
                userBean.setTotal_number(total_number);
                userBean.setUsername(user_name);
                userBean.setAvatar_url(user_profile_image_url);
                userBean.setDigg_count(digg_count);
                userBean.setShare_url(share_url);
                userBean.setCreateTime(create_time);
                userBean.setContent(text);
                list.add(userBean);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<VideoBean> parseJson3List(String json){
        List<VideoBean> list=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONArray data=jsonObject.getJSONObject("data").getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject jsonObject1=data.getJSONObject(i);
                if (!jsonObject1.has("ad")&&!jsonObject1.has("data")) {
                    JSONObject group = jsonObject1.getJSONObject("group");
                    String text = group.getString("text");
                    JSONObject video_720p = group.getJSONObject("720p_video");
                    int width = video_720p.getInt("width");
                    int height = video_720p.getInt("height");
                    JSONArray url_list = video_720p.getJSONArray("url_list");
                    String url = url_list.getJSONObject(0).getString("url");
                    int digg_count = group.getInt("digg_count");
                    int comment_count = group.getInt("comment_count");
                    int bury_count = group.getInt("bury_count");
                    int share_count=group.getInt("share_count");
                    JSONObject user=group.getJSONObject("user");
                    String name=user.getString("name");
                    String userIcon=user.getString("avatar_url");
                    VideoBean videoBean=new VideoBean();
                    videoBean.setUserIcon(userIcon);
                    videoBean.setContent(text);
                    videoBean.setBury_count(bury_count);
                    videoBean.setDigg_count(digg_count);
                    videoBean.setUserName(name);
                    videoBean.setWidth(width);
                    videoBean.setHeight(height);
                    videoBean.setShare_count(share_count);
                    list.add(videoBean);
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
