package com.gooker.volleytest.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by mz on 15/8/27.
 */
public class MyApplication extends Application {
	private static RequestQueue mQueue;

	@Override
	public void onCreate() {
		super.onCreate();

		mQueue = Volley.newRequestQueue(getApplicationContext());
	}

	public static RequestQueue getRequestQueue() {
		return mQueue;
	}
}
