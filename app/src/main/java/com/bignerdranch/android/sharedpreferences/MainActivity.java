package com.bignerdranch.android.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button_shared_preferences);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(
                        getString(R.string.preference_file_key), Context.MODE_PRIVATE).edit();
                editor.putInt(getString(R.string.saved_high_score), 100);
                editor.putString(getString(R.string.saved_high_class), "English");
                editor.commit();
            }
        });
    }
}
