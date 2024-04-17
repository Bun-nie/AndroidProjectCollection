package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class PassingIntentsExercise extends AppCompatActivity {
    Button submit, clear;
    EditText in_fname, in_lname, in_bdate, in_age,
            in_number, in_email, in_address,
            in_course, in_hob_int;

    RadioButton male, female, others;
    RadioGroup genders;
    Spinner in_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        //Initializing all Text Fields
        in_fname = (EditText) findViewById(R.id.in_fname);
        in_lname = (EditText) findViewById(R.id.in_lname);
        in_bdate = (EditText) findViewById(R.id.in_bdate);
        in_age = (EditText) findViewById(R.id.in_age);
        in_number = (EditText) findViewById(R.id.in_number);
        in_email = (EditText) findViewById(R.id.in_email);
        in_address = (EditText) findViewById(R.id.in_address);
        in_course = (EditText) findViewById(R.id.in_course);
        in_hob_int = (EditText) findViewById(R.id.in_hob_int);

        //Initializing all Radio Buttons
        male = (RadioButton) findViewById(R.id.in_male);
        female = (RadioButton) findViewById(R.id.in_female);
        others = (RadioButton) findViewById(R.id.in_others);

        genders = (RadioGroup) findViewById(R.id.gender_opts);

        in_year = (Spinner) findViewById(R.id.in_year);
        String[] items = new String[] {"1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        in_year.setAdapter(adapter);

        submit = (Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty()){
                    Toast.makeText(PassingIntentsExercise.this, "Please fill up all fields!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String fname = in_fname.getText().toString();
                String lname = in_lname.getText().toString();

                String gender;
                if(male.isChecked()){
                    gender = "Male";
                } else if (female.isChecked()) {
                    gender = "Female";
                } else if (others.isChecked()) {
                    gender = "Others";
                } else {
                    gender = "Unknown";
                }

                String bdate = in_bdate.getText().toString();
                String age = in_age.getText().toString();
                String number = in_number.getText().toString();
                String email = in_email.getText().toString();
                String address = in_address.getText().toString();

                String year = in_year.getSelectedItem().toString();
                String course = in_course.getText().toString();
                String hob_int = in_hob_int.getText().toString();

                Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                intent.putExtra("fname_key", fname); intent.putExtra("lname_key", lname);
                intent.putExtra("gender_key", gender);
                intent.putExtra("bdate_key", bdate); intent.putExtra("age_key", age);
                intent.putExtra("number_key", number);
                intent.putExtra("email_key", email);
                intent.putExtra("address_key", address);
                intent.putExtra("year_key", year); intent.putExtra("course_key", course);
                intent.putExtra("hob_int_key", hob_int);

                startActivity(intent);
            }
        });

        clear = (Button) findViewById(R.id.btn_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in_fname.setText(""); in_lname.setText("");
                genders.clearCheck();
                in_bdate.setText(""); in_age.setText("");
                in_number.setText("");
                in_email.setText("");
                in_address.setText("");
                in_year.setSelection(0); in_course.setText("");
                in_hob_int.setText("");
            }
        });
    }
    public boolean isEmpty(){
        if(in_fname.getText().toString().equals("") || in_lname.getText().toString().equals("") || in_bdate.getText().toString().equals("") ||
                in_age.getText().toString().equals("") || in_number.getText().toString().equals("") || in_email.getText().toString().equals("") ||
                in_address.getText().toString().equals("") || in_course.getText().toString().equals("") || in_hob_int.getText().toString().equals("")){
            return true;
        }
        return false;
    }
}