package com.example.fernandoperez.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Find and put the data received.
        String result = getIntent().getStringExtra(Commons.TEXT_EXTRA);

        TextView textView = (TextView) findViewById(R.id.result_view);
        textView.setText(result);
    }
}
