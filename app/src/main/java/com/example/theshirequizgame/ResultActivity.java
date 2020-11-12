package com.example.theshirequizgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

   public  static int final_Score;
    private ImageView status_img;
    private TextView score_txt;
    private Button Home_btn;
    private Button result_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        findViews();
        scoreForQuiz();
    }

    private void findViews() {
        status_img=(ImageView)findViewById(R.id.status_img);
        score_txt=(TextView)findViewById(R.id.score_txt);

        Home_btn=(Button)findViewById(R.id.Home_btn);
        Home_btn.setOnClickListener(this);

        result_btn=(Button)findViewById(R.id.result_btn);
        result_btn.setOnClickListener(this);
    }

    private void scoreForQuiz() {
         final_Score=0;
        if(Utilities.ans1.equals("New Zealand")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.ans2.equals("5")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.ans3.equals("Mushrooms")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.ans4.equals("Strawberries")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.ans5.equals("Barad Dur")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        setImage(final_Score);

    }

    private void setImage(int score) {
        String text="<html><body><font color=#91A1AB> <small> Your Result:  </small> </font> <font color=#826FDB><big> "+ score + "/5" + "</big> </font> </body><html>";

        score_txt.setText(Html.fromHtml( text));

        if(score==5){
            status_img.setBackgroundResource(R.drawable.confetti);
        }else if(score>=3){
            status_img.setBackgroundResource(R.drawable.green_checkmark);
        }else {
            status_img.setBackgroundResource(R.drawable.red_checkmark);
        }
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.Home_btn:
                Intent start = new Intent(ResultActivity.this, HomeActivity.class);
                startActivity(start);
                finish();
                break;

            case R.id.result_btn:
                Intent start1 = new Intent(ResultActivity.this, ReviewActivity.class);
                startActivity(start1);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}
