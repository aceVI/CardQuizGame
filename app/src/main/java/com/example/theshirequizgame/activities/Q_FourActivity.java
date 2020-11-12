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

public class Q_FourActivity extends AppCompatActivity implements View.OnClickListener {

    private Button confirm4;
    private ImageView back;
    private ImageView Background_img4;
    private RadioGroup radioGroup_q4;
    RadioButton radioButton;

    private RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);

        findViews();
    }

    private void findViews() {
        confirm4 = (Button) findViewById(R.id.confirm4);
        confirm4.setOnClickListener(this);

        Background_img4 = (ImageView) findViewById(R.id.Background_img4);
        Background_img4.setOnClickListener(this);

        radioGroup_q4 = (RadioGroup) findViewById(R.id.radioGroup_q4);
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
            case R.id.confirm4:
                // get selected radio button from radioGroup
                int selectedId = radioGroup_q4.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                try {
                    if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {
                        Intent intoFifthIntent = new Intent(Q_FourActivity.this, Q_FiveActivity.class);
                        startActivity(intoFifthIntent);
                        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);

                        Utilities.ans4 = radioButton.getText().toString();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please choose your answer", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(), "Please choose your answer", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.Background_img4:
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                finish();
                break;
        }
    }

    private void backup() {
        if (Utilities.ans4 != null) {
            switch (Utilities.ans4) {
                case "Cheese":
                    rb1.setChecked(true);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    break;

                case "Bacon":
                    rb1.setChecked(false);
                    rb2.setChecked(true);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    break;

                case "Strawberries":
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(true);
                    rb4.setChecked(false);
                    break;

                case "Mushrooms":
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(true);
                    break;
            }
        }
    }

}

