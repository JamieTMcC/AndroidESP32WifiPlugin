package com.example.unityplugin;

import android.app.Activity;
import android.widget.Toast;
import java.io.*;
import java.net.*;
public class PluginInstance {

    public int port;
    public DatagramSocket dsocket;
    public byte[] buffer;
    public DatagramPacket packet;

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
    public void setUpUDP() throws Exception{
        this.port = 2000;
        this.dsocket = new DatagramSocket(port);
        this.buffer = new byte[2048];
        this.packet = new DatagramPacket(buffer, buffer.length);
    }


    public String getUDPPacket() throws Exception{
                // Wait to receive a datagram
                this.dsocket.receive(packet);

                // Convert the contents to a string, and display them
                String msg = new String(buffer, 0, packet.getLength());

                // Reset the length of the packet before reusing it.
                this.packet.setLength(buffer.length);
        return msg;
    }


}

