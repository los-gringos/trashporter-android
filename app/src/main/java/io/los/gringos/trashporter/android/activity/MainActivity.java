package io.los.gringos.trashporter.android.activity;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.los.gringos.trashporter.R;

public class MainActivity extends AppCompatActivity {

    private Button getStarted;

    private Button importFileButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //startActivity(new Intent(getBaseContext(), NavDrawerActivity.class));

        //getStarted Button
        getStarted = findViewById(R.id.getStartedButton);
        getStarted.setOnClickListener(getStartedButtonClicked);


    }


    View.OnClickListener getStartedButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getBaseContext(), ImportActivity.class));
        }
    };


}
