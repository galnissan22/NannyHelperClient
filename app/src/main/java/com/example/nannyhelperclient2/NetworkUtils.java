package com.example.nannyhelperclient2;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    public static InputStream GetUrl(Context context, String server_url, String[] parameters){
        try {
            URL url = new URL(server_url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            urlConnection.disconnect();
            return in;
        } catch (IOException e) {
            Utils.AlertMessage(context, "Error", e.toString());
        }
        return null;
    }
}
