package com.fuhr.blackjack;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.webkit.WebView;

public class Ranking extends Activity {

	private WebView webView = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        
        String url = "http://anthraxxx.no-ip.biz:8081/black2/jblack.php";
        
        try
        {
	        Intent intent = getIntent();
	        Bundle params = intent.getExtras();
	        String nomeJogador = params.getString("nome");
	        int pontos = params.getInt("pontuacao");
	
	        if ( nomeJogador.length() > 0 )
	        {
	    		url +="?nome=" + nomeJogador + "&pontuacao=" + Integer.toString(pontos);
	        }
        }
        catch (Exception e)
        {
        }
        
        webView = (WebView) findViewById(R.id.webView);
	    webView.loadUrl(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ranking, menu);
        return true;
    }
}
