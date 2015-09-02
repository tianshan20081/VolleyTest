package com.gooker.volleytest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.gooker.volleytest.application.MyApplication;
import com.gooker.volleytest.domain.BaseResponse;
import com.gooker.volleytest.network.VolleyInterface;
import com.gooker.volleytest.network.VolleyRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		loadData();
	}

	private void loadData() {

		/**
		 * http://v.juhe.cn/weather/index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=您申请的KEY
		 * 名称 	类型 	必填 	说明
		 cityname 	string 	Y 	城市名或城市ID，如："苏州"，需要utf8 urlencode
		 dtype 	string 	N 	返回数据格式：json或xml,默认json
		 format 	int 	N 	未来6天预报(future)两种返回格式，1或2，默认1
		 key 	string 	Y 	你申请的key
		 */
		String url = "http://v.juhe.cn/weather/index?format=2&cityname=" + URLEncoder.encode("北京") + "&key=29de6c1db2e9f856ab596f303104ea85";
		String key = "29de6c1db2e9f856ab596f303104ea85";
		VolleyRequest.doGetRequest(url, url, new VolleyInterface(MainActivity.this, VolleyInterface.mListener, VolleyInterface.mErrorListener) {
			@Override
			public void onSuccess(String response) {
				Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onError(VolleyError response) {
				Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void normal_getString() {
		MyApplication.getRequestQueue().cancelAll(this);
		StringRequest stringRequest = new StringRequest(Request.Method.GET, "", new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				Log.e(TAG, response);
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		MyApplication.getRequestQueue().add(stringRequest);
		MyApplication.getRequestQueue().start();
	}

	private void normal_getJsonObject() {
		MyApplication.getRequestQueue().cancelAll(this);
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "", new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {

			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		MyApplication.getRequestQueue().add(jsonObjectRequest);
		MyApplication.getRequestQueue().start();





	}

	private void normal_loadImg() {
		ImageRequest imageRequest = new ImageRequest("", new Response.Listener<Bitmap>() {
			@Override
			public void onResponse(Bitmap response) {

			}
		}, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		
	}

	private void normal_getJsonArray() {
		JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, "", new Response.Listener<JSONArray>() {
			@Override
			public void onResponse(JSONArray response) {

			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});


		JsonArrayRequest arrayRequest1 = new JsonArrayRequest(Request.Method.POST, "", "", new Response.Listener<JSONArray>() {
			@Override
			public void onResponse(JSONArray response) {

			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

			}
		}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				return super.getParams();
			}
		};
	}


	@Override
	protected void onPause() {
		super.onPause();
		MyApplication.getRequestQueue().cancelAll(this);
	}
}
