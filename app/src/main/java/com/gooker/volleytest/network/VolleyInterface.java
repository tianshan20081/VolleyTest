package com.gooker.volleytest.network;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by mz on 15/9/2.
 */
public abstract class VolleyInterface {

	private Context mContext;
	public static Response.ErrorListener mErrorListener;
	public static Response.Listener<String> mListener;

	public VolleyInterface(Context context, Response.Listener<String> stringListener, Response.ErrorListener errorListener) {
		this.mContext = context;
		this.mErrorListener = errorListener;
		this.mListener = stringListener;
	}

	public abstract void onSuccess(String response);

	public abstract void onError(VolleyError response);

	public Response.Listener<String> loadingListener() {
		this.mListener = new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				onSuccess(response);
			}
		};
		return this.mListener;
	}

	public Response.ErrorListener errorListener() {
		this.mErrorListener = new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				onError(error);
			}
		};
		return this.mErrorListener;

	}

}
