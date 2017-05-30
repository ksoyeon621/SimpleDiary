package com.example.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.io.File;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker date;
    EditText edit;
    Button but; //해당날짜의 일기가 있으면 수정으로 바뀐다!! 아니면 새로만들기
    String filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (DatePicker)findViewById(R.id.date_pick);
        edit = (EditText)findViewById(R.id.edit);
        but = (Button)findViewById(R.id.but);

        //현재날짜로 설정하기
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);

        date.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int month, int day) {
                filename=year+"_"+(month+1)/*+1을 해주지 않으면 하나 적은 값으로 보여진다.*/
                +"_"+day+".txt";
                String readDate = readDiary(filename);
                edit.setText(readDate);
                but.setEnabled(true);//수정이나 새로 작성 활성화
            }
        });
    }
    public String readDiary(String filename){

        return null;
    }
}
