package wwy.com.listview_add_listView;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import wwy.com.R;
import wwy.com.adapter.TestAdapter;
import wwy.com.bean.Group;
import wwy.com.bean.User;
/**
 *  *Created by wwy on 2018/5/18.
 */
public class ListMainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Group> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        initData();
        listView = findViewById(R.id.listView);
        TestAdapter adapter = new TestAdapter(this, list);
        listView.setAdapter(adapter);
    }

    /**
     * 模拟数据
     */
    private void initData() {
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

}

