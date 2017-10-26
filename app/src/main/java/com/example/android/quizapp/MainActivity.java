package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int numberOfRight=0;
    String resultSummary="";
    String faultQuiz="";
    boolean Q2IsRight=false;
    boolean Q3IsRight=false;
    boolean Q4IsRight=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswer(View view){
        //Initialization
        numberOfRight=0;
        resultSummary="";
        faultQuiz="";

        //Check the answers whether right or not
        CheckQ1();
        CheckQ2(Q2IsRight);
        CheckQ3(Q3IsRight);
        CheckQ4(Q4IsRight);
        CheckQ5();

        //Get the summary text to toast
        resultSummary = DisplayResult();

       /* Show the summary message ----- TextView method*/
//        TextView SummaryText= (TextView) findViewById(R.id.summary_text_view);
//        SummaryText.setText(resultSummary);

       /* Show the summary message ----- Toast method*/
        Toast.makeText(this,resultSummary,Toast.LENGTH_LONG).show();


    }

    //Check the answer whether right or not
    public void CheckQ1(){
        String Q1_Answer="Canberra";
        EditText inputQ1Answer = (EditText) findViewById(R.id.Q1_input);
        String input_answer = inputQ1Answer.getText().toString();
        if(Q1_Answer.equals(input_answer)){
            numberOfRight+=1;
        }else {
            faultQuiz +="Q1 ";
        }
    }

    public void CheckQ2(boolean rightAnswer){
        if(rightAnswer){
            numberOfRight+=1;
        }else{
            faultQuiz+="Q2 ";
        }
    }

    public void CheckQ3(boolean rightAnswer){
        if(rightAnswer){
            numberOfRight+=1;
        }else{
            faultQuiz+="Q3 ";
        }
    }

    public void CheckQ4(boolean rightAnswer){
        if(rightAnswer){
            numberOfRight+=1;
        }else{
            faultQuiz+="Q4 ";
        }
    }

    public void CheckQ5(){
        CheckBox BlueCheckBox = (CheckBox) findViewById(R.id.Q5_A1);
        CheckBox GreenCheckBox = (CheckBox) findViewById(R.id.Q5_A2);
        CheckBox RedCheckBox = (CheckBox) findViewById(R.id.Q5_A3);
        boolean hasBlueChecked = BlueCheckBox.isChecked();
        boolean hasGreenChecked = GreenCheckBox.isChecked();
        boolean hasRedChecked= RedCheckBox.isChecked();

        if(hasBlueChecked && hasGreenChecked && (!hasRedChecked)){
            numberOfRight+=1;
        } else{
            faultQuiz+="Q5 ";
        }
    }

    //Get the answers from each quiz
    public void Q2buttonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        int checkedId= view.getId();
        // Check which radio button was clicked
        if(checked && (checkedId==R.id.Q2_A2) ){
            Q2IsRight = true;
        }else{
            Q2IsRight= false;
        }
    }

    public void Q3buttonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        int checkedId= view.getId();
        // Check which radio button was clicked
        if(checked && (checkedId==R.id.Q3_A1) ){
            Q3IsRight = true;
        }else{
            Q3IsRight =false;
        }
    }

    public void Q4buttonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        int checkedId= view.getId();
        // Check which radio button was clicked
        if(checked && (checkedId==R.id.Q4_A2) ){
            Q4IsRight = true;
        }else{
            Q4IsRight =false;
        }
    }

    //Form the summary text
    public String DisplayResult(){
        String resultText;
        resultText  = "You've got "+ numberOfRight+" out of 5 points.";
        if(numberOfRight == 5){
            resultText+="\nCongratulations!";
        }
        else if(numberOfRight==4){
            resultText+="\nThe answer of "+ faultQuiz+" is wrong. \nPlease try again.";
        }
        else {
            resultText+="\nThe answers of: "+ faultQuiz+" are wrong. \nPlease try again.";
        }
        return resultText;
    }
}
