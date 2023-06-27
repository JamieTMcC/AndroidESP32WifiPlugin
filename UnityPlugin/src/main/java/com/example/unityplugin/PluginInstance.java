package com.example.unityplugin;

import android.app.Activity;
import android.widget.Toast;
import java.io.*;
import java.net.*;
public class PluginInstance {

    public long getTime(){
        return System.currentTimeMillis();
    }


    private static Activity unityActivity;

    public static void setUnityActivity(Activity unityActivity) {
        PluginInstance.unityActivity = unityActivity;
    }

    public void Toast(String message){
        Toast.makeText(unityActivity, message, Toast.LENGTH_SHORT).show();
    }

    public String getHTML() throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL("http://192.168.4.1");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }
}
