package com.example.unityplugin;

import android.app.Activity;
import android.widget.Toast;

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

}
