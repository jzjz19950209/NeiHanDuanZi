package com.example.qf.neihanduanzi;


import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by qf on 2016/10/31.
 */
public class MyUtil {
    public static String numberFormat(int num){
        int a=num/10000;
        int b=num/1000%10;
        int c=num/100%10;
        if (a>0){
            if (c>=5){
                if (b==9){
                    a+=1;
                }else {
                    b+=1;
                }
            }
            return ""+a+"."+b+"万";
        }else {
            return ""+num;
        }
    }
    public static String timeFormat(long time){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar=Calendar.getInstance();
        long currentTime=calendar.getTimeInMillis()/1000;
        //86400000
//        if (currentTime-time>86400){
//            return sdf.format(time*1000);
//        }else if (currentTime-time>14400){
//            return ""+(currentTime-time)/60/60+"小时前";
//        }else {
//            return ""+(currentTime-time)/60+"分钟前";
//        }
        return sdf.format(time*1000);
    }

}
