package io.los.gringos.trashporter.android.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import io.los.gringos.trashporter.android.model.DistanceMatrix;
import io.los.gringos.trashporter.android.rest.ApiClient;
import io.los.gringos.trashporter.android.rest.ApiInterface;
import io.los.gringos.trashporter.android.utils.ReadFromFile;

import io.los.gringos.trashporter.R;
import retrofit2.Call;

public class ImportActivity extends AppCompatActivity {

    Button addFileButton;
    private TextView filePathText;
    private Button loadDefaultsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);

        addFileButton = findViewById(R.id.addButton);
        addFileButton.setOnClickListener(addFileButtonClicked);

        loadDefaultsButton = findViewById(R.id.importDefaultButtons);
        loadDefaultsButton.setOnClickListener(loadDefaultsButtonClicked);

        filePathText = findViewById(R.id.fileTextView);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        }
    }



    private View.OnClickListener addFileButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            new MaterialFilePicker()
                    .withActivity(ImportActivity.this)
                    .withRequestCode(1000)
                    .withHiddenFiles(true) // Show hidden files and folders
                    .start();
        }

        };


    private View.OnClickListener loadDefaultsButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getBaseContext(), Map.class));
        }
    };

        @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);

            // Do anything with file. filepath is on filepath variable

            filePathText.setText(filePath);

            ReadFromFile fileReader = new ReadFromFile();
            fileReader.printFileLinesOnTerminal(filePath);

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1000: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
                }
                finish();

            }


    }
    };

}
