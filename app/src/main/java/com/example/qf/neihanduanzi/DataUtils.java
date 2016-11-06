package com.example.qf.neihanduanzi;

import java.util.List;

/**
 * Created by qf on 2016/10/31.
 */
public class DataUtils {
    public static List<UserBean> list_user;
    public static List<UserBean> list_comment;
    public static String group_id;
    public static int clickPosition;
    public static String DATA_USER_URL="http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-102&message_cursor=-1&longitude=113.33532251171&latitude=23.17884882794&am_longitude=113.340813&am_latitude=23.176698&am_city=%E5%B9%BF%E5%B7%9E%E5%B8%82&am_loc_time=1478049674537&count=30&min_time=1478049627&screen_width=1080&iid=5808130102&device_id=26932466095&ac=wifi&channel=ucad&aid=7&app_name=joke_essay&version_code=560&version_name=5.6.0&device_platform=android&ssmix=a&device_type=A0001&device_brand=ONEPLUS&os_api=18&os_version=4.3&uuid=864587027568782&openudid=98d04341e03b52e7&manifest_version_code=560&resolution=1080*1920&dpi=480&update_version_code=5603";
    public static String DATA_COMMENT_URL="http://isub.snssdk.com/neihan/comments/?group_id=%d&count=50&offset=0";
    public static String DATA_VIDEO_URL="http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-104&message_cursor=-1&am_longitude=113.340751&am_latitude=23.176658&";
}
