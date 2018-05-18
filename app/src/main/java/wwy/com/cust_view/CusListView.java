package wwy.com.cust_view;


import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import wwy.com.R;
import wwy.com.bean.User;


public class CusListView extends LinearLayout {

    public CusListView(Context context) {
        this(context, null);
    }

    public CusListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CusListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
    }

    public void setList(List<User> list) {
        if (list == null) {
            throw new RuntimeException("list is null");
        }
        int count = list.size();
        removeAllViews();
        for (int i = 0; i < count; i++) {
            User user = list.get(i);
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_nested_item, null);
            final TextView tv_name = f(view, R.id.tv_name);
            TextView tv_age = f(view, R.id.tv_age);
            LinearLayout item = f(view,R.id.list_item);
            String strContent ;
            // 处理评论列表中单个TextView 中文字颜色处理
            if ((i % 2) == 0){
                strContent = "<font color='#296eaf'>" +user.getUserName()+ "</font>" + "  <font color='#b2b2b2'>回复</font>  " + "不错哦";
            }else {
                strContent = "<font color='#296eaf'>" +user.getUserName()+ "</font>" + "  <font color='#b2b2b2'>回复</font>  "+"<font color='#296eaf'> 张三"+ i +" </font>"  + "不错哦";
            }

            tv_name.setText(Html.fromHtml(strContent));
            tv_age.setText(user.getUserAge() + "");
            final int position = i;
//            // 设置每个item 的点击事件时，当手指按下时改变其背景颜色，抬起时取消背景颜色,手指移动时也取消背景色
//            item.setOnTouchListener(new OnTouchListener() {
//                @Override
//                public boolean onTouch(View view, MotionEvent motionEvent) {
//                    switch (motionEvent.getAction()){
//                        case MotionEvent.ACTION_DOWN:
//                            tv_name.setBackgroundColor(getResources().getColor(R.color.colorDark));
//                            break;
//                        case MotionEvent.ACTION_UP:
//                            tv_name.setBackgroundColor(getResources().getColor(R.color.colorWrite));
//                            break;
//                        case MotionEvent.ACTION_MOVE:
//                            tv_name.setBackgroundColor(getResources().getColor(R.color.colorWrite));
//                            break;
//                    }
//                    return false;
//                }
//            });

            item.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.setCusOnItemClick(position);

                }
            });
            addView(view);
        }

    }

    private <T extends View> T f(View view, int id) {
        return (T) view.findViewById(id);
    }

    OnItemClickListener itemClickListener;

    public interface OnItemClickListener{
        void setCusOnItemClick(int positiion);
    }
    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
}

