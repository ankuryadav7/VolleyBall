package com.ankuryadav.volleylib.request;

import android.app.Activity;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ankuryadav.volleylib.helper.TimeContstant;

/**
 * Created by AnkurYadav on 9/5/2017.
 */

public class VolleyRequestQueue {
    /**
     * @param context
     * @param jsonRequest
     */
    public void addJsonRequet(Activity context, JsonObjectRequest jsonRequest) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        TimeContstant timeContstant=new TimeContstant();
        int socketTimeout = timeContstant.getTimeout();
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsonRequest.setRetryPolicy(policy);
        requestQueue.add(jsonRequest);
    }

    /**
     * @param context
     * @param stringRequest
     */
    public void addStringRequet(Activity context, StringRequest stringRequest) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        TimeContstant timeContstant=new TimeContstant();
        int socketTimeout = timeContstant.getTimeout();
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }
}
