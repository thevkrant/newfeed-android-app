package com.vikrant.newsfeed

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.vikrant.newsfeed.databinding.ActivityWebviewBinding

class WebviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebviewBinding

    companion object {
        const val URL_EXTRA = "feed_url"
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val url = intent.getStringExtra(URL_EXTRA)

        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.apply {
            if (url != null) {
                loadUrl(url)
            }
        }
    }
}
