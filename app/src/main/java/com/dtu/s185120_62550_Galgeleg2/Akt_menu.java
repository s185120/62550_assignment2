package com.dtu.s185120_62550_Galgeleg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Akt_menu extends AppCompatActivity implements View.OnClickListener {

    private Button startButton, historyButton, helpButton;
    private TextView wonValue, lostValue, streakValue;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.akt_menu);

        // Initialising variables
        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
        historyButton = findViewById(R.id.historyButton);
        historyButton.setOnClickListener(this);
        helpButton = findViewById(R.id.helpButton);
        helpButton.setOnClickListener(this);
        wonValue = findViewById(R.id.wonValue);
        lostValue = findViewById(R.id.lostValue);
        streakValue = findViewById(R.id.streakValue);

    }

    @Override
    protected void onResume() {
        super.onResume();
        preferences = this.getSharedPreferences(String.valueOf(R.string.prefs), Context.MODE_PRIVATE);

        // Handling the player's stats
        wonValue.setText(String.valueOf(preferences.getInt("numberOfWon", 0)));
        lostValue.setText(String.valueOf(preferences.getInt("numberOfLost", 0)));
        streakValue.setText(String.valueOf(preferences.getInt("streak", 0)));
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v == startButton) {
            intent = new Intent(this, Akt_game.class);
        } else if (v == historyButton) {
            intent = new Intent(this, Akt_history.class);
        } else if (v == helpButton) {
            intent = new Intent(this, Akt_help.class);
        }
        startActivity(intent);
    }
}
