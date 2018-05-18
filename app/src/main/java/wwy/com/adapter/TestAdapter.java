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
import java.util.List;
import wwy.com.R;
import wwy.com.ViewHolder;
import wwy.com.bean.Group;
import wwy.com.cust_view.CusListView;

/**
 * --------------------------------------------
 * auther :  WWY
 * 2018/02/26 10:18
 * description ：
 * -------------------------------------------
 **/
public class TestAdapter extends BaseAdapter {

    private Context context;
    private List<Group> list;

    public TestAdapter(Context context, List<Group> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Group getItem(int i) {
        return list == null ? null : list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 注意item布局中的跟布局添加：android:descendantFocusability="blocksDescendants"  防止其它view拦截了item的点击事件触发
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_group, viewGroup, false);
        }
        ImageView img_head = ViewHolder.get(view,R.id.img_head);
        TextView tv_groupName = ViewHolder.get(view, R.id.tv_groupName);
        TextView tv_age  = ViewHolder.get(view,R.id.tv_age);
        CusListView listView = ViewHolder.get(view, R.id.cus_listView);

        Group item = getItem(i);
        img_head.setImageResource(R.mipmap.doctor);
        tv_groupName.setText(item.getGroupName());
        tv_age.setText(item.getGropAge());
        listView.setList(item.getMembers());
        listView.setOnItemClickListener(new CusListView.OnItemClickListener() {
            @Override
            public void setCusOnItemClick(int positiion) {
                Toast.makeText(context,"点击了 : " + positiion, Toast.LENGTH_SHORT).show();
                Log.i("setCusOnItemClick","-------------->  " + positiion);
            }
        });
        return view;
    }
}

