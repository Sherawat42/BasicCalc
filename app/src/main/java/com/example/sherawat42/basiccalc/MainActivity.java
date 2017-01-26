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
    String lastOperation = "+";
    long lastValue=0;
    long result=0;
    long resultTemp=0;

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
        String expression = (String)textView.getText();
        if(id == add.getId()){
            if(expression.length()==0){
                lastOperation="+";
                textView.setText((textView.getText())+" ");
            }else{
                if(Character.isDigit(expression.charAt(expression.length()-1))){
                    if(((String)textView.getText()).length() > 0){
                        textView.setText((textView.getText())+"+");
                        lastOperation="+";
                        updateResult();
                    }
                }
            }
        }else if(id == minus.getId()){
            if(expression.length()==0){
                lastOperation="-";
                textView.setText((textView.getText())+"-");
            }else{
                if(Character.isDigit(expression.charAt(expression.length()-1))){
                    if(((String)textView.getText()).length() > 0){
                        lastOperation="-";
                        textView.setText((textView.getText())+"-");
                        updateResult();
                    }
                }
            }
        }else if(id == calculate.getId()){
            if(Character.isDigit(expression.charAt(expression.length()-1))){
                lastOperation="+";
                textView.setText("");
                updateResult();
                output.setTextSize(70);
            }
        }else{
            for(int i=0;i<10;i++){
                if(id == nums[i].getId()){
                    textView.setText((String)textView.getText()+i);
                    output.setText("="+evaluateResultTemp());
                }
            }
        }
    }

    private void updateResult() {
        result=resultTemp;
    }

    private String evaluateResultTemp() {
        resultTemp=result;
        String expression = (String)textView.getText();
        int curNum=0;
        for(int i=expression.length()-1;i>=0 && Character.isDigit(expression.charAt(i));i--){
            curNum = (int) (curNum+Character.getNumericValue(expression.charAt(i))*Math.pow(10,expression.length()-i-1));
            System.out.println(curNum);
        }
        if (lastOperation=="+"){
            resultTemp+=curNum;
        }else if(lastOperation=="-"){
            resultTemp-=curNum;
        }
        return String.valueOf(resultTemp);
    }
}
