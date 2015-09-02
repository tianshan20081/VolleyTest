package com.gooker.volleytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.gooker.volleytest.network.VolleyInterface;
import com.gooker.volleytest.network.VolleyRequest;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

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


}
