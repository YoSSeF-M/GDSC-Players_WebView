package com.yquery.gdsc_players_webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.yquery.gdsc_players_webview.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    lateinit var binding : ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myWebView = binding.webView
        myWebView.loadUrl("https://www.google.com")
        myWebView.settings.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()

    }
}