package com.example.kotlinlesson07

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WebActivityViev : AppCompatActivity() {

    private lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_viev)

        myWebView = findViewById<WebView>(R.id.web_id).apply {
            settings.javaScriptEnabled = true
            webViewClient = MyWebViewClient()
            loadUrl("https://kotlinlang.ru/")
        }

        findViewById<Button>(R.id.button_back).setOnClickListener {
            if (myWebView.canGoBack()) {
                myWebView.goBack();
            }
        }

        findViewById<Button>(R.id.button_forward).setOnClickListener {

            if (myWebView.canGoForward()) {
                myWebView.goForward()
            }
        }

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()) {
            myWebView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}


private class MyWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return false
    }
}

