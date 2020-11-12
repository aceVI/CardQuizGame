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
import com.example.theshirequizgame.ResultActivity;
import com.example.theshirequizgame.Utilities;

public class Q_FiveActivity extends AppCompatActivity implements View.OnClickListener {

    private Button confirm5;
    private ImageView Background_img5;
    private RadioGroup radioGroup_q5;
    RadioButton radioButton;
    private RadioButton rb1, rb2, rb3, rb4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q5);

        findViews();
    }

    private void findViews() {
        confirm5 = (Button) findViewById(R.id.confirm5);
        confirm5.setOnClickListener(this);

        Background_img5 = (ImageView) findViewById(R.id.Background_img5);
        Background_img5.setOnClickListener(this);

        radioGroup_q5 = (RadioGroup) findViewById(R.id.radioGroup_q5);
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
            case R.id.confirm5:
                // get selected radio button from radioGroup
                int selectedId = radioGroup_q5.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                try {
                    if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {
                        Intent intent = new Intent(Q_FiveActivity.this, ResultActivity.class);
                        startActivity(intent);
                        finish();
                        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                        Utilities.Result_btn_click = true;

                        Utilities.ans5 = radioButton.getText().toString();

                    } else {
                        Toast.makeText(getApplicationContext(), "Please choose your answer", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(), "Please choose your answer", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.Background_img5:
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                finish();
                break;
        }
    }

    private void backup() {
        if (Utilities.ans5 != null) {
            switch (Utilities.ans5) {
                case "Osgiliath":
                    rb1.setChecked(true);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    break;

                case "Cirith Ungol":
                    rb1.setChecked(false);
                    rb2.setChecked(true);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    break;

                case "Minas Tirith":
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(true);
                    rb4.setChecked(false);
                    break;

                case "Barad Dur":
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(true);
                    break;
            }
        }
    }

}
