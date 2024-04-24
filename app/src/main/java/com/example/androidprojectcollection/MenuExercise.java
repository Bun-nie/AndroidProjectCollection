package com.example.androidprojectcollection;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {
    Button btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = (Button) findViewById(R.id.btnChanger);
        default_appearance();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.mItemChange){
            Toast.makeText(this, "Edit Object Item is clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mItemReset) {
            Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
            default_appearance();
        } else if (item.getItemId() == R.id.mItemExit) {
            finish();
        } else if (item.getItemId() == R.id.bgcolor) {
            Toast.makeText(this, "Background Color Changed!", Toast.LENGTH_SHORT).show();
            Random rdm = new Random();
            btnChanger.setBackgroundColor(Color.rgb(rdm.nextInt(256), rdm.nextInt(256), rdm.nextInt(256)));
        } else if (item.getItemId() == R.id.textcolor) {
            Toast.makeText(this, "Text Color Changed!", Toast.LENGTH_SHORT).show();
            Random rdm = new Random();
            btnChanger.setTextColor(Color.rgb(rdm.nextInt(256), rdm.nextInt(256), rdm.nextInt(256)));
        } else if (item.getItemId() == R.id.text) {
            Toast.makeText(this, "Text Changed!", Toast.LENGTH_SHORT).show();
            btnChanger.setText("Press Me!");
        } else if (item.getItemId() == R.id.visibility) {
            if(btnChanger.getVisibility() == View.VISIBLE){
                Toast.makeText(this, "Button Disappeared!", Toast.LENGTH_SHORT).show();
                btnChanger.setVisibility(View.INVISIBLE);
            } else {
                Toast.makeText(this, "Button Appeared!", Toast.LENGTH_SHORT).show();
                btnChanger.setVisibility(View.VISIBLE);
            }
        } else if (item.getItemId() == R.id.size) {
            // Add border of any color
            Toast.makeText(this, "Size Changed!", Toast.LENGTH_SHORT).show();
            btnChanger.setTextSize(90);
        }

        return true;
    }

    public void default_appearance(){
        btnChanger.setText("Click Me!");
        btnChanger.setTextSize(30);
        btnChanger.setTextColor(WHITE);
        btnChanger.setBackgroundColor(BLACK);
    }


}