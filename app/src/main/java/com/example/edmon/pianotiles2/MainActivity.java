package com.example.edmon.pianotiles2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/*
    TO-DO: 
        --Fix the sound effects (get better sound effects as well)
        --Display tiles left somewhere on screen
        --Display the game clock somewhere on screen
        --Store high scores
        --Change the back tiles to green as the user gets close to 50 tiles
*/


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    private Button btn13;
    private Button btn14;
    private Button btn15;
    private Button btn16;
    private Button btn17;
    private Button btn18;
    private Button btn19;
    private Button btn20;

    int programCounter = 0;
    long startTime = System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Piano Tiles");


        /*
         * Finding each button its place in the world
         */
        btn1 = (Button) findViewById(R.id.button0);
        btn2 = (Button) findViewById(R.id.button1);
        btn3 = (Button) findViewById(R.id.button2);
        btn4 = (Button) findViewById(R.id.button3);
        btn5 = (Button) findViewById(R.id.button4);
        btn6 = (Button) findViewById(R.id.button5);
        btn7 = (Button) findViewById(R.id.button6);
        btn8 = (Button) findViewById(R.id.button7);
        btn9 = (Button) findViewById(R.id.button8);
        btn10 = (Button) findViewById(R.id.button9);
        btn11 = (Button) findViewById(R.id.button10);
        btn12 = (Button) findViewById(R.id.button11);
        btn13 = (Button) findViewById(R.id.button12);
        btn14 = (Button) findViewById(R.id.button13);
        btn15 = (Button) findViewById(R.id.button14);
        btn16 = (Button) findViewById(R.id.button15);

        btn17 = (Button) findViewById(R.id.button16);
        btn18 = (Button) findViewById(R.id.button17);
        btn19 = (Button) findViewById(R.id.button18);
        btn20 = (Button) findViewById(R.id.button19);



        /*
         * setting up buttons to be clickable
         */
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);


        /*
         * Set colors
         */
        btn1.setBackgroundResource(R.drawable.black_tile);
        btn1.setTag("BLACK");
        btn2.setBackgroundResource(R.drawable.white_tile);
        btn3.setBackgroundResource(R.drawable.white_tile);
        btn4.setBackgroundResource(R.drawable.white_tile);


        btn5.setBackgroundResource(R.drawable.white_tile);
        btn6.setBackgroundResource(R.drawable.white_tile);
        btn7.setBackgroundResource(R.drawable.black_tile);
        btn7.setTag("BLACK");
        btn8.setBackgroundResource(R.drawable.white_tile);

        btn9.setBackgroundResource(R.drawable.white_tile);
        btn10.setBackgroundResource(R.drawable.black_tile);
        btn10.setTag("BLACK");
        btn11.setBackgroundResource(R.drawable.white_tile);
        btn12.setBackgroundResource(R.drawable.white_tile);

        btn13.setBackgroundResource(R.drawable.white_tile);
        btn14.setBackgroundResource(R.drawable.white_tile);
        btn15.setBackgroundResource(R.drawable.white_tile);
        btn16.setBackgroundResource(R.drawable.black_tile);
        btn16.setTag("BLACK");


        btn17.setBackgroundResource(R.drawable.black_tile);
        btn17.setTag("BLACK");
        btn18.setBackgroundResource(R.drawable.white_tile);
        btn19.setBackgroundResource(R.drawable.white_tile);
        btn20.setBackgroundResource(R.drawable.white_tile);

    }

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

    /**
     * Searches the array for the button that has a "BLACK" tag
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

    public void playSoundEffect(int i){
        if (i == 0){
            MediaPlayer sound = MediaPlayer.create(this, R.raw.piano063);
            sound.start();
        }else if (i == 1){
            MediaPlayer sound = MediaPlayer.create(this, R.raw.piano038);
            sound.start();
        }else if (i == 2){
            MediaPlayer sound = MediaPlayer.create(this, R.raw.piano045);
            sound.start();
        }else if (i == 3){
            MediaPlayer sound = MediaPlayer.create(this, R.raw.piano053);
            sound.start();
        }else{
            MediaPlayer sound = MediaPlayer.create(this, R.raw.low_key);
            sound.start();
        }
    }

    public void onClick(View v) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        MediaPlayer sound = MediaPlayer.create(this, R.raw.piano063);
        sound.start();


        Button [] firstRow = new Button[]{btn1, btn2, btn3, btn4};
        Button [] secondRow = new Button[]{btn5, btn6, btn7, btn8};
        Button [] thirdRow = new Button[]{btn9, btn10, btn11, btn12};
        Button [] fourthRow = new Button[]{btn13, btn14, btn15, btn16};
        Button [] fifthRow = new Button[]{btn17, btn18, btn19, btn20};
        int [] blackPosition = new int[5];
        Random rand = new Random();



        blackPosition[0] = findBlack(firstRow);
        blackPosition[1] = findBlack(secondRow);
        blackPosition[2] = findBlack(thirdRow);
        blackPosition[3] = findBlack(fourthRow);
        blackPosition[4] = findBlack(fifthRow);

        String color = (String) v.getTag();
        if (color.equals("BLACK")){
            playSoundEffect(blackPosition[0]);

            changeColors(firstRow, rand.nextInt(4));
            changeColors(secondRow, blackPosition[0]);
            changeColors(thirdRow, blackPosition[1]);
            changeColors(fourthRow, blackPosition[2]);
            changeColors(fifthRow, blackPosition[3]);
        }
         else {
            playSoundEffect(5);
            builder1.setMessage("You lost! Distance: " + programCounter + " Do you want to play again?");
            builder1.setCancelable(false);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            startTime = System.currentTimeMillis();
                            programCounter = 0;
                        }

                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            System.exit(0);
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
        programCounter++;

        if (programCounter == 50){
            long score = System.currentTimeMillis()-startTime;
            builder1.setMessage("You won! Time: " +  score/1000 + " seconds. Do you want to play again?");
            builder1.setCancelable(false);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            programCounter = 0;
                            startTime = System.currentTimeMillis();
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            System.exit(0);
                        }
                    });


            AlertDialog alert11 = builder1.create();
            alert11.show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
