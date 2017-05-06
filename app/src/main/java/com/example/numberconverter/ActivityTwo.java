package com.example.numberconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityTwo extends AppCompatActivity {

    //Declare elements as member variable
    EditText inputTxt;
    EditText outputTxt;
    Button doIt;
    Button clear;
    Button firstOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        //Create references
        inputTxt=(EditText) findViewById(R.id.inputs);
        outputTxt=(EditText) findViewById(R.id.outputs);
        doIt=(Button) findViewById(R.id.doIt);
        clear=(Button) findViewById(R.id.clear);
        firstOption=(Button) findViewById(R.id.firstOption);

        //add listeners

        doIt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String str=inputTxt.getText().toString();
                int n=Integer.parseInt(str);
                String dToB="";
                try{
                    if (n<0)
                        throw new Exception();

                    if (n==0)
                        outputTxt.setText("0");

                        while(n>0)
                        {
                            dToB=String.valueOf(n%2)+dToB;
                            n=n/2;
                        }
                    outputTxt.setText(dToB);

                }
                catch(Exception e){
                    outputTxt.setText("WRONG INPUT- try again");
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputTxt.setText("");
                outputTxt.setText("");
            }
        });

        firstOption.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
