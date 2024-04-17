package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {
    Button btn_return;

    TextView tfname, tlname, tgender, tbdate, tage, tnumber, temail, taddress, tyear, tcourse, thob_int;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        tfname = findViewById(R.id.out_fname); tlname = findViewById(R.id.out_lname);
        tgender = findViewById(R.id.out_gender);
        tbdate = findViewById(R.id.out_bdate); tage = findViewById(R.id.out_age);
        tnumber = findViewById(R.id.out_number);
        temail = findViewById(R.id.out_email);
        taddress = findViewById(R.id.out_address);
        tyear = findViewById(R.id.out_year); tcourse = findViewById(R.id.out_course);
        thob_int = findViewById(R.id.out_hob_int);

        Intent intent = getIntent();

        String fname = intent.getStringExtra("fname_key"); String lname = intent.getStringExtra("lname_key");
        String gender = intent.getStringExtra("gender_key");
        String bdate = intent.getStringExtra("bdate_key"); String age = intent.getStringExtra("age_key");
        String number = intent.getStringExtra("number_key");
        String email = intent.getStringExtra("email_key");
        String address = intent.getStringExtra("address_key");
        String year = intent.getStringExtra("year_key"); String course = intent.getStringExtra("course_key");
        String hob_int = intent.getStringExtra("hob_int_key");

        tfname.setText(fname); tlname.setText(lname);
        tgender.setText(gender);
        tbdate.setText(bdate); tage.setText(age);
        tnumber.setText(number);
        temail.setText(email);
        taddress.setText(address);
        tyear.setText(year); tcourse.setText(course);
        thob_int.setText(hob_int);

        btn_return = (Button) findViewById(R.id.btn_back);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_forms = new Intent(
                        PassingIntentsExercise2.this,//this activity
                        PassingIntentsExercise.class //destination activity
                );
                startActivity(to_forms);
            }
        });

    }
}