package com.example.android.americanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class QuestionFourActivity extends AppCompatActivity {
    private Score score;
    private int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_radiobutton);

        //get score values from last activity
        Intent intent = this.getIntent();
        Bundle b = intent.getExtras();
        score = b.getParcelable("threeScore");

        //Question weight - later we can make this db driven
        weight = 50;
        //Setting weight for the question in the view
        TextView weightText = (TextView) findViewById(R.id.ques_radio_weight);
        String setWeightText = "Weight: " + weight;
        weightText.setText(setWeightText);

        //Setting current score for the user in the view
        TextView scoreText = (TextView) findViewById(R.id.ques_radio_score);
        String setScoreText = "Score: " + score.getGetTotalScore();
        scoreText.setText(setScoreText);

        //Setting question for the view
        TextView question = (TextView) findViewById(R.id.ques_radio_question);
        String questionText = getResources().getString(R.string.question_four);
        question.setText(questionText);

        //Set answer options for checkboxes
        RadioButton option_one = (RadioButton) findViewById(R.id.radio_option_one);
        String option_one_text = getResources().getString(R.string.answer_four_option_one);
        option_one.setText(option_one_text);

        RadioButton option_two = (RadioButton) findViewById(R.id.radio_option_two);
        String option_two_text = getResources().getString(R.string.answer_four_option_two);
        option_two.setText(option_two_text);

        //Setting image for the question in the view
        ImageView image = (ImageView) findViewById(R.id.ques_radio_image);
        Picasso.with(this)
                .load(R.drawable.picture_4)
                .fit()
                .into(image);

        // Find the View that shows the home button
        Button submitButton = (Button) findViewById(R.id.ques_radio_button);
        // Set a click listener on that View
        submitButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the home button is clicked on.
            @Override
            public void onClick(View view) {
                RadioButton answer_one = (RadioButton) findViewById(R.id.radio_option_one);
                RadioButton answer_two = (RadioButton) findViewById(R.id.radio_option_two);
                String result;
                if (answer_one.isChecked() && !answer_two.isChecked()) {
                    int updatedScore = score.getGetTotalScore() + weight;
                    int updatedCount = score.getCorrectCount() + 1;
                    score.setCorrectCount(updatedCount);
                    score.setTotalScore(updatedScore);
                    result = "Correct Answer";
                } else {
                    result = "Wrong Answer";
                }
                Toast.makeText(QuestionFourActivity.this, result + "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(QuestionFourActivity.this, QuestionFiveActivity.class);
                Score mParcel = score;
                intent.putExtra("fourScore", mParcel);
                startActivity(intent);
            }
        });
    }
}