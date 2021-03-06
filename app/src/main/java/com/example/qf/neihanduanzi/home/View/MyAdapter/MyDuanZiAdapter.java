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

import org.lenve.customshapeimageview.CustomShapeImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qf on 2016/10/15.
 */
public class MyDuanZiAdapter extends BaseAdapter {
    private List<UserBean> list;
    private Context context;
    private LayoutInflater inflater;
    private final static int NORMAL_ONCOMMENT=1;
    private final static int NORMAL_COMMENT=2;
    private final static int ANONYMITY_NOCOMMENT=3;
    private final static int ANONYMITY_COMMENT=4;
    private int state_1=1;
    private int state_2=1;
    private int state_3=1;
    private int state_4=1;
    public MyDuanZiAdapter(List<UserBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        UserBean userBean=list.get(position);
        int type=userBean.getType();
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return 5;
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
        Type1Holder type1Holder=null;
        Type2Holder type2Holder=null;
        Type3Holder type3Holder=null;
        Type4Holder type4Holder=null;
        int itemViewType=getItemViewType(position);
        if (convertView==null){
            switch (itemViewType){
                case NORMAL_ONCOMMENT:
                    convertView=inflater.inflate(R.layout.content_item_duanzi,parent,false);
                    type1Holder=new Type1Holder(convertView);
                    convertView.setTag(type1Holder);
                    break;
                case NORMAL_COMMENT:
                    convertView=inflater.inflate(R.layout.content_item_duanzi_comments,parent,false);
                    type2Holder=new Type2Holder(convertView);
                    convertView.setTag(type2Holder);
                    break;
                case ANONYMITY_NOCOMMENT:
                    convertView=inflater.inflate(R.layout.content_item_duanzi_anonymity,parent,false);
                    type3Holder=new Type3Holder(convertView);
                    convertView.setTag(type3Holder);
                    break;
                case ANONYMITY_COMMENT:
                    convertView=inflater.inflate(R.layout.content_item_duanzi_anonymity_comment,parent,false);
                    type4Holder=new Type4Holder(convertView);
                    convertView.setTag(type4Holder);
                    break;
            }

        }else {
            switch (itemViewType){
                case NORMAL_ONCOMMENT:
                    type1Holder= (Type1Holder) convertView.getTag();
                    break;
                case NORMAL_COMMENT:
                    type2Holder= (Type2Holder) convertView.getTag();
                    break;
                case ANONYMITY_NOCOMMENT:
                    type3Holder= (Type3Holder) convertView.getTag();
                    break;
                case ANONYMITY_COMMENT:
                    type4Holder= (Type4Holder) convertView.getTag();
                    break;
            }
        }
        final UserBean userBean=list.get(position);
        switch (itemViewType){
            case NORMAL_ONCOMMENT:
                Picasso.with(context).load(userBean.getAvatar_url()).into(type1Holder.icon);
                type1Holder.username.setText(userBean.getUsername());
                type1Holder.content.setText(userBean.getContent());
                type1Holder.category_name.setText(userBean.getCategory_name());
                type1Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()));
                type1Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()));
                type1Holder.hot.setText(MyUtil.numberFormat(userBean.getComment_count()));
                type1Holder.share.setText(MyUtil.numberFormat(userBean.getShare_count()));
                if (position==19){
                    type1Holder.refresh_text.setVisibility(View.VISIBLE);
                }else {
                    type1Holder.refresh_text.setVisibility(View.GONE);
                }
                final Type1Holder finalType1Holder = type1Holder;
                type1Holder.image_zan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (state_1==1){
                            finalType1Holder.image_zan.setImageResource(R.drawable.ic_digg_pressed);
                            finalType1Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()+1));
                            state_1=2;
                        }else if (state_1==2){
                            finalType1Holder.image_zan.setImageResource(R.drawable.ic_digg_normal);
                            finalType1Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()));
                            state_1=1;
                        }
                    }
                });
                type1Holder.imame_cai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (state_1==1){
                            finalType1Holder.imame_cai.setImageResource(R.drawable.ic_bury_pressed_night);
                            finalType1Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()+1));
                            state_1=3;
                        }else if (state_1==3){
                            finalType1Holder.imame_cai.setImageResource(R.drawable.ic_bury_normal);
                            finalType1Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()));
                            state_1=1;
                        }
                    }
                });
                break;
            case NORMAL_COMMENT:
                Picasso.with(context).load(userBean.getAvatar_url()).into(type2Holder.icon);
                Picasso.with(context).load(userBean.getAvatar_url_comment()).into(type2Holder.icon_comment);
                type2Holder.username.setText(userBean.getUsername());
                type2Holder.user_name.setText(userBean.getUser_name());
                type2Holder.content.setText(userBean.getContent());
                type2Holder.category_name.setText(userBean.getCategory_name());
                type2Holder.content_comment.setText(userBean.getText());
                type2Holder.zan.setText(MyUtil.numberFormat(userBean.getDigg_count_comment()));
                type2Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()));
                type2Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()));
                type2Holder.hot.setText(MyUtil.numberFormat(userBean.getComment_count()));
                type2Holder.share.setText(MyUtil.numberFormat(userBean.getShare_count()));
                if (position==19){
                    type2Holder.refresh_text.setVisibility(View.VISIBLE);
                }else {
                    type2Holder.refresh_text.setVisibility(View.GONE);
                }
                final Type2Holder finalType2Holder = type2Holder;
                type2Holder.image_zan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (state_2==1){
                            finalType2Holder.image_zan.setImageResource(R.drawable.ic_digg_pressed);
                            finalType2Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()+1));
                            state_2=2;
                        }else if (state_2==2){
                            finalType2Holder.image_zan.setImageResource(R.drawable.ic_digg_normal);
                            finalType2Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()));
                            state_2=1;
                        }
                    }
                });
                type2Holder.imame_cai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (state_2==1){
                            finalType2Holder.imame_cai.setImageResource(R.drawable.ic_bury_pressed_night);
                            finalType2Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()+1));
                            state_2=3;
                        }else if (state_2==3){
                            finalType2Holder.imame_cai.setImageResource(R.drawable.ic_bury_normal);
                            finalType2Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()));
                            state_2=1;
                        }
                    }
                });
                break;
            case ANONYMITY_NOCOMMENT:
                type3Holder.content.setText(userBean.getContent());
                type3Holder.category_name.setText(userBean.getCategory_name());
                type3Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()));
                type3Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()));
                type3Holder.hot.setText(MyUtil.numberFormat(userBean.getComment_count()));
                type3Holder.share.setText(MyUtil.numberFormat(userBean.getShare_count()));
                if (position==19){
                    type3Holder.refresh_text.setVisibility(View.VISIBLE);
                }else {
                    type3Holder.refresh_text.setVisibility(View.GONE);
                }
                final Type3Holder finalType3Holder = type3Holder;
                type3Holder.image_zan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (state_3==1){
                            finalType3Holder.image_zan.setImageResource(R.drawable.ic_digg_pressed);
                            finalType3Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()+1));
                            state_3=2;
                        }else if (state_3==2){
                            finalType3Holder.image_zan.setImageResource(R.drawable.ic_digg_normal);
                            finalType3Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()));
                            state_3=1;
                        }
                    }
                });
                type3Holder.imame_cai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (state_3==1){
                            finalType3Holder.imame_cai.setImageResource(R.drawable.ic_bury_pressed_night);
                            finalType3Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()+1));
                            state_3=3;
                        }else if (state_3==3){
                            finalType3Holder.imame_cai.setImageResource(R.drawable.ic_bury_normal);
                            finalType3Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()));
                            state_3=1;
                        }
                    }
                });
                break;
            case ANONYMITY_COMMENT:
                type4Holder.content.setText(userBean.getContent());
                type4Holder.category_name.setText(userBean.getCategory_name());
                type4Holder.user_name.setText(userBean.getUser_name());
                type4Holder.content_comment.setText(userBean.getText());
                Picasso.with(context).load(userBean.getAvatar_url_comment()).into(type4Holder.icon_comment);
                type4Holder.zan.setText(MyUtil.numberFormat(userBean.getDigg_count_comment()));
                type4Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()));
                type4Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()));
                type4Holder.hot.setText(MyUtil.numberFormat(userBean.getComment_count()));
                type4Holder.share.setText(MyUtil.numberFormat(userBean.getShare_count()));
                if (position==19){
                    type4Holder.refresh_text.setVisibility(View.VISIBLE);
                }else {
                    type4Holder.refresh_text.setVisibility(View.GONE);
                }
                final Type4Holder finalType4Holder = type4Holder;
                type4Holder.image_zan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (state_4==1){
                        finalType4Holder.image_zan.setImageResource(R.drawable.ic_digg_pressed);
                        finalType4Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()+1));
                        state_4=2;
                    }else if (state_4==2){
                        finalType4Holder.image_zan.setImageResource(R.drawable.ic_digg_normal);
                        finalType4Holder.up.setText(MyUtil.numberFormat(userBean.getDigg_count()));
                        state_4=1;
                    }
                }
            });
            type4Holder.imame_cai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (state_4==1){
                        finalType4Holder.imame_cai.setImageResource(R.drawable.ic_bury_pressed_night);
                        finalType4Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()+1));
                        state_4=3;
                    }else if (state_4==3){
                        finalType4Holder.imame_cai.setImageResource(R.drawable.ic_bury_normal);
                        finalType4Holder.down.setText(MyUtil.numberFormat(userBean.getBury_count()));
                        state_4=1;
                    }
                }
            });
                break;
        }
        return convertView;
    }
    class Type1Holder{
        @BindView(R.id.icon)
        CustomShapeImageView icon;
        @BindView(R.id.username)
        TextView username;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.category_name)
        TextView category_name;
        @BindView(R.id.up)
        TextView up;
        @BindView(R.id.down)
        TextView down;
        @BindView(R.id.hot)
        TextView hot;
        @BindView(R.id.share)
        TextView share;
        @BindView(R.id.refresh_text)
        TextView refresh_text;
        @BindView(R.id.image_zan)
        ImageView image_zan;
        @BindView(R.id.image_cai)
        ImageView imame_cai;
        public Type1Holder(View itemView){
            ButterKnife.bind(this,itemView);
        }
    }
    class Type2Holder{
        @BindView(R.id.icon)
        CustomShapeImageView icon;
        @BindView(R.id.icon_comment)
        CustomShapeImageView icon_comment;
        @BindView(R.id.username)
        TextView username;
        @BindView(R.id.username_comment)
        TextView user_name;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.category_name)
        TextView category_name;
        @BindView(R.id.content_comment)
        TextView content_comment;
        @BindView(R.id.zan)
        TextView zan;
        @BindView(R.id.share_comment)
        ImageView share_comment;
        @BindView(R.id.up)
        TextView up;
        @BindView(R.id.down)
        TextView down;
        @BindView(R.id.hot)
        TextView hot;
        @BindView(R.id.share)
        TextView share;
        @BindView(R.id.refresh_text)
        TextView refresh_text;
        @BindView(R.id.image_zan)
        ImageView image_zan;
        @BindView(R.id.image_cai)
        ImageView imame_cai;
        public Type2Holder(View itemView){
            ButterKnife.bind(this,itemView);
        }
    }
    class Type3Holder{
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.category_name)
        TextView category_name;
        @BindView(R.id.up)
        TextView up;
        @BindView(R.id.down)
        TextView down;
        @BindView(R.id.hot)
        TextView hot;
        @BindView(R.id.share)
        TextView share;
        @BindView(R.id.refresh_text)
        TextView refresh_text;
        @BindView(R.id.image_zan)
        ImageView image_zan;
        @BindView(R.id.image_cai)
        ImageView imame_cai;
        public Type3Holder(View itemView){
            ButterKnife.bind(this,itemView);
        }
    }
    class Type4Holder{
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.category_name)
        TextView category_name;
        @BindView(R.id.username_comment)
        TextView user_name;
        @BindView(R.id.content_comment)
        TextView content_comment;
        @BindView(R.id.icon_comment)
        CustomShapeImageView icon_comment;
        @BindView(R.id.zan)
        TextView zan;
        @BindView(R.id.share_comment)
        ImageView share_comment;
        @BindView(R.id.up)
        TextView up;
        @BindView(R.id.down)
        TextView down;
        @BindView(R.id.hot)
        TextView hot;
        @BindView(R.id.share)
        TextView share;
        @BindView(R.id.refresh_text)
        TextView refresh_text;
        @BindView(R.id.image_zan)
        ImageView image_zan;
        @BindView(R.id.image_cai)
        ImageView imame_cai;
        public Type4Holder(View itemView){
            ButterKnife.bind(this,itemView);
        }
    }
}
