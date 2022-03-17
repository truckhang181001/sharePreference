package com.truckhang_.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private TextView main_view;
    private Button black, red, blue, green, count;
    private int var;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mappingView();

        sharedPreferences = getSharedPreferences("sharePref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        var = sharedPreferences.getInt("count",0);
        setBackground(sharedPreferences.getString("background", "black"));
        main_view.setText(Integer.toString(var));

        countClick();
        blackClick();
        redClick();
        blueClick();
        greenClick();



    }

    protected void mappingView(){
        main_view = (TextView) findViewById(R.id.main_view);
        black = (Button) findViewById(R.id.black);
        red = (Button) findViewById(R.id.red);
        blue = (Button) findViewById(R.id.blue);
        green = (Button) findViewById(R.id.green);
        count = (Button) findViewById(R.id.count);
    }
    protected void setBackground(String background){
        switch (background){
            case "black":
                main_view.setBackgroundColor(Color.parseColor("#FF000000"));
                break;
            case "red":
                main_view.setBackgroundColor(Color.parseColor("#E91E1E"));
                break;
            case "blue":
                main_view.setBackgroundColor(Color.parseColor("#05528F"));
                break;
            case "green":
                main_view.setBackgroundColor(Color.parseColor("#4CAF50"));
                break;
        }
    }
    protected void countClick(){
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var += 1;
                editor.putInt("count",var);
                editor.commit();
                main_view.setText(Integer.toString(var));
            }
        });
    }
    protected void blackClick(){
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("background","black");
                editor.commit();
                main_view.setBackgroundColor(Color.parseColor("#FF000000"));
            }
        });
    }
    protected void redClick(){
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("background","red");
                editor.commit();
                main_view.setBackgroundColor(Color.parseColor("#E91E1E"));
            }
        });
    }
    protected void blueClick(){
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("background","blue");
                editor.commit();
                main_view.setBackgroundColor(Color.parseColor("#05528F"));
            }
        });
    }
    protected void greenClick(){
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("background","green");
                editor.commit();
                main_view.setBackgroundColor(Color.parseColor("#4CAF50"));
            }
        });
    }
}