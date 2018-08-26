package com.example.administrator.AndroidWZQ;



import android.app.AlertDialog;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.view.View.OnClickListener;

import java.util.LinkedList;

import static com.example.administrator.AndroidWZQ.R.*;

public class showData  implements OnClickListener {
    RelativeLayout layout;
    DisplayMetrics dm = new DisplayMetrics();     //获取屏幕大小
    int width = dm.widthPixels;
    int height = dm.heightPixels;
    static int count=0;
    private int i=0;
    private int k=0;
    private int j=0;
    static int player=1;
    private Context c;
    static LinkedList<View> viewlist=new LinkedList<View>();
   static LinkedList<Integer> lista=new LinkedList<Integer>();
    static LinkedList<Integer> listb=new LinkedList<Integer>();
    public showData(RelativeLayout layout,Context c,int i,int k,int j) {
        this.layout=layout;
        this.c=c;
        this.i = i;
        this.k = k;
        this.j=j;
    }
    @Override
    public void onClick(View v) {
        lista.add(this.i);
        listb.add(this.k);
        count++;
        viewlist.add(v);
        System.out.println("下棋玩家:"+player);
        Suanfa.player1(i, k,player);
        if (player == 1 && Suanfa.player1(i,k,player)== false) {
            v.setBackgroundResource(drawable.p002);
            v.setEnabled(false);
            AlertDialog show = new AlertDialog.Builder(c)
                    .setTitle("标题")
                    .setMessage("BLACK SIDE WIN")
                    .setPositiveButton("确定", null)
                    .show();
            MainActivity.textview.setText("黑方赢");
            player = 2;
            MainActivity.unclickable();
        }
        else if (player == 2 && Suanfa.player1(i,k,player)== false) {
            v.setBackgroundResource(drawable.p001);
            v.setEnabled(false);
            new AlertDialog.Builder(c)
                    .setTitle("标题")
                    .setMessage("WHITE SIDE WIN")
                    .setPositiveButton("确定", null)
                    .show();
            MainActivity.textview.setText("白方赢");
            player = 1;
            MainActivity.unclickable();
        }
        if (player == 1 && Suanfa.player1(i,k,player)==true) {
            player = 2;
            v.setBackgroundResource(drawable.p002);
            v.setEnabled(false);
            MainActivity.textview.setText("轮到白方");
        }
        else if (player == 2 &&  Suanfa.player1(i,k,player)==true) {
            player = 1;
            v.setBackgroundResource(drawable.p001);
            v.setEnabled(false);
            MainActivity.textview.setText("轮到黑方");
        }
    }

}

