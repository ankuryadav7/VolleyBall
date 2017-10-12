package com.ankuryadav.volleylib.interfaces;

/**
 * Created by AnkurYadav on 9/5/2017.
 */
public interface VolleyResponseListener {

    void volleyResponse(String response, String type);
    void responseError(String volleyError);

}
