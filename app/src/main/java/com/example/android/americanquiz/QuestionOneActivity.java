package com.example.android.americanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class QuestionOneActivity extends AppCompatActivity {
    private Score score;
    private int weight;
    private EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_freetext);
        answer = null;

        //get score values from last activity
        Intent intent = this.getIntent();
        Bundle b = intent.getExtras();
        score = b.getParcelable("intScore");

        //Question weight - later we can make this db driven
        weight = 120;
        //Setting weight for the question in the view
        TextView weightText = (TextView) findViewById(R.id.ques_free_weight);
        String setWeightText = "Weight: " + weight;
        weightText.setText(setWeightText);

        //Setting current score for the user in the view
        TextView scoreText = (TextView) findViewById(R.id.ques_free_score);
        String setScoreText = "Score: " + score.getGetTotalScore();
        scoreText.setText(setScoreText);

        //Setting question for the view
        TextView question = (TextView) findViewById(R.id.ques_free_question);
        String questionText = getResources().getString(R.string.question_one);
        question.setText(questionText);

        //Setting image for the question in the view
        ImageView image = (ImageView) findViewById(R.id.ques_free_image);
        Picasso.with(this)
                .load(R.drawable.picture_1)
                .fit()
                .into(image);


        // Find the View that shows the home button
        Button submitButton = (Button) findViewById(R.id.ques_free_button);
        // Set a click listener on that View
        submitButton.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the home button is clicked on.
            @Override
            public void onClick(View view) {
                String answer_input_text = getResources().getString(R.string.answer_one).toLowerCase();
                answer = (EditText) findViewById(R.id.ques_free_editText);
                String dbAnswer = answer.getText().toString().toLowerCase();
                String result;
                if (answer_input_text.equals(dbAnswer)) {
                    int updatedScore = score.getGetTotalScore() + weight;
                    int updatedCount = score.getCorrectCount() + 1;
                    score.setCorrectCount(updatedCount);
                    score.setTotalScore(updatedScore);
                    result = "Correct Answer";
                } else {
                    result = "Wrong Answer";
                }
                Toast.makeText(QuestionOneActivity.this, result, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(QuestionOneActivity.this, QuestionTwoActivity.class);
                Score mParcel = score;
                intent.putExtra("oneScore", mParcel);
                startActivity(intent);
            }
        });
    }

}