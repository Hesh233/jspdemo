package com.example.administrator.AndroidWZQ;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static Activity MainActivity;
    int j = 0;

    int i = 0;
    int k = 0;
   static TextView textview;
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return false;
    }
    static ImageButton[][] Btn = new ImageButton[15][15];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        AppManager.getAppManager().addActivity(this);
        Suanfa.space();
        super.onCreate(savedInstanceState);
        DisplayMetrics dm = new DisplayMetrics();     //获取屏幕大小
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
         final RelativeLayout layout = new RelativeLayout(this);    //自定义layout组件
        ImageView imageView = new ImageView(this);  //创建imageview
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(dm.widthPixels, dm.widthPixels));// 设置图片的高度
        imageView.setBackgroundResource(R.drawable.aa);  //设置imageview呈现的图片
        imageView.setY((width) /5);
        layout.addView(imageView);  //添加到布局容器中，显示图片。
        Button btn=new Button(this);
        btn.setText("暂停");
        btn.setOnClickListener(new View.OnClickListener()
                               {
            public void onClick(View view) {
                AlertDialog show = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("暂停")
                        .setItems(new String[]{"悔棋", "重新开始", "返回菜单"}, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int u) {
                                if (u == 0) {
                                    if(showData.count==0)
                                    {return ;}
                                    backchess.backchess();
                                }
                                if (u == 1) {
                                    showData.count=0;
                                    showData.player=1;
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                }
                                if(u==2) {
                                    Intent intent = new Intent();
                                    intent.setClass(MainActivity.this, Main2Activity.class);
                                    MainActivity.this.startActivity(intent);
                                    MainActivity.this.onStop();
                                }
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();

            }
        }
        ) ;
        TextView text=new TextView(MainActivity.this);
       textview=text;
        text.setTextSize(width/30);
        text.setText("轮到黑方");
        text.setY(width/5+width);

        text.setX(width/7+width/6);
        layout.addView(text);
        RelativeLayout.LayoutParams bt= new RelativeLayout.LayoutParams((width) /7, (width) / 7);
        bt.leftMargin = (width-(width) / 7) ;
        bt.topMargin = (0) ;
        layout.addView(btn, bt);
        layout.setBackgroundColor(Color.parseColor("#FF9900"));
        for (i = 0; i < 15; i++) {
            for (k = 0; k < 15; k++) {

                j++;
                Btn[i][k] = new ImageButton(this);
                Btn[i][k].setId(15*k+i);
                RelativeLayout.LayoutParams btParams = new RelativeLayout.LayoutParams((width - 50) / 15, (width - 50) / 15);
                btParams.leftMargin = ((width) / 15) * (i % 15);
                btParams.topMargin = ((width) / 15) * k - (height / 180)+(width) /5;/*(height) / 24 * k - (height / 110);*/
                layout.addView(Btn[i][k], btParams);
                Btn[i][k].setVisibility(View.VISIBLE);
                Btn[i][k].getBackground().setAlpha(0);
                final int finalI = i;
                final int finalK = k;
                final int finalJ = j;
                Btn[i][k].setOnClickListener(new showData(layout, this, finalI, finalK, finalJ));
            }
        }
        this.setContentView(layout);
    }
    static void unclickable()
    {
        for(int i=0;i<15;i++) {
        for (int j = 0; j < 15; j++)
        {Btn[i][j].setEnabled(false);}
    }
    }
    static void clickable()
    {for(int i=0;i<15;i++)
    {for(int j=0;j<15;j++)
    {
        Btn[i][j].setEnabled(true);
    }

    }
    }
}





