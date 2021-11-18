package com.gmail.devpelegrino.moplim.util

import android.content.Context
import android.net.ConnectivityManager

fun internetIsConnected(): Boolean {
    return try {
        val command = "ping -c 1 google.com";
        (Runtime.getRuntime().exec(command).waitFor() == 0);
        true
    } catch (e: Exception) {
        false;
    }
}

fun isNetworkConnected(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return connectivityManager.getActiveNetworkInfo() != null;
}