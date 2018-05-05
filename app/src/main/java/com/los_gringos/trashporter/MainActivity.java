package com.los_gringos.trashporter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button openMapsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openMapsButton = findViewById(R.id.mainOpenMapsButton);
        openMapsButton.setOnClickListener(openMapsButtonClicked);
    }

    View.OnClickListener openMapsButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getBaseContext(),Map.class));
        }
    };
}
