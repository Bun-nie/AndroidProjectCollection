package com.example.androidprojectcollection;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class TicTacToe extends AppCompatActivity {
    AtomicBoolean isPlayer1Turn = new AtomicBoolean(true);
    ArrayList<AtomicBoolean> isClicked = new ArrayList<>();
    int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    LinearLayout background;
    TextView display;
    Button[] buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        buttons = new Button[]{
                findViewById(R.id.btn7),
                findViewById(R.id.btn8),
                findViewById(R.id.btn9),
                findViewById(R.id.btn4),
                findViewById(R.id.btn5),
                findViewById(R.id.btn6),
                findViewById(R.id.btn1),
                findViewById(R.id.btn2),
                findViewById(R.id.btn3)
        };
        Button restart = findViewById(R.id.btn_restart);
        background = findViewById(R.id.background);
        display = findViewById(R.id.display);
        background.setBackgroundColor(BLUE);
        for(int i=0;i<9;i++){
            isClicked.add(new AtomicBoolean(false));
        }
        for(int i=0;i<9;i++){

            int index=i;
            buttons[i].setOnClickListener(v -> {

                if(!isClicked.get(index).get()){

                    isClicked.get(index).set(true);

                    buttons[index].setText(isPlayer1Turn.get() ? "O" : "X");
                    buttons[index].setTag(isPlayer1Turn.get() ? "O" : "X");
                    background.setBackgroundColor(isPlayer1Turn.get() ? RED : BLUE);
                    isPlayer1Turn.set(!isPlayer1Turn.get());
                    display.setText(isPlayer1Turn.get() ? "Player O's Turn" : "Player X's Turn");
                    checkWin(isPlayer1Turn.get() ? "O" : "X");
                }

            });
        }

        boolean fin = true;
        for(int i=0;i<9;i++){
            if(!isClicked.get(i).get()){
                fin = false;
                break;
            }
        }
        if(fin){
            stalement();
        }
        restart.setOnClickListener(v -> reset());
    }
    public void checkWin(String player){
        if ((buttons[0].getTag() == player && buttons[1].getTag() == player && buttons[2].getTag() == player) ||
                (buttons[3].getTag() == player && buttons[4].getTag() == player && buttons[5].getTag() == player) ||
                (buttons[6].getTag() == player && buttons[7].getTag() == player && buttons[8].getTag() == player) ||
                (buttons[0].getTag() == player && buttons[3].getTag() == player && buttons[6].getTag() == player) ||
                (buttons[1].getTag() == player && buttons[4].getTag() == player && buttons[7].getTag() == player) ||
                (buttons[2].getTag() == player && buttons[5].getTag() == player && buttons[8].getTag() == player) ||
                (buttons[0].getTag() == player && buttons[4].getTag() == player && buttons[8].getTag() == player) ||
                (buttons[2].getTag() == player && buttons[4].getTag() == player && buttons[6].getTag() == player)){
            endgame("Player " + player + " Wins!");
        }
    }
    
    public void stalement(){
        endgame("Stalement!");
    }
    public void endgame(String str){
        for(Button b : buttons){
            b.setEnabled(false);
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
    public void reset (){
        for(int i=0;i<9;i++){
            isClicked.get(i).set(false);
        }
        for(Button b : buttons){
            b.setEnabled(true);
            b.setText("");
            b.setTag("");
        }
        isPlayer1Turn.set(true);
        background.setBackgroundColor(isPlayer1Turn.get() ? BLUE : RED);
        display.setText(isPlayer1Turn.get() ? "Player O's Turn" : "Player X's Turn");
    }
}
