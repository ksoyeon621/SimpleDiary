package com.example.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

        date.init(year, month, day, new DatePicker.OnDateChangedListener() { //실행할때 현재 날짜가 보여지게 된다. 말그대로 초기화!!
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
        String diaryStr = null;
        FileInputStream fin=null; //try내부에서만 쓸 수 있게 하면 안돼니까 밖에서 선언!
        try {
            fin = openFileInput(filename);//내장메모리에 있는 파일을 읽어올 수 있게 하는것이다!
            byte[] buf=new byte[500];/*한번에 읽어오는 데이터 크기 지정*/
            fin.read(buf);//read 예외처리는 IOException을 해야한다.
            diaryStr=new String(buf).trim();//byte값을 String으로 변환하는 방법 //trim() 앞과 뒤의 (중간은 제거를 할 수 없다)공백을 제거 해준다
            but.setText("수정 하기");
        } catch (FileNotFoundException e) {
            edit.setText("일기가 존재하지 않습니다.");
            but.setText("새로 저장");
         } catch (IOException e) {
         }
        return diaryStr;
    }
}
