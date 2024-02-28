package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class ButtonExercise extends AppCompatActivity {

    Button btn_close;
    Button btn_toast;
    Button btn_bg;
    Button btn_btn_bg;
    Button btn_dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);
        btn_close = (Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent close = new Intent(
                        ButtonExercise.this,//this activity
                        NextTo.class //destination activity
                );
                startActivity(close);
            }
        });


        btn_toast = (Button)findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast msg = Toast.makeText(context, "Toast to you!", Toast.LENGTH_SHORT);
                msg.show();
            }
        });

        btn_bg = (Button)findViewById(R.id.btn_changeBG);
        btn_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout l = findViewById(R.id.layout);
                Random rdm = new Random();

                l.setBackgroundColor(Color.rgb(rdm.nextInt(256), rdm.nextInt(256), rdm.nextInt(256)));
            }
        });

        btn_btn_bg = (Button)findViewById(R.id.btn_changeBtnBG);
        btn_btn_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rdm = new Random();

                btn_btn_bg.setBackgroundColor(Color.rgb(rdm.nextInt(256), rdm.nextInt(256), rdm.nextInt(256)));
            }
        });

        btn_dis = (Button)findViewById(R.id.btn_disappear);
        btn_dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_dis.setVisibility(View.INVISIBLE);
            }
        });

    }
}