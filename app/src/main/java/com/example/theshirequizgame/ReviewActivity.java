package com.example.theshirequizgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener {

    private Button Home_btn;
    private ImageView Background_img;
    private TextView text_ans1,text_ans2,text_ans3,text_ans4,text_ans5;
    String selected_ans1,selected_ans2,selected_ans3,selected_ans4,selected_ans5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        findViews();
        setAnswers();
    }



    private void findViews() {
        Home_btn=(Button)findViewById(R.id.Home_btn);
        Home_btn.setOnClickListener(this);

        Background_img=(ImageView)findViewById(R.id.Background_img);
        Background_img.setOnClickListener(this);

        text_ans1=(TextView)findViewById(R.id.text_ans1);
        text_ans2=(TextView)findViewById(R.id.text_ans2);
        text_ans3=(TextView)findViewById(R.id.text_ans3);
        text_ans4=(TextView)findViewById(R.id.text_ans4);
        text_ans5=(TextView)findViewById(R.id.text_ans5);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.Home_btn:
                Intent start = new Intent(ReviewActivity.this, HomeActivity.class);
                startActivity(start);
                finish();
                break;

            case R.id.Background_img:
                finish();
                break;
        }
    }

    private void setAnswers() {
      //Question 1
        if(Utilities.ans1.equals("New Zealand")){
            selected_ans1="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.ans1 + " </font> </body><html>";
        }else {
            selected_ans1="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.ans1 + " </font> </body><html>";
        }
        text_ans1.setText(Html.fromHtml( selected_ans1));

        //Question 2
        if(Utilities.ans2.equals("5")){
            selected_ans2="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.ans2 + " </font> </body><html>";
        }else {
            selected_ans2="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.ans2 + " </font> </body><html>";
        }
        text_ans2.setText(Html.fromHtml( selected_ans2));

        //Question 3
        if(Utilities.ans3.equals("Mushrooms")){
            selected_ans3="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.ans3 + " </font> </body><html>";
        }else {
            selected_ans3="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.ans3 + " </font> </body><html>";
        }
        text_ans3.setText(Html.fromHtml( selected_ans3));


        //Question 4
        if(Utilities.ans4.equals("Strawberries")){
            selected_ans4="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.ans4 + " </font> </body><html>";
        }else {
            selected_ans4="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.ans4 + " </font> </body><html>";
        }
        text_ans4.setText(Html.fromHtml( selected_ans4));

        //Question 5
        if(Utilities.ans5.equals("Barad Dur")){
            selected_ans5="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.ans5 + " </font> </body><html>";
        }else {
            selected_ans5="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.ans5 + " </font> </body><html>";
        }
        text_ans5.setText(Html.fromHtml( selected_ans5));
    }
}
