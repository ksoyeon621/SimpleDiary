package com.example.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatePicker date;
    EditText edit;
    Button but; //해당날짜의 일기가 있으면 수정으로 바뀐다!! 아니면 새로만들기
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (DatePicker)findViewById(R.id.date_pick);
        edit = (EditText)findViewById(R.id.edit);
        but = (Button)findViewById(R.id.but);
    }
}
