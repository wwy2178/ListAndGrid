package wwy.com.listview_add_gridandlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import wwy.com.R;
import wwy.com.adapter.ListViewAdapter;
import wwy.com.bean.Group;
import wwy.com.bean.User;

/**
 *  *Created by wwy on 2018/5/18.
 */
public class ListAddListAndGrid extends AppCompatActivity {

    private ListView mListView;
    private ListViewAdapter mListViewAdapter;
    private ArrayList<ArrayList<HashMap<String,Object>>> mArrayList;
    private List<Group> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_list_grid);

        init();
    }
    private void init(){
        mListView = findViewById(R.id.listView);
        initDataList();
        initData();
        mListViewAdapter=new ListViewAdapter(mArrayList, ListAddListAndGrid.this,list);
        mListView.setAdapter(mListViewAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListAddListAndGrid.this,"点击了：" + i,Toast.LENGTH_SHORT).show();
                Log.i("mListView","------------> " + i);
            }
        });
    }
    /**
     * 模拟listview中评论的listview的数据
     */
    private void initDataList() {
        for (int i = 0; i < 10; i++) {
            Group group = new Group();
            group.setGroupName("张三" + i);
            group.setGropAge("" + (i + 10));
            List<User> users = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                User user = new User();
                user.setUserAge(i + j);
                user.setUserName("李四" + i );
                users.add(user);
            }
            group.setMembers(users);
            list.add(group);
        }
    }
    /**
     * 模拟数据 GridView中的数据
     */
    private void initData(){
        mArrayList=new ArrayList<ArrayList<HashMap<String,Object>>>();
        HashMap<String, Object> hashMap=null;
        ArrayList<HashMap<String,Object>> arrayListForEveryGridView;

        for (int i = 0; i < 10; i++) {
            arrayListForEveryGridView=new ArrayList<HashMap<String,Object>>();
            for (int j = 0; j < 5; j++) {
                hashMap=new HashMap<String, Object>();
                hashMap.put("content", "i="+i+" ,j="+j);
                arrayListForEveryGridView.add(hashMap);
            }
            mArrayList.add(arrayListForEveryGridView);
        }

    }

}
