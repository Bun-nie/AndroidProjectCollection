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
                    if(isPlayer1Turn.get()){
                        gameState[index] = 1;
                    }
                    if(!isPlayer1Turn.get()){
                        gameState[index] = 2;
                    }
                    isClicked.get(index).set(true);
                    buttons[index].setText(isPlayer1Turn.get() ? "O" : "X");
                    background.setBackgroundColor(isPlayer1Turn.get() ? RED : BLUE);
                    isPlayer1Turn.set(!isPlayer1Turn.get());
                    display.setText(isPlayer1Turn.get() ? "Player O's Turn" : "Player X's Turn");
                    /*boolean check = checkWin();
                    if(check){
                        endgame("Player " + (isPlayer1Turn.get() ? "1" : "2") + "Wins!");
                    }*/
                }
            });
        }
        /*boolean fin = true;
        for(int i=0;i<9;i++){
            if(!isClicked.get(i).get()){
                fin = false;
            }
        }
        if(fin){
            endgame("Stalemate!");
        }*/
        restart.setOnClickListener(v -> reset());
    }
    public boolean checkWin(){
        if((gameState[0] == 1 && gameState[1] == 1 && gameState[2] == 1) ||
                (gameState[3] == 1 && gameState[4] == 1 && gameState[5] == 1) ||
                (gameState[6] == 1 && gameState[7] == 1 && gameState[8] == 1) ||
                (gameState[0] == 1 && gameState[3] == 1 && gameState[6] == 1) ||
                (gameState[1] == 1 && gameState[4] == 1 && gameState[7] == 1) ||
                (gameState[2] == 1 && gameState[5] == 1 && gameState[8] == 1) ||
                (gameState[0] == 1 && gameState[4] == 1 && gameState[8] == 1) ||
                (gameState[2] == 1 && gameState[4] == 1 && gameState[6] == 1)) {
            return true;
        } else {
            return false;
        }
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
        }
        isPlayer1Turn.set(true);
        background.setBackgroundColor(isPlayer1Turn.get() ? BLUE : RED);
        display.setText(isPlayer1Turn.get() ? "Player O's Turn" : "Player X's Turn");
    }
}
