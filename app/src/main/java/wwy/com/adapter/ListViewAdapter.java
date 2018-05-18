package wwy.com.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.w4lle.library.NineGridlayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import wwy.com.R;
import wwy.com.bean.Group;
import wwy.com.cust_view.CusListView;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ArrayList<HashMap<String, Object>>> mList;
    private Context mContext;
    private List<Group> list;

    public ListViewAdapter(ArrayList<ArrayList<HashMap<String, Object>>> mList, Context mContext, List<Group> list) {
        super();
        this.mList = mList;
        this.mContext = mContext;
        this.list = list;
    }
    @Override
    public int getCount() {
        if (mList == null) {
            return 0;
        } else {
            return this.mList.size();
        }
    }
    @Override
    public Object getItem(int position) {
        if (mList == null) {
            return null;
        } else {
            return this.mList.get(position);
        }
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from
                    (this.mContext).inflate(R.layout.listview_item, null, false);
            holder.imageView = convertView.findViewById(R.id.listview_item_imageview);
//            holder.gridViewView = convertView.findViewById(R.id.listview_item_gridview);
            holder.cus_listView = convertView.findViewById(R.id.cus_listView);
            holder.iv_prise = convertView.findViewById(R.id.iv_prise);
            holder.iv_review = convertView.findViewById(R.id.iv_review);
            holder.tv_sayToCount = convertView.findViewById(R.id.tv_sayToCount);
            holder.nineGridlayout = convertView.findViewById(R.id.iv_ngrid_layout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (this.mList != null) {
            // 说说的文字内容
            if (holder.tv_sayToCount != null){
                holder.tv_sayToCount.setText("2018平昌冬奥会圆满结束，此刻你是什么心情？快来跟大家分享一下呗？");
            }
            // 每个说说的用户头像
            if (holder.imageView != null) {
                holder.imageView.setImageDrawable
                        (mContext.getResources().getDrawable(R.drawable.doctor_no_icon));
            }
            // 每个说说中的图片集合
            if (holder.nineGridlayout != null) {
                ArrayList<HashMap<String, Object>> arrayListForEveryGridView = this.mList.get(position);

                NineAdapter nineAdapter = new NineAdapter(mContext,arrayListForEveryGridView);
                holder.nineGridlayout.setAdapter(nineAdapter);
                holder.nineGridlayout.setOnItemClickListerner(new NineGridlayout.OnItemClickListerner() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("onItemClick","-点击--->  " + position);
                        Toast.makeText(mContext,position+"", Toast.LENGTH_SHORT).show();
                    }
                });

            }
            // 每个说说中的下面的评论列表
            if (holder.cus_listView != null && list.size() > 0){
                Group item = list.get(position);
                holder.cus_listView.setList(item.getMembers());
                holder.cus_listView.setOnItemClickListener(new CusListView.OnItemClickListener() {
                    @Override
                    public void setCusOnItemClick(int positiion) {
                        Toast.makeText(mContext,positiion+"  被点击", Toast.LENGTH_SHORT).show();
                        Log.i("setCusOnItemClick","----1---------->  " + positiion);
                    }
                });
            }
            final ViewHolder finalHolder = holder;
            holder.iv_prise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finalHolder.iv_prise.setImageResource(R.mipmap.icon_praise_selected);
                    Log.i("iv_prise","-------------> 点赞" );
                }
            });
            holder.iv_review.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("iv_prise","-------------> 评论" );
                }
            });
        }
        return convertView;
    }

    private class ViewHolder {
        ImageView imageView,iv_prise,iv_review;
//        GridView gridView;
        CusListView cus_listView;
        TextView tv_sayToCount;
        NineGridlayout nineGridlayout;
    }
}
