package nnk.com.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class bloostock extends AppCompatActivity {

    Toolbar toolbar;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloostock);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        wv = (WebView)findViewById(R.id.wb1);
        wv.loadUrl("http://www.eraktkosh.in");
        WebViewClient wvc=new WebViewClient();
        wv.setWebViewClient(wvc);

        WebSettings ws=wv.getSettings();
        ws.getJavaScriptEnabled();
        ws.setBuiltInZoomControls(true);
    }
}
