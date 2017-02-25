package com.example.qf.neihanduanzi.home.View.Fragment_item;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qf.neihanduanzi.DataUtils;
import com.example.qf.neihanduanzi.MyUtil;
import com.example.qf.neihanduanzi.R;
import com.example.qf.neihanduanzi.UserBean;
import com.example.qf.neihanduanzi.home.View.MyAdapter.MyListViewAdapter;
import com.example.qf.neihanduanzi.home.View.MyListView;
import com.example.qf.neihanduanzi.home.presenter.Home_comment_Presenter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by qf on 2016/10/31.
 */
public class Details_Fragment extends Fragment implements IDetailsView{
    private View view;
    private TextView username,content,cayegory_name,up,down,hot,share;
    private ImageView icon;
    public ImageView noComment;
    public TextView details_refresh;
    private UserBean userBean_user;
    private Button guanzhu;
    private int id;
    private TextView total_number;
    private MyListViewAdapter adapter;
    private MyListView myListView;
    private boolean b=false;
    private Home_comment_Presenter home_comment_presenter=new Home_comment_Presenter(this);
    public static Details_Fragment getInstance(int id){
        Details_Fragment details_Fragment=new Details_Fragment();
        details_Fragment.id=id;
        return details_Fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view=getActivity().getLayoutInflater().inflate(R.layout.details_fragment_content,null);
        initView(view);
        home_comment_presenter.initData(id);
        details_refresh.setVisibility(View.VISIBLE);
        userBean_user = DataUtils.list_user.get(id);
        switch (userBean_user.getType()){
            case 1:
            case 2:
                username.setText(userBean_user.getUsername());
                Picasso.with(getContext()).load(userBean_user.getAvatar_url()).into(icon);
                break;
            case 3:
            case 4:
                username.setText("匿名用户");
                guanzhu.setVisibility(View.GONE);
                username.setTextColor(getResources().getColor(R.color.colorAnonymity));
                icon.setVisibility(View.GONE);
                break;
        }
        content.setText(userBean_user.getContent());
        cayegory_name.setText(userBean_user.getCategory_name());
        up.setText(MyUtil.numberFormat(userBean_user.getDigg_count()));
        down.setText(MyUtil.numberFormat(userBean_user.getBury_count()));
        hot.setText(MyUtil.numberFormat(userBean_user.getComment_count()));
        share.setText(MyUtil.numberFormat(userBean_user.getShare_count()));
        guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!b){
                    guanzhu.setText("已关注");
                    Toast.makeText(getContext(), "已关注", Toast.LENGTH_SHORT).show();
                    b=true;
                }else {
                    guanzhu.setText("关注");
                    Toast.makeText(getContext(), "取消关注", Toast.LENGTH_SHORT).show();
                    b=false;
                }

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return view;
    }
    private void initView(View view){
        username= (TextView) view.findViewById(R.id.username);
        icon= (ImageView) view.findViewById(R.id.icon);
        content= (TextView) view.findViewById(R.id.content);
        cayegory_name= (TextView) view.findViewById(R.id.category_name);
        up= (TextView) view.findViewById(R.id.up);
        down= (TextView) view.findViewById(R.id.down);
        hot= (TextView) view.findViewById(R.id.hot);
        share= (TextView) view.findViewById(R.id.share);
        myListView= (MyListView) view.findViewById(R.id.lv_comment);
        total_number= (TextView) view.findViewById(R.id.total_number);
        noComment= (ImageView) view.findViewById(R.id.onComment);
        details_refresh= (TextView) view.findViewById(R.id.details_refresh);
        guanzhu= (Button) view.findViewById(R.id.guanzhu);
    }

    @Override
    public void initCommentData(List<UserBean> list) {
       // Log.d("jzjz", "initCommentData: "+list.toString());
        DataUtils.map.put(id,list);
        total_number.setText("新鲜评论"+"("+list.size()+")");
        adapter=new MyListViewAdapter(DataUtils.map.get(id),getContext());
        myListView.setAdapter(adapter);
    }
    public void refreshData(){
        adapter.notifyDataSetChanged();
    }
}
