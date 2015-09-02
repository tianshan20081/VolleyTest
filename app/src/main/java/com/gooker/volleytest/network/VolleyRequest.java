package com.gooker.volleytest.network;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.gooker.volleytest.application.MyApplication;

import java.util.Map;

/**
 * Created by mz on 15/9/2.
 */
public class VolleyRequest {

	public static void doGetRequest(String url, String tag, VolleyInterface volleyInterface) {
		MyApplication.getRequestQueue().cancelAll(tag);
		StringRequest stringRequest = new StringRequest(Request.Method.GET, url, volleyInterface.loadingListener(), volleyInterface.errorListener());
		stringRequest.setTag(tag);
		MyApplication.getRequestQueue().add(stringRequest);
		MyApplication.getRequestQueue().start();
	}

	public static void doPostRequest(String url, String tag, VolleyInterface volleyInterface, final Map<String, String> map) {
		MyApplication.getRequestQueue().cancelAll(tag);
		StringRequest stringRequest = new StringRequest(Request.Method.POST, url, volleyInterface.loadingListener(), volleyInterface.errorListener()) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				return map;
			}
		};
		stringRequest.setTag(tag);
		MyApplication.getRequestQueue().add(stringRequest);
		MyApplication.getRequestQueue().start();
	}
}
