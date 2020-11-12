package com.example.theshirequizgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.theshirequizgame.R;
import com.example.theshirequizgame.Utilities;

public class Q_OneActivity extends AppCompatActivity implements View.OnClickListener {
    Button confirm1;
    ImageView Background_img1;
    private RadioGroup radioGroup_q1;
    RadioButton radioButton;
    private RadioButton rb1, rb2, rb3, rb4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        findViews();
    }

    private void findViews() {
        confirm1 = (Button) findViewById(R.id.confirm1);
        confirm1.setOnClickListener(this);

        Background_img1 = (ImageView) findViewById(R.id.Background_img1);
        Background_img1.setOnClickListener(this);

        radioGroup_q1 = (RadioGroup) findViewById(R.id.radioGroup_q1);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);

        backup();
    }

    private void backup() {
        if (Utilities.ans1 != null) {
            switch (Utilities.ans1) {
                case "New Zealand":
                    rb1.setChecked(true);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    break;

                case "California, USA":
                    rb1.setChecked(false);
                    rb2.setChecked(true);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    break;

                case "Switzerland":
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(true);
                    rb4.setChecked(false);
                    break;

                case "Australia":
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.confirm1:
                // get selected radio button from radioGroup
                int selectedId = radioGroup_q1.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                try {
                    if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {
                        Utilities.ans1 = radioButton.getText().toString();
                        Intent intoSecondIntent = new Intent(Q_OneActivity.this, Q_TwoActivity.class);
                        startActivity(intoSecondIntent);
                        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                    } else {
                        Toast.makeText(getApplicationContext(), "Please choose your answer", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(), "Please choose your answer", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.Background_img1:
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                finish();
                break;

        }
    }
}