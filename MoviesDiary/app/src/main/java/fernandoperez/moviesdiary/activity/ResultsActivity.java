package fernandoperez.moviesdiary.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import fernandoperez.moviesdiary.R;
import fernandoperez.moviesdiary.utils.Commons;

public class ResultsActivity extends AppCompatActivity {
    public static String MESSAGE_MAIN_ACTIVITY = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Getting the intent.
        Intent intent = this.getIntent();
        String message = intent.getStringExtra(Commons.USER_MESSAGE);

        // Setting it to the text view.
        TextView textView = (TextView) this.findViewById(R.id.results_textview);
        textView.setText(message);

    }
}
