package com.zeroq.volley;

import android.util.Log;
import com.android.volley.*;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by user-1 on 3/10/15.
 */
public class GenericPostVolleyRequest<T> extends Request<String> {

    private final Response.Listener<String> mListener;
    HttpEntity entity;


    public GenericPostVolleyRequest(String url, Response.ErrorListener errorListener, Response.Listener<String> listener, T requestDto) {
        super(Method.POST, url, errorListener);
        try {
            entity = new StringEntity(new Gson().toJson(requestDto));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mListener = listener;
    }

    @Override
    public String getBodyContentType() {
        Log.i("GPVR", "Content Type : " + entity.getContentType().getValue());
        return "application/json";
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            entity.writeTo(bos);
        } catch (IOException e) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream");
        }
        return bos.toByteArray();
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            Log.i("GPVR", "json response = " + json);
            return Response.success(json, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(String response) {
        Log.i("GPVR", " response = " + response);
        if(mListener != null) {
            mListener.onResponse(response);
        }
    }
}
