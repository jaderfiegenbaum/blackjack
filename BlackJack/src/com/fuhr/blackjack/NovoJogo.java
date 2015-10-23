package com.fuhr.blackjack;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NovoJogo extends Activity implements OnClickListener{

	private EditText edNome = null;
	private Button btContinuar = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_jogo);
        
        // Instância componentes.
        btContinuar = (Button) findViewById(R.id.btContinuar);
        btContinuar.setOnClickListener(this);
        
        edNome = (EditText) findViewById(R.id.edNome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_novo_jogo, menu);
        return true;
    }

	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.btContinuar:
				Intent intent = new Intent(this, BlackJack.class);
				Bundle params = new Bundle();
				String nome = edNome.getText().toString();
				params.putString("nome", nome);
				intent.putExtras(params);
				this.startActivity(intent);
		}
		
	}
}
