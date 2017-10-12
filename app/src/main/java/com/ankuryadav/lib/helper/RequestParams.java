package com.ankuryadav.lib.helper;

import java.util.Hashtable;
import java.util.Map;


/**
 * Created by AnkurYadav on 9/5/2017.
 */

public class RequestParams {
    public static Map<String, String> SignupParams(String name, String email, String phone, String password,String authToken) {
        Map<String, String> params = new Hashtable<String, String>();
        params.put("fname",   name);
        params.put("email",   email);
        params.put("contact_no",  phone);
        params.put("password",   password);
        params.put("auth_code", authToken);
        return params;
    }

    public static Map<String, String> LoginParams(String email, String password) {
        Map<String, String> params = new Hashtable<String, String>();
        params.put("email",   email);
        params.put("password",   password);
        return params;
    }


}
