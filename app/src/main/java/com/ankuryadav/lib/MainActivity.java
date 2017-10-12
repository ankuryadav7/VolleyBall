package com.ankuryadav.lib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ankuryadav.lib.helper.GlobalUrl;
import com.ankuryadav.lib.helper.RequestParams;
import com.ankuryadav.volleylib.VolleyRequest;
import com.ankuryadav.volleylib.helper.VolleyLogs;
import com.ankuryadav.volleylib.interfaces.VolleyResponseListener;


/**
 * Created by AnkurYadav on 9/5/2017.
 */

public class MainActivity extends AppCompatActivity implements VolleyResponseListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView callID=(TextView)findViewById(R.id.callID);
        callID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VolleyRequest volleyRequest=new VolleyRequest(MainActivity.this);
                //volley call for string request with parameters
                volleyRequest.stringPostCall(GlobalUrl.RequestLoginURL, RequestParams.LoginParams("emailvalue","passwordvalue"),"LOGIN");

           /* //volley call for jsonobject request with headers
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer "+"access_token");
                headers.put("X-Oc-Image-Dimension", "500x207");
                volleyRequest.jsonObjectGetWithHeaderCall("http://xyz.com/app/json/login?",headers,"GETDATA");*/

            }
        });
    }


    /**
     * @param response
     * @param type
     */
    @Override
    public void volleyResponse(String response, String type) {
        VolleyLogs.display("volleyResponse",response);
    }

    /**
     * @param volleyError
     */
    @Override
    public void responseError(String volleyError) {
        VolleyLogs.display("volleyError",volleyError.toString());
    }
}
