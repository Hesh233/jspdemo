package com.example.administrator.AndroidWZQ;

import static com.example.administrator.AndroidWZQ.showData.lista;
import static com.example.administrator.AndroidWZQ.showData.listb;

/**
 * Created by Administrator on 2017/11/1.
 */

public class Suanfa {
    public static char a[][] = new char[23][23];

    static void space() {
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 23; j++) {
                a[i][j] = 'X';
            }
        }
    }
     static char temp=0;
    static boolean player1(int x,int y,int player)
    {System.out.println("PLAYER"+player+"坐标为："+x+","+y);
    if(a[x+4][y+4]=='X'&&player==1)
        {a[x+4][y+4]='A';temp='A';}
             if(a[x+4][y+4]=='X'&&player==2)
        {a[x+4][y+4]='B';temp='B';}
        if(player==3)
        {System.out.println("PLAYER"+player+"退回坐标为：" +lista.peekLast()+listb. peekLast());
            a[x+4][y+4]='X';
            return true;}
        for(int i=4;i<19;i++)
            {
                for(int j=4;j<19;j++)
                {
                    if(a[i+1][j+1]==temp&&a[i+2][j+2]==temp&&a[i+3][j+3]==temp&&a[i+4][j+4]==temp&&a[i+5][j+5]==temp)//A代表黑子,B代表白子
                    {return false;}
                    if(a[i-1][j-1]==temp&&a[i-2][j-2]==temp&&a[i-3][j-3]==temp&&a[i-4][j-4]==temp&&a[i-5][j-5]==temp)
                    {return false;}
                    if(a[i][j-1]==temp&&a[i][j-2]==temp&&a[i][j-3]==temp&&a[i][j-4]==temp&&a[i][j-5]==temp)
                    {return false;}
                    if(a[i-1][j]==temp&&a[i-2][j]==temp&&a[i-3][j]==temp&&a[i-4][j]==temp&&a[i-5][j]==temp)
                    {return false;}
                    if(a[i][j+1]==temp&&a[i][j+2]==temp&&a[i][j+3]==temp&&a[i][j+4]==temp&&a[i][j+5]==temp)
                    {return false;}
                    if(a[i+1][j]==temp&&a[i+2][j]==temp&&a[i+3][j]==temp&&a[i+4][j]==temp&&a[i+5][j]==temp)
                    {return false;}
                    if(a[i-1][j+1]==temp&&a[i-2][j+2]==temp&&a[i-3][j+3]==temp&&a[i-4][j+4]==temp&&a[i-5][j+5]==temp)
                    {return false;}
                    if(a[i+1][j-1]==temp&&a[i+2][j-2]==temp&&a[i+3][j-3]==temp&&a[i+4][j-4]==temp&&a[i+5][j-5]==temp)
                    {return false;}

                }
            }
        return true;
    }

}
