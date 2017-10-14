package zp.com.zpdemo.cehua.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import zp.com.zpdemo.R;
import zp.com.zpdemo.cehua.view.SwipeMenu;
import zp.com.zpdemo.cehua.view.SwipeMenuCreator;
import zp.com.zpdemo.cehua.view.SwipeMenuItem;
import zp.com.zpdemo.cehua.view.SwipeMenuListView;

/**
 * Created by Administrator on 2017/7/26 0026.
 */

public class ZpCehuaActivity extends Activity {

    private SwipeMenuListView mListView;
    private MyAdapter mAdapter;
    private ArrayList<String> mArrayList;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce_hua);

        context = this;

        initView();

    }

    private void initView() {
        mListView = (SwipeMenuListView) findViewById(R.id.listView);
        mArrayList = new ArrayList<String>();
        for(int i = 0; i < 50 ; i++){
            mArrayList.add(Integer.toString(i));
        }


        mAdapter = new MyAdapter();
        mListView.setAdapter(mAdapter);

        SwipeMenuCreator creator = new SwipeMenuCreator(){

            @Override
            public void create(SwipeMenu menu) {

                //创建一个"打开"功能菜单
                SwipeMenuItem openItem = new SwipeMenuItem(context);
                // 设置菜单的背景
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,0xCE)));
                // 宽度：菜单的宽度是一定要有的，否则不会显示
                openItem.setWidth(dp2px(80));
                // 菜单标题
                openItem.setTitle("打开");
                // 标题文字大小
                openItem.setTitleSize(16);
                // 标题的颜色
                openItem.setTitleColor(Color.WHITE);
                // 添加到menu
                menu.addMenuItem(openItem);

                //创建一个"打开"功能菜单
                SwipeMenuItem deleteItem = new SwipeMenuItem(context);
                // 设置菜单的背景
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,0x3F, 0x25)));
                // 宽度：菜单的宽度是一定要有的，否则不会显示
                deleteItem.setWidth(dp2px(80));
                // 菜单标题
                deleteItem.setTitle("删除");
                // 标题文字大小
                deleteItem.setTitleSize(16);
                // 标题的颜色
                deleteItem.setTitleColor(Color.WHITE);
                // 给菜单设置一个图标
                deleteItem.setIcon(R.drawable.icon_delete);
                // 添加到menu
                menu.addMenuItem(deleteItem);
            }
        };
        // 不要忘记了
        mListView.setMenuCreator(creator);

        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        Toast.makeText(context, "打开第" + mArrayList.get(position) + "个条目", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context, "删除第" + mArrayList.get(position) + "个条目", Toast.LENGTH_SHORT).show();
                        mArrayList.remove(position);
                        mAdapter.notifyDataSetChanged();

                        break;
                }
            }
        });

    }


    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mArrayList.size();
        }
        @Override
        public Object getItem(int position) {
            return mArrayList.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view;
            if (convertView == null){
                view = new TextView(context);
            } else {
                view = (TextView) convertView;
            }

            view.setText("我是ListView的第" + mArrayList.get(position) + "个条目");
            view.setGravity(Gravity.CENTER);
            view.setHeight(dp2px(80));

            return view;
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }


}
