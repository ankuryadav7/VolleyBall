package com.ankuryadav.volleylib;

import android.app.Activity;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.ankuryadav.volleylib.helper.VolleyLogs;
import com.ankuryadav.volleylib.interfaces.VolleyResponseListener;
import com.ankuryadav.volleylib.request.VolleyRequestQueue;
import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by AnkurYadav on 9/5/2017.
 */
public class VolleyRequest {

    Activity context;
    VolleyResponseListener res;
    public VolleyRequest(Activity context) {
        this.context=context;
        res = (VolleyResponseListener)context;
    }

    /**
     * @param URL= URL to be called
     * @param parameters = parameters to be requested
     * @param Type = calling type(eg. login,registration)
     */
    public void stringPostCall(final String URL, final Map<String, String> parameters, final String Type) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        res.volleyResponse(response.toString(),Type);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        res.responseError(volleyError.toString());

                    }
                })
        {
            /**
             * @return
             * @throws AuthFailureError pass parameters to volley request
             */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new Hashtable<String, String>();
                params.putAll(parameters);
                String url="";
                Iterator myVeryOwnIterator = params.keySet().iterator();
                while(myVeryOwnIterator.hasNext()) {
                    String key=(String)myVeryOwnIterator.next();
                    String value=(String)params.get(key);
                    url+="&"+key+"="+value;
                }
                VolleyLogs.display("CalledUrl",URL + url);
                return params;
            }
        };

        VolleyRequestQueue vRequestQueue=new VolleyRequestQueue();
        vRequestQueue.addStringRequet(context,stringRequest);

    }


    /**
     * @param URL= URL to be called
     * @param parameters = parameters to be requested
     * @param Type = calling type(eg. login,registration)
     */
    public void jsonObjectGetWithHeaderCall(final String URL, final Map<String, String> parameters, final String Type) {
        Map<String, String> jsonParams = new HashMap<String, String>();

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, URL, new JSONObject(jsonParams),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        res.volleyResponse(response.toString(),Type);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        res.responseError(volleyError.toString());
                    }
                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.putAll(parameters);
                return headers;
            }
        };
        VolleyRequestQueue vRequestQueue=new VolleyRequestQueue();
        vRequestQueue.addJsonRequet(context,jsonRequest);

    }

    /**
     * @param URL= URL to be called
     * @param parameters = parameters to be requested
     * @param Type = calling type(eg. login,registration)
     */
    public void jsonObjectPostCall(final String URL, final Map<String, String> parameters, final String Type) throws IOException {

        Map<String, String> jsonParams = new HashMap<String, String>();
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.POST,
                URL,
                new JSONObject(jsonParams),

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        res.volleyResponse(response.toString(),Type);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                       res.responseError(volleyError.toString());
                    }
                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.putAll(parameters);
                return headers;
            }
        };

        VolleyRequestQueue vRequestQueue=new VolleyRequestQueue();
        vRequestQueue.addJsonRequet(context,jsonRequest);

    }


}
