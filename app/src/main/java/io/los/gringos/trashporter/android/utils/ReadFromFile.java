package io.los.gringos.trashporter.android.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    String path;

    public ReadFromFile() {

    }

    public String printFileLinesOnTerminal(String path){

        File file = new File(path);
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');

            }
            br.close();
        }
        catch (IOException e) {

        }

        return text.toString();


    }










}
