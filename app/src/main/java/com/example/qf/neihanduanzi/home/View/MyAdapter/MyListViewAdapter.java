package com.example.qf.neihanduanzi.home.View.MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qf.neihanduanzi.MyUtil;
import com.example.qf.neihanduanzi.R;
import com.example.qf.neihanduanzi.UserBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by qf on 2016/11/2.
 */
public class MyListViewAdapter extends BaseAdapter {
    private List<UserBean> list;
    private Context context;
    private LayoutInflater inflater;

    public MyListViewAdapter(List<UserBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.comment_item, parent,false);
            viewHolder.details_comment_icon= (ImageView) convertView.findViewById(R.id.details_comment_icon);
            viewHolder.details_username= (TextView) convertView.findViewById(R.id.details_username);
            viewHolder.create_time= (TextView) convertView.findViewById(R.id.create_time);
            viewHolder.details_up= (TextView) convertView.findViewById(R.id.details_up);
            viewHolder.details_comment= (TextView) convertView.findViewById(R.id.details_comment);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        UserBean userBean=list.get(position);
        if (userBean.getAvatar_url()!=null&&!userBean.getAvatar_url().equals("")) {
            Picasso.with(context).load(userBean.getAvatar_url()).into(viewHolder.details_comment_icon);
        }else {
            Picasso.with(context).load(R.drawable.default_round_head).into(viewHolder.details_comment_icon);
        }
        viewHolder.details_username.setText(userBean.getUsername());
        viewHolder.create_time.setText(MyUtil.timeFormat(userBean.getCreateTime()));
        viewHolder.details_up.setText(MyUtil.numberFormat(userBean.getDigg_count()));
        viewHolder.details_comment.setText(userBean.getContent());
        return convertView;
    }
    class ViewHolder{
        TextView details_username,create_time,details_comment,details_up;
        ImageView details_comment_icon;
    }
}
