package com.gmail.leylol.leyltc;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by User on 14-Dec-16.
 */

public class SynUser extends AsyncTask<Void, Void, String> {
    //Explicit

    private Context context;
    private static final String urlJSONSTRING = "http://swiftcodingthai.com/ltc/get_user_ley.php";

    public SynUser(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSONSTRING).build();
            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();

        } catch (Exception e) {
            Log.d("14Dec2016", "e doin ==> " + e.toString());

            return null;
        }
    }
}   //Main Class
