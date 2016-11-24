package com.example.edmon.pianotiles2;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Helpful methods for manipulating tiles.
 */

public class TileUtility extends AppCompatActivity {

    /**
     * Searches the array for the button that has a "BLACK" tag.
     */
    public int findBlack(Button[]a){
        int position = -1;
        for (int i = 0; i < a.length; i++) {
            String color = (String) a[i].getTag();
            if (color.equals("BLACK")){
                position = i;
            }
        }
        return position;
    }


    /**
     * Changes the button at index to black, makes every other tile white.
     */
    public void changeColors(Button[]b, int index){
        for(int i = 0; i < b.length; i++){
            if (i==index){
                b[i].setBackgroundResource(R.drawable.black_tile);
                b[i].setTag("BLACK");
            }
            else {
                b[i].setBackgroundResource(R.drawable.white_tile);
                b[i].setTag(" ");
            }
        }
    }
}
