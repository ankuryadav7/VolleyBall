# VolleyBall

It's a networking library. You can call RESTful APIs in your project by using this.

![FusedBulb](https://s20.postimg.org/4fobt34pp/volley_banner.jpg)

Gradle
------
```
dependencies {
    ...
   compile 'com.ankuryadav.lib:volleylib:1.0.3'
}
```

Maven
------
```
dependencies {
    ...
   <dependency>
       <groupId>com.ankuryadav.lib</groupId>
       <artifactId>volleylib</artifactId>
       <version>1.0.3</version>
       <type>pom</type>
   </dependency>
}
```

Below are the simple steps by which you can integrate VolleyBall library in your project.

* **Step 1-->>**
Add **"VolleyResponseListener"** in your main class. By implementing this you will get below two methods.
```java
 @Override
    public void volleyResponse(String response, String type) {
        Log.w("VolleyBall response",response+"");
    }

    @Override
    public void responseError(String volleyError) {
        Log.w("VolleyBall error",volleyError+"");
    }
```
* **Step 2-->>**
Take a refrence of **"VolleyRequest"** in an activity
```java
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VolleyRequest volleyRequest=new VolleyRequest(this);
    }
}
```
Take a refrence of **"VolleyRequest"** in a fragment
```java
public class DemoFragment extends Fragment{
   
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v=inflater.inflate(R.layout.demo_fragment, container, false);
       
    VolleyRequest volleyRequest=new VolleyRequest(this);
    return v;
   
  }
}
```
* **REST call**
```java
 VolleyRequest volleyRequest=new VolleyRequest(this);
        Map<String, String> params = new Hashtable<String, String>();
        params.put("email",   "xyz@mail.com");
        params.put("password", "123456");
        
 volleyRequest.stringPostCall("http://xyz.com/app/json/login?",params,"LOGIN");

```

Developed By
 ------
 Ankur Yadav- ankuryadavaj729@gmail.com
