package com.example.android.americanquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //initialize score;
        score = new Score(0, 0);

        // Find the View that shows the home button
        Button mainButton = (Button) findViewById(R.id.button_main);

        // Set a click listener on that View
        mainButton.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the home button is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(MainActivity.this, QuestionOneActivity.class);
                Score mParcel = score;
                intent.putExtra("intScore", mParcel);
                // Start the new activity
                startActivity(intent);
            }
        });
    }
}
