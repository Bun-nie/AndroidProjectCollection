package com.example.androidprojectcollection;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorMatch extends AppCompatActivity {
    //Buttons in the 5x5 table
    Button r1c1, r1c2, r1c3, r1c4, r1c5,
            r2c1, r2c2, r2c3, r2c4, r2c5,
            r3c1, r3c2, r3c3, r3c4, r3c5,
            r4c1, r4c2, r4c3, r4c4, r4c5,
            r5c1, r5c2, r5c3, r5c4, r5c5;

    Button restart;
    TextView score_count;
    Button button[][];
    int colors[] = {RED, BLUE, YELLOW, GREEN};
    static final int red = 0, blue = 1, yellow = 2, green = 3;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_match);
        play();
        /*
                Logic of game:
                every press sa button, return index[][], then base sa index, check surrounding cells{up, down, left, right, up-right, up-left, down-right, down-left)

                Include also toast messages nga muloop ug random words, murag candy crush "Yum!", "Tasty!" every makapoint
        */
    }

    public void init_buttons(){
        button = new Button[5][5];
        for(int row = 1; row<=5; row++){
            for(int col=1; col<=5; col++){
                String resIDname = "r"+row+"c"+col;
                button[row-1][col-1] = findViewById(this.getResources().getIdentifier(resIDname,"id",this.getPackageName()));
            }
        }
        restart = findViewById(R.id.btn_restart);
    }
    public void play(){
        init_buttons();
        for(Button[] b : button){

        }
    }
    public boolean check_match(){
        return false;
    }
    public void reset(){

    }
}