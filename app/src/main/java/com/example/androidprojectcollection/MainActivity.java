package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_start;
    Button btn_next;
    Button btn_calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button)findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(
                        MainActivity.this,//this activity
                        LayoutExercise.class //destination activity
                );
                startActivity(intent1);
            }
        });

        btn_next = (Button)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(
                        MainActivity.this,//this activity
                        ButtonExercise.class //destination activity
                );
                startActivity(intent2);
            }
        });

        btn_calc = (Button)findViewById(R.id.btn_end);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(
                        MainActivity.this,//this activity
                        Calculator.class //destination activity
                );
                startActivity(intent3);
            }
        });
    }
}