package com.example.fructus.vremia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
     String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        Button button1 =(Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);


        TextView textView = (TextView)findViewById(R.id.textView);

        Date date = new Date();

        sPref = getSharedPreferences("Text",MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        data = savedText;
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();

        data= data +"\n"+ date;






    }

    @Override
    public void onDestroy(){

        sPref = getSharedPreferences("Text",MODE_PRIVATE);             //MODE_PRIVATE данные доступны только в приложении
        SharedPreferences.Editor ed = sPref.edit();                                      //обьект для изменения данных
        ed.putString(SAVED_TEXT, data);         //метод для сохранения текста
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();

        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView)findViewById(R.id.textView);
        switch (v.getId()) {

            case R.id.button1:
                data ="";
                textView.setText("");
                break;

            case R.id.button: textView.setText(data);
                break;



        }


    }
}
