package com.example.administrator.AndroidWZQ;

/**
 * Created by LJX on 2017/11/14.
 */

public  class backchess{
    static void backchess()
    {
        System.out.println("悔棋坐标为："+showData.lista.peekLast()+showData.listb. peekLast()+"下棋步数:"+showData.count);
        MainActivity.clickable();
        for(int j=0;j<showData.count;j++)
        {showData.viewlist.get(j).setEnabled(false);}
        showData.viewlist.peekLast().setEnabled(true);
        showData.viewlist.pollLast().setBackgroundResource(0);
        showData.count--;
        if(showData.player==1)
        {showData.player=3;
            Suanfa.player1(showData.lista.peekLast(),showData.listb. peekLast(),showData.player);
            showData.player=2;
            showData.lista.remove();
            showData.listb.remove();
            MainActivity.textview.setText("轮到白方");
        }
        else
        {showData.player=3;
            Suanfa.player1( showData.lista.peekLast(),showData.listb. peekLast(),showData.player);
            showData.player=1;
            showData.lista.remove();
            showData.listb.remove();
            MainActivity.textview.setText("轮到黑方");}
    }

}
