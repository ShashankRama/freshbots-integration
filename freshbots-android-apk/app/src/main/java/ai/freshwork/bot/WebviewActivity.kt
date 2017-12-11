package ai.freshwork.bot

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebSettings
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }

        webView.settings.setLoadWithOverviewMode(true);
        webView.settings.setUseWideViewPort(true);
        webView.settings.setJavaScriptEnabled(true);

        webView.settings.setAppCacheEnabled(true)
        webView.settings.setCacheMode(WebSettings.LOAD_NO_CACHE)
        webView.settings.databaseEnabled = true
        webView.settings.domStorageEnabled = true
        //webView.loadUrl("https://www.intfreshbots.com/chat?clientHash=715f2d3ca34bb04e722521b7ed981acced86f728&botHash=d30f6d750d71d039137b91558f92e8e721865142#open")
        webView.loadUrl("file:///android_asset/bot.html" +
                "?sessionId=ses123&userId=usr123&name=TestName&txnId=txn123")
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val  intent = Intent(context, WebviewActivity::class.java)
            return intent
        }
    }

}
