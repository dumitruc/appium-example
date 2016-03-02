package com.dumitruc.appium.support;


import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dima on 16/02/2014.
 */
public class JsonImpl {

    Gson gson = new Gson();

    public <T> T loadObjectFromJson(String jsonPath, Class<T> clazz) throws FileNotFoundException {

        File jsonFile = new File(jsonPath);
        Scanner scanner = new Scanner(jsonFile);
        String text = scanner.useDelimiter("\\A").next();

        return gson.fromJson(text, clazz);
    }
}
