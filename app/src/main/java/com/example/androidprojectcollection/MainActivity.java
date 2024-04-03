package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_insta, btn_button, btn_calc, btn_match, btn_midterms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_insta = (Button)findViewById(R.id.btn_insta);

        btn_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_insta = new Intent(
                        MainActivity.this,//this activity
                        LayoutExercise.class //destination activity
                );
                startActivity(to_insta);
            }
        });

        btn_button = (Button)findViewById(R.id.btn_button);
        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_button = new Intent(
                        MainActivity.this,//this activity
                        ButtonExercise.class //destination activity
                );
                startActivity(to_button);
            }
        });

        btn_calc = (Button) findViewById(R.id.btn_calc);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_calc = new Intent(
                        MainActivity.this,//this activity
                        Calculator.class //destination activity
                );
                startActivity(to_calc);
            }
        });

        btn_match = (Button) findViewById(R.id.btn_match);
        btn_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_match = new Intent(
                        MainActivity.this,//this activity
                        ColorMatch.class //destination activity
                );
                startActivity(to_match);
            }
        });

        btn_midterms = (Button) findViewById(R.id.btn_midterms);
        btn_midterms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_midterms = new Intent(
                        MainActivity.this,//this activity
                        TicTacToe.class //destination activity
                );
                startActivity(to_midterms);
            }
        });
    }
}