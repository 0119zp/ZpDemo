package zp.com.zpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import zp.com.zpdemo.cehua.activity.ZpCehuaActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setCehua(View view){
        Intent intent = new Intent(MainActivity.this, ZpCehuaActivity.class);
        startActivity(intent);
    }


}
