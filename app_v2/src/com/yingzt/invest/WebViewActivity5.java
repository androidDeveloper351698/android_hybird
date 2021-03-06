package com.yingzt.invest;

import com.yzt.invest.webview.YZTWebView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import android.webkit.WebView;

public class WebViewActivity5 extends Activity {
	private YZTWebView webView;

	@SuppressLint({ "NewApi", "SetJavaScriptEnabled" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity1_web_view);
		YZTUtils.log(1, "onCreate");
		webView = (YZTWebView) findViewById(R.id.webView);
		webView.customWebView();
		Intent intent = getIntent();
		String lauchUrl = intent.getStringExtra("url");
		webView.loadUrl(lauchUrl);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		try {
			super.onConfigurationChanged(newConfig);
			if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
				// land
			} else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
				// port
			}
		} catch (Exception ex) {
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (webView.canGoBack()) {
				webView.goBack();
				return true;
			} else {
				super.onBackPressed();
				overridePendingTransition(R.anim.in_from_left,
						R.anim.out_to_right);
			}

		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
	}
}
