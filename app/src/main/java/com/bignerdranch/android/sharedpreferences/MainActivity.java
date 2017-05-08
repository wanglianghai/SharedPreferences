package com.bignerdranch.android.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mButton;
    private Button mButtonRestoreData;

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

        mButtonRestoreData = (Button) findViewById(R.id.button_restore_data);
        mButtonRestoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences editor = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
                String classNameDefault = getResources().getString(R.string.saved_high_class_default);
                Log.i(TAG, "class is " + editor.getString(getString(R.string.saved_high_class), classNameDefault));
                Log.i(TAG, "score is: " + editor.getInt(getString(R.string.saved_high_score), 10));
            }
        });
    }
}
