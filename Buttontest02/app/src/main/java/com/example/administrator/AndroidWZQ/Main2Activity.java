package com.example.administrator.AndroidWZQ;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppManager.getAppManager().addActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn1=(Button)findViewById(R.id.btn1) ;
        Button btn2=(Button)findViewById(R.id.btn2) ;
        Button btn3=(Button)findViewById(R.id.btn3) ;
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Toast.makeText(Main2Activity.this,"游戏开始" , Toast.LENGTH_SHORT).show();
                System.out.println("游戏开始");
                showData.count=0;
                showData.player=1;
                Intent intent = new Intent();
               intent.setClass(Main2Activity.this, MainActivity.class);
                Main2Activity.this.startActivity(intent);
                Main2Activity.this.finish();
            }
        }) ;
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v2) {

                if(AppManager.sum!= 0)
                {
                    for(int i = 0; i < AppManager.sum; i++)
                    {if(AppManager.sum==1)
                    { return;}}
                }
                    Main2Activity.this.finish();
            }
        }) ;
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v3) {
                AppManager.getAppManager().AppExit(Main2Activity.this);
            }
        }) ;


    }
}
