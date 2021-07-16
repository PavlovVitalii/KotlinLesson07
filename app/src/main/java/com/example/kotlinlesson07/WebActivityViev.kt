package com.example.kotlinlesson07

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebActivityViev : AppCompatActivity() {

    private lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_viev)

        myWebView = findViewById<WebView>(R.id.web_id).apply {
            settings.javaScriptEnabled = true
            webViewClient = MyWebViewClient()
            webChromeClient = MyChromeWebViewClient()
            loadUrl("https://kotlinlang.ru/")
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

private class MyChromeWebViewClient : WebChromeClient() {

    //  handle Javascript dialogs, favicons, titles, and the progress
}
