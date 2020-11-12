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

public class Q_TwoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button confirm2;
    private ImageView Background_img2;
    private RadioGroup radioGroup_q2;
    private RadioButton rb1, rb2, rb3, rb4;
    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);

        findViews();
    }

    private void findViews() {
        confirm2 = (Button) findViewById(R.id.confirm2);
        confirm2.setOnClickListener(this);

        Background_img2 = (ImageView) findViewById(R.id.Background_img2);
        Background_img2.setOnClickListener(this);

        radioGroup_q2 = (RadioGroup) findViewById(R.id.radioGroup_q2);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);

        backup();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.confirm2:
                // get selected radio button from radioGroup
                int selectedId = radioGroup_q2.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                try {
                    if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {
                        Intent intoThirdIntent = new Intent(Q_TwoActivity.this, Q_ThreeActivity.class);
                        startActivity(intoThirdIntent);
                        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);

                        Utilities.ans2 = radioButton.getText().toString();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please choose your answer", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(), "Please choose your answer", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.Background_img2:
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                finish();
                break;

        }
    }

    private void backup() {
        if (Utilities.ans2 != null) {
            switch (Utilities.ans2) {
                case "3":
                    rb1.setChecked(true);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    break;

                case "4":
                    rb1.setChecked(false);
                    rb2.setChecked(true);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    break;

                case "5":
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(true);
                    rb4.setChecked(false);
                    break;

                case "6":
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(true);
                    break;
            }
        }
    }

}
