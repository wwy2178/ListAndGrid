package wwy.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import wwy.com.bean.Group;
import wwy.com.listview_add_gridandlistview.ListAddListAndGrid;
import wwy.com.listview_add_listView.ListMainActivity;
/**
 *  *Created by wwy on 2018/5/18.
 */
/**
 *
 * 使用本demo时我添加了一个其它的一个依赖：implementation 'com.w4lle.library:NineLayout:1.0.0'
 * 因为开始使用自定义的gridview时总出现布局中有一块空白区域，一时不知道怎么解决这个问题，后来就使用别人的依赖后就没有这个问题了
 * 做项目尽量把一些好的东西都集中一起使用来发挥它的优势
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 进入listview嵌套listview
        findViewById(R.id.tv_list_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListMainActivity.class);
                startActivity(intent);
            }

        });
        // 进入listview嵌套listview和gridview
        findViewById(R.id.tv_list_grid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListAddListAndGrid.class);
                startActivity(intent);
            }
        });

    }
}
