package com.example.qf.neihanduanzi.home.View;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qf.neihanduanzi.DataUtils;
import com.example.qf.neihanduanzi.R;
import com.example.qf.neihanduanzi.UserBean;
import com.example.qf.neihanduanzi.home.View.Fragment_item.Details_Fragment;
import com.example.qf.neihanduanzi.home.View.MyAdapter.DetailsAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Duanzi_details_Activity extends AppCompatActivity {
    private List<Details_Fragment> details_fragments;
    private ViewPager viewPager;
    private RelativeLayout inputComment, relativeLayout;
    private TextView tt;
    private Button queding;
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duanzi_details);
        viewPager = (ViewPager) findViewById(R.id.details_pager);
        inputComment = (RelativeLayout) findViewById(R.id.input_comment);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        queding = (Button) findViewById(R.id.queding);
        edit = (EditText) findViewById(R.id.edit);
        tt = (TextView) findViewById(R.id.tt);
        details_fragments = new ArrayList<>();
        initFragment();
        final DetailsAdapter adapter = new DetailsAdapter(getSupportFragmentManager(), details_fragments);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(DataUtils.clickPosition);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                DataUtils.clickPosition=position;
                DataUtils.group_id=DataUtils.list_user.get(DataUtils.clickPosition).getId();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        inputComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tt.setVisibility(View.GONE);
                edit.setVisibility(View.VISIBLE);
                //edit.setFocusable(true);
                queding.setVisibility(View.VISIBLE);

            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tt.setVisibility(View.VISIBLE);
//                edit.setFocusable(false);
//                edit.setVisibility(View.GONE);
//                queding.setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                edit.setVisibility(View.GONE);
                tt.setVisibility(View.VISIBLE);
                queding.setVisibility(View.GONE);
            }
        });
        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                edit.setVisibility(View.GONE);
                tt.setVisibility(View.VISIBLE);
                queding.setVisibility(View.GONE);
                int currentItem = viewPager.getCurrentItem();
                Calendar calendar = Calendar.getInstance();
                long currentTime = calendar.getTimeInMillis();
                List<UserBean> list_comment = new ArrayList<UserBean>();
                UserBean userBean = new UserBean();
                userBean.setUsername("  我");
                userBean.setCreateTime(currentTime / 1000);
                userBean.setAvatar_url_comment("http://p9.pstatp.com/thumb/ef70012ab7cd8479e93");
                userBean.setContent(edit.getText().toString());
//                list_comment.add(userBean);
//                list_comment.addAll(DataUtils.list_comment);
//                DataUtils.list_comment=list_comment;
                if (edit.getText().toString() != null && !edit.getText().toString().equals("")) {
                    DataUtils.map.get(currentItem).add(0, userBean);
                    details_fragments.get(currentItem).refreshData();
                }
                edit.setText("");

            }
        });

    }
    private void initFragment(){
        Details_Fragment details_fragment_temp;
        for (int i = 0; i< DataUtils.list_user.size(); i++){
            details_fragment_temp=Details_Fragment.getInstance(i);
            details_fragments.add(details_fragment_temp);
        }
    }

    public void back(View view) {
        onBackPressed();
    }

}
