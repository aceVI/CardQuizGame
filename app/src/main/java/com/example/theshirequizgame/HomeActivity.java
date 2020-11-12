package com.example.theshirequizgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.theshirequizgame.activities.Q_OneActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout start_btn;
    TextView priorScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        findViews();
    }

    private void findViews() {
        start_btn = (LinearLayout) findViewById(R.id.start_btn);
        start_btn.setOnClickListener(this);

        priorScore = (TextView) findViewById(R.id.priorScore);

        if(Utilities.Result_btn_click){
            priorScore.setVisibility(View.VISIBLE);
            priorScore.setText("Your Prior Score is : "+ ResultActivity.final_Score+"/5");
        }else{
            priorScore.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.start_btn :
                Utilities.ans1="";
                Utilities.ans2="";
                Utilities.ans3="";
                Utilities.ans4="";
                Utilities.ans5="";
                ResultActivity.final_Score=0;
                Utilities.Result_btn_click = false;

                Intent start = new Intent(HomeActivity.this, Q_OneActivity.class);
                startActivity(start);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Utilities.Result_btn_click){
            priorScore.setVisibility(View.VISIBLE);
            priorScore.setText("Your Prior Score is : "+ ResultActivity.final_Score+"/5");
        }else{
            priorScore.setVisibility(View.GONE);
        }
    }
}
