package com.example.android.americanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class QuestionTwoActivity extends AppCompatActivity {
    private Score score;
    private int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_checkbox);

        //get score values from last activity
        Intent intent = this.getIntent();
        Bundle b = intent.getExtras();
        score = b.getParcelable("oneScore");

        //Question weight - later we can make this db driven
        weight = 80;
        //Setting weight for the question in the view
        TextView weightText = (TextView) findViewById(R.id.ques_check_weight);
        String setWeightText = "Weight: " + weight;
        weightText.setText(setWeightText);

        //Setting current score for the user in the view
        TextView scoreText = (TextView) findViewById(R.id.ques_check_score);
        String setScoreText = "Score: " + score.getGetTotalScore();
        scoreText.setText(setScoreText);

        //Setting question for the view
        TextView question = (TextView) findViewById(R.id.ques_check_question);
        String questionText = getResources().getString(R.string.question_two);
        question.setText(questionText);

        //Set answer options for checkboxes
        CheckBox option_one = (CheckBox) findViewById(R.id.checkBox_ans_one);
        String option_one_text = getResources().getString(R.string.answer_two_option_one);
        option_one.setText(option_one_text);

        CheckBox option_two = (CheckBox) findViewById(R.id.checkBox_ans_two);
        String option_two_text = getResources().getString(R.string.answer_two_option_two);
        option_two.setText(option_two_text);

        CheckBox option_three = (CheckBox) findViewById(R.id.checkBox_ans_three);
        String option_three_text = getResources().getString(R.string.answer_two_option_three);
        option_three.setText(option_three_text);

        //Setting image for the question in the view
        ImageView image = (ImageView) findViewById(R.id.ques_check_image);
        Picasso.with(this)
                .load(R.drawable.picture_2)
                .fit()
                .into(image);

        // Find the View that shows the home button
        Button submitButton = (Button) findViewById(R.id.ques_check_button);
        // Set a click listener on that View
        submitButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the home button is clicked on.
            @Override
            public void onClick(View view) {
                CheckBox answer_one = (CheckBox) findViewById(R.id.checkBox_ans_one);
                CheckBox answer_two = (CheckBox) findViewById(R.id.checkBox_ans_two);
                CheckBox answer_three = (CheckBox) findViewById(R.id.checkBox_ans_three);
                String result;
                if (!answer_one.isChecked() && answer_two.isChecked() && answer_three.isChecked()) {
                    int updatedScore = score.getGetTotalScore() + weight;
                    int updatedCount = score.getCorrectCount() + 1;
                    score.setCorrectCount(updatedCount);
                    score.setTotalScore(updatedScore);
                    result = "Correct Answer";
                } else {
                    result = "Wrong Answer";
                }
                Toast.makeText(QuestionTwoActivity.this, result, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(QuestionTwoActivity.this, QuestionThreeActivity.class);
                Score mParcel = score;
                intent.putExtra("twoScore", mParcel);
                startActivity(intent);
            }
        });
    }
}