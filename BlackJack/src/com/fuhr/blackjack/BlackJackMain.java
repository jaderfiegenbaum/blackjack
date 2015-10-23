package com.fuhr.blackjack;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BlackJackMain extends Activity implements OnClickListener {

	private Button btNovoJogo = null;
	private Button btRanking = null;
	private Button btSair = null;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack_main);
        
       // Instância componentes da tela.
        btNovoJogo = (Button) findViewById(R.id.btNovoJogo);
        btNovoJogo.setOnClickListener(this);
        
        btRanking = (Button) findViewById(R.id.btRanking);
        btRanking.setOnClickListener(this);
        
        btSair = (Button) findViewById(R.id.btSair);
        btSair.setOnClickListener(this);
    }
    

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_black_jack_main, menu);
        return true;
    }*/


	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.btNovoJogo:
				Intent intent = new Intent(this, NovoJogo.class);
				this.startActivity(intent);
				break;
			
			case R.id.btSair:
				finish();
				break;
				
			case R.id.btRanking:
				Intent intent2 = new Intent(this, Ranking.class);
				this.startActivity(intent2);
				break;
				
		    default:
		    	break;
		}
	}

   
}
