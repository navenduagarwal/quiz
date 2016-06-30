package com.example.android.americanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Navendu Agarwal on 30-Jun-16.
 */
public class FinishActivity extends AppCompatActivity {
    private Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_finish);
        //get score values from last activity
        Intent intent = this.getIntent();
        Bundle b = intent.getExtras();
        score = b.getParcelable("finalScore");
        int finalScore = score.getGetTotalScore();
        int correctCounter = score.getCorrectCount();


        //Setting header text
        TextView headerText = (TextView) findViewById(R.id.finish_header_text);
        String setHeaderText;
        if (finalScore < 200) {
            setHeaderText = getResources().getString(R.string.header_lost);
        } else {
            setHeaderText = getResources().getString(R.string.header_won);
        }
        headerText.setText(setHeaderText);

        //Setting score text
        TextView scoreText = (TextView) findViewById(R.id.finish_score_text);
        String setScoreText;
        if (finalScore < 200) {
            setScoreText = getResources().getString(R.string.score_lost) + " " + finalScore
                    + getResources().getString(R.string.score_counter) + " " + correctCounter;
        } else {
            setScoreText = getResources().getString(R.string.score_won) + " " + finalScore
                    + getResources().getString(R.string.score_counter) + " " + correctCounter;
        }
        scoreText.setText(setScoreText);

        //Setting Result Image
        ImageView image = (ImageView) findViewById(R.id.finish_image);
        int imageId;
        if (finalScore < 200) {
            imageId = R.drawable.finish_2;
        } else {
            imageId = R.drawable.finish_1;
        }
        Picasso.with(this)
                .load(imageId)
                .fit()
                .into(image);
    }
}
