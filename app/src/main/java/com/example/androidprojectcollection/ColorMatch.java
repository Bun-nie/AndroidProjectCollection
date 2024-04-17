package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ColorMatch extends AppCompatActivity {

    int[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    static final int red = 0, blue = 1, green = 2, yellow = 3;
    Button[][] button;
    Button restart;
    int[][] btnColors = new int[5][5];
    ArrayList<Integer> rowArr = new ArrayList<>();
    ArrayList<Integer> colArr = new ArrayList<>();
    TextView score_count;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_match);
        start();
        restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=0;
                score_count.setText(String.valueOf(score));
                start();
            }
        });
    }

    public void start(){
        button = new Button[5][5];
        rowArr.clear();
        colArr.clear();
        for(int row= 0; row < 5; row++){
            for(int col= 0; col <5; col++){
                String resIDname = "btn"+row+col;
                button[row][col] = findViewById(this.getResources().getIdentifier(resIDname,"id", this.getPackageName()));
            }
        }

        for(int row = 0; row<5; row++){
            for(int col = 0; col<5; col++){
                int random = new Random().nextInt(colors.length);
                if(random == 0){
                    btnColors[row][col] = red;
                } else if(random == 1){
                    btnColors[row][col] = blue;
                } else if(random == 2){
                    btnColors[row][col] = green;
                } else if(random == 3){
                    btnColors[row][col] = yellow;
                }
            }
        }
        game();
    }

    public void game(){
        check();
        score_count.setText("0");
        changeColor();
        for(int row= 0; row < 5; row++){
            for(int col= 0; col <5; col++){
                int finalRow = row;
                int finalCol = col;
                button[row][col].setOnClickListener(e -> {
                    if(rowArr.size() < 2){
                        rowArr.add(finalRow);
                        colArr.add(finalCol);
                        System.out.println("Size: "+ rowArr.size());
                        check();
                    }
                    if(rowArr.size() == 2){
                        swap();
                        rowArr.clear();
                        colArr.clear();
                    }
                });
            }
        }
    }

    public void swap(){
        int row1 = rowArr.get(0), col1 = colArr.get(0);
        int row2 = rowArr.get(1), col2 = colArr.get(1);

        if((row1+1) == row2 || (Math.abs(row1-1)) == row2 || (col1+1) == col2 || (Math.abs(col1-1) == col2)){
            if(btnColors[row1][col1] == red){
                if(btnColors[row2][col2] == red){
                    button[row1][col1].setBackgroundColor(colors[red]);
                    btnColors[row1][col1] = red;
                    button[row2][col2].setBackgroundColor(colors[red]);
                    btnColors[row2][col2] = red;
                } else if(btnColors[row2][col2] == blue){
                    button[row1][col1].setBackgroundColor(colors[blue]);
                    btnColors[row1][col1] = blue;
                    button[row2][col2].setBackgroundColor(colors[red]);
                    btnColors[row2][col2] = red;
                } else if(btnColors[row2][col2] == green){
                    button[row1][col1].setBackgroundColor(colors[green]);
                    btnColors[row1][col1] = green;
                    button[row2][col2].setBackgroundColor(colors[red]);
                    btnColors[row2][col2] = red;
                } else if(btnColors[row2][col2] == yellow){
                    button[row1][col1].setBackgroundColor(colors[yellow]);
                    btnColors[row1][col1] = yellow;
                    button[row2][col2].setBackgroundColor(colors[red]);
                    btnColors[row2][col2] = red;
                }
            } else if(btnColors[row1][col1] == blue){
                if(btnColors[row2][col2] == red){
                    button[row1][col1].setBackgroundColor(colors[red]);
                    btnColors[row1][col1] = red;
                    button[row2][col2].setBackgroundColor(colors[blue]);
                    btnColors[row2][col2] = blue;
                } else if(btnColors[row2][col2] == blue){
                    button[row1][col1].setBackgroundColor(colors[blue]);
                    btnColors[row1][col1] = blue;
                    button[row2][col2].setBackgroundColor(colors[blue]);
                    btnColors[row2][col2] = blue;
                } else if(btnColors[row2][col2] == green){
                    button[row1][col1].setBackgroundColor(colors[green]);
                    btnColors[row1][col1] = green;
                    button[row2][col2].setBackgroundColor(colors[blue]);
                    btnColors[row2][col2] = blue;
                } else if(btnColors[row2][col2] == yellow){
                    button[row1][col1].setBackgroundColor(colors[yellow]);
                    btnColors[row1][col1] = yellow;
                    button[row2][col2].setBackgroundColor(colors[blue]);
                    btnColors[row2][col2] = blue;
                }
            } else if(btnColors[row1][col1] == green){
                if(btnColors[row2][col2] == red){
                    button[row1][col1].setBackgroundColor(colors[red]);
                    btnColors[row1][col1] = red;
                    button[row2][col2].setBackgroundColor(colors[green]);
                    btnColors[row2][col2] = green;
                } else if(btnColors[row2][col2] == blue){
                    button[row1][col1].setBackgroundColor(colors[blue]);
                    btnColors[row1][col1] = blue;
                    button[row2][col2].setBackgroundColor(colors[green]);
                    btnColors[row2][col2] = green;
                } else if(btnColors[row2][col2] == green){
                    button[row1][col1].setBackgroundColor(colors[green]);
                    btnColors[row1][col1] = green;
                    button[row2][col2].setBackgroundColor(colors[green]);
                    btnColors[row2][col2] = green;
                } else if(btnColors[row2][col2] == yellow){
                    button[row1][col1].setBackgroundColor(colors[yellow]);
                    btnColors[row1][col1] = yellow;
                    button[row2][col2].setBackgroundColor(colors[green]);
                    btnColors[row2][col2] = green;
                }
            } else if(btnColors[row1][col1] == yellow){
                if(btnColors[row2][col2] == red){
                    button[row1][col1].setBackgroundColor(colors[red]);
                    btnColors[row1][col1] = red;
                    button[row2][col2].setBackgroundColor(colors[yellow]);
                    btnColors[row2][col2] = yellow;
                } else if(btnColors[row2][col2] == blue){
                    button[row1][col1].setBackgroundColor(colors[blue]);
                    btnColors[row1][col1] = blue;
                    button[row2][col2].setBackgroundColor(colors[yellow]);
                    btnColors[row2][col2] = yellow;
                } else if(btnColors[row2][col2] == green){
                    button[row1][col1].setBackgroundColor(colors[green]);
                    btnColors[row1][col1] = green;
                    button[row2][col2].setBackgroundColor(colors[yellow]);
                    btnColors[row2][col2] = yellow;
                } else if(btnColors[row2][col2] == yellow){
                    button[row1][col1].setBackgroundColor(colors[yellow]);
                    btnColors[row1][col1] = yellow;
                    button[row2][col2].setBackgroundColor(colors[yellow]);
                    btnColors[row2][col2] = yellow;
                }
            }
            rowArr.clear();
            colArr.clear();
        }
        check();
    }

    private void check() {
        score_count = (TextView) findViewById(R.id.score_count);
        for(int row=0;row<5;row++){
            for(int col=0;col<3;col++){
                if(btnColors[row][col] == btnColors[row][col+1] && btnColors[row][col] == btnColors[row][col+2]){
                    score++;
                    btnColors[row][col] = new Random().nextInt(colors.length);
                    btnColors[row][col+1] = new Random().nextInt(colors.length);
                    btnColors[row][col+2] = new Random().nextInt(colors.length);

                }
            }
        }
        for(int row=0;row<3;row++){
            for(int col=0;col<5;col++){
                if(btnColors[row][col] == btnColors[row+1][col] && btnColors[row][col] == btnColors[row+2][col]){
                    score++;
                    btnColors[row][col] = new Random().nextInt(colors.length);
                    btnColors[row+1][col] = new Random().nextInt(colors.length);
                    btnColors[row+2][col] = new Random().nextInt(colors.length);
                }
            }
        }
        changeColor();
        score_count.setText(String.valueOf(score));
    }
    public void changeColor(){
        for(int row=0;row<5;row++){
            for(int col=0;col<5;col++){
                int color = btnColors[row][col];
                button[row][col].setBackgroundColor(colors[color]);
            }
        }
    }

}