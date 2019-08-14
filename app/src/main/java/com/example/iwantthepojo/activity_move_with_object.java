package com.example.iwantthepojo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity_move_with_object extends AppCompatActivity {
    public static String EXTRA_PERSON = " extra_person";
    public TextView tvObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = (TextView)findViewById(R.id.tv_object_received);
        Person aku = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name:"+aku.getName()+",Email:"+aku.getEmail()+",Age:"+aku.getAge()+
                "Location,"+aku.getCity();
        tvObject.setText(text);
    }
}
