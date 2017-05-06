package com.example.numberconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    //Declare elements as member variable
    EditText inputTxt;
    EditText outputTxt;
    Button doIt;
    Button clear;
    Button secondOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create references
        inputTxt=(EditText) findViewById(R.id.inputs);
        outputTxt=(EditText) findViewById(R.id.outputs);
        doIt=(Button) findViewById(R.id.doIt);
        clear=(Button) findViewById(R.id.clear);
        secondOption=(Button) findViewById(R.id.secondOption);


        //Set Listeners to Buttons
        doIt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            //perform the conversion
            String str=inputTxt.getText().toString();
                try{
                    for(int i=0;i<str.length()-1;i++)
                    {
                        if(!str.matches("[01]+"))
                           throw new Exception();
                    }
                    int binNum=Integer.parseInt(str,2);
                    String bToD=String.valueOf(binNum);
                    outputTxt.setText(bToD);
                }
                catch(Exception e){
                    outputTxt.setText("WRONG INPUT- try again"); // error message if the input isn't composed of 0 and 1
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

        secondOption.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(getApplicationContext(),ActivityTwo.class);
                startActivity(intent);
            }
        });
    }
}
