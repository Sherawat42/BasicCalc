package com.example.sherawat42.basiccalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button nums[] = new Button[10];
    Button add;
    Button minus;
    Button calculate;
    TextView textView;
    TextView output;
    long result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nums[0] = (Button)findViewById(R.id.zero);
        nums[1] = (Button)findViewById(R.id.one);
        nums[2] = (Button)findViewById(R.id.two);
        nums[3] = (Button)findViewById(R.id.three);
        nums[4] = (Button)findViewById(R.id.four);
        nums[5] = (Button)findViewById(R.id.five);
        nums[6] = (Button)findViewById(R.id.six);
        nums[7] = (Button)findViewById(R.id.seven);
        nums[8] = (Button)findViewById(R.id.eight);
        nums[9] = (Button)findViewById(R.id.nine);
        textView = (TextView)findViewById(R.id.main_text_view);
        add = (Button)findViewById(R.id.add);
        minus = (Button)findViewById(R.id.minus);
        calculate = (Button)findViewById(R.id.calculate);
        output = (TextView)findViewById(R.id.result);



        for(int i=0;i<10;i++){
            nums[i].setOnClickListener(this);
        }
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == add.getId()){
            if(((String)textView.getText()).length() > 0){
                result+=Integer.parseInt((String)textView.getText());
                output.setText("="+result);
                textView.setText("");
            }
        }else if(id == minus.getId()){
            if(((String)textView.getText()).length() > 0){
                result-=Integer.parseInt((String)textView.getText());
                output.setText("="+result);
                textView.setText("");
            }
        }else if(id == calculate.getId()){

        }else{
            for(int i=0;i<10;i++){
                if(id == nums[i].getId()){
                    textView.setText((String)textView.getText()+i);
                }
            }
        }
    }
}
