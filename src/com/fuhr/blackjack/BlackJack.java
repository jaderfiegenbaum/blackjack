package com.fuhr.blackjack;

import com.fuhr.classes.BlackjackGame;
import com.fuhr.classes.Carta;
import com.fuhr.classes.Jogador;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BlackJack extends Activity implements OnClickListener{
	private BlackjackGame jogo = new BlackjackGame();
	
	private EditText dica = null;
	private EditText dinheiro = null;
	
	private Button btnPedirCarta = null;
	private Button btnFicar = null;
	private Button bt10p = null;
	private Button bt50p = null;
	private Button bt100p = null;
	
	
	private TextView totalHumano = null;
	private TextView totalCpu = null;
	
	private TextView nomeHumano = null;
	private TextView nomeCpu = null;
	
	private ImageView imgCartaHumano = null;
	private ImageView imgCartaCpu = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);
        
        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        String nomeJogador = params.getString("nome");
        jogo.getHumano().setNome(nomeJogador);
        
        dica = (EditText) findViewById(R.id.edHint);
        dica.setText("PARA INICIAR O JOGO, CLIQUE EM 'PEDIR CARTA'");
        
        dinheiro = (EditText) findViewById(R.id.edDinheiro);
        atualizaDinheiro();
        
        btnPedirCarta = (Button) findViewById(R.id.btnPedirCarta);
        btnPedirCarta.setOnClickListener(this);
        
        btnFicar = (Button) findViewById(R.id.btnFicar);
        btnFicar.setOnClickListener(this);
        
        bt10p = (Button) findViewById(R.id.bt10p);
        bt10p.setOnClickListener(this);
        
        bt50p = (Button) findViewById(R.id.bt50p);
        bt50p.setOnClickListener(this);
        
        bt100p = (Button) findViewById(R.id.bt100p);
        bt100p.setOnClickListener(this);
        
        totalHumano = (TextView) findViewById(R.id.totalHumano);
        totalCpu = (TextView) findViewById(R.id.totalCpu);
        
        nomeHumano = (TextView) findViewById(R.id.textView1);
        nomeHumano.setText(nomeJogador);
        nomeCpu = (TextView) findViewById(R.id.textView2);
        
        imgCartaHumano = (ImageView) findViewById(R.id.imgCartaHumano);
        imgCartaCpu = (ImageView) findViewById(R.id.imgCartaCpu);
        
        limparParaEscolherValor(false);
    }
    
    private void jogadaHumana()
    {
    	dica.setText("");
    	
    	if ( !jogo.isTerminou() )
    	{
	    	Carta carta = jogo.humanoJogar();
	    	imgCartaHumano.setImageResource(carta.getImage());
	    	
	    	atualizaTotais();
    	}
    	
    	jogadaCpu();
    }
    
    private void jogadaCpu()
    {
    	if( !jogo.isTerminou() )
    	{
    		Jogador cpu = jogo.getCpu();
    		Jogador humano = jogo.getHumano();
    		if ( cpu.getPontos() < 16 && humano.getPontos() > cpu.getPontos() && humano.getPontos() <= 21 )
    		{    			
	    		Carta carta = jogo.cpuJogar();
		    	imgCartaCpu.setImageResource(carta.getImage());
		    	
		    	atualizaTotais();
    		}
    		else if ( humano.getPontos() > cpu.getPontos() && humano.getPontos() <= 21 )
    		{
    			Carta carta = jogo.cpuJogar();
		    	imgCartaCpu.setImageResource(carta.getImage());
		    	
		    	atualizaTotais();
    		}    			    	
    	}
    }
    
    private void atualizaTotais()
    {
    	Jogador humano = jogo.getHumano();
    	Jogador cpu = jogo.getCpu();
    	
    	totalHumano.setText(String.valueOf(humano.getPontos()));
    	totalCpu.setText(String.valueOf(cpu.getPontos()));
    	
    	if ( jogo.isTerminou() )
    	{
    		Jogador vencedor = jogo.obterVencedor();
    		if ( vencedor == null )
    		{
    			dica.setText("O JOGO TERMINOU EMPATADO." +
	    				"\n CLIQUE EM 'JOGAR NOVAMENTE' PARA REINICIAR.");
	    		btnPedirCarta.setText("JOGAR NOVAMENTE");
	    		btnFicar.setVisibility(View.INVISIBLE);
    		}
    		else
    		{
    			int valorCpu = jogo.getCpu().getDinheiro();
    			int valorHumano = jogo.getHumano().getDinheiro();
    			
    			// Atualizar valores.
    			if ( vencedor.getNome() == "Android" )
    			{
    				jogo.getCpu().setDinheiro(valorCpu+jogo.getValorApostado());
    				jogo.getHumano().setDinheiro(valorHumano-jogo.getValorApostado());
    			}
    			else
    			{
    				jogo.getCpu().setDinheiro(valorCpu-jogo.getValorApostado());
    				jogo.getHumano().setDinheiro(valorHumano+jogo.getValorApostado());
    			}
    			
    			// Atualiza dinheiro.
    			atualizaDinheiro();
    			
	    		dica.setText("O GRANDE VENCEDOR É: " + vencedor.getNome() +
	    				"\n CLIQUE EM 'JOGAR NOVAMENTE' PARA REINICIAR.");
	    		btnPedirCarta.setText("JOGAR NOVAMENTE");
	    		btnFicar.setVisibility(View.INVISIBLE);
    		}
    	}
    	
    }
    
    private void recomecar(boolean apostarNovamente)
    {
    	if ( apostarNovamente )
    	{
    		limparParaEscolherValor(true);
    	}
    	else
    	{
	    	//jogo = new BlackjackGame();
	    	jogo.setTerminou(false);
	    	jogo.getHumano().setPerdeu(false);
	    	jogo.getHumano().setPontos(0);
	    	jogo.getCpu().setPerdeu(false);
	    	jogo.getCpu().setPontos(0);
	    	jogo.reiniciarBaralho();
	    	
	    	
	    	dica.setText("PARA INICIAR O JOGO, CLIQUE EM 'PEDIR CARTA'");
	    	
	    	btnPedirCarta.setText("PEDIR CARTA");
	    	btnFicar.setVisibility(View.VISIBLE);
	    	
	    	imgCartaHumano.setImageResource(R.drawable.blank);
	    	imgCartaCpu.setImageResource(R.drawable.blank);
	    	
	    	atualizaTotais();
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_black_jack, menu);
        return true;
    }
    
	public void onClick(View v)
	{ 
		switch (v.getId())
		{
			case R.id.btnPedirCarta:
					if ( jogo.isTerminou() )
					{
						recomecar(true);
					}
					else
					{
						jogadaHumana();
					}
				break;
				
			case R.id.btnFicar:	
				jogadaCpu();
				jogo.setTerminou(true);
				atualizaTotais();
			break;
			
			case R.id.bt10p:
				apostar(10);
				break;
				
			case R.id.bt50p:
				apostar(50);
				break;
			
			case R.id.bt100p:
				apostar(100);
				break;
			default:
				break;
		}
	}
	
	private void limparParaEscolherValor(boolean apostarNovamente)
	{
		dica.setText("DETERMINE O VALOR DA APOSTA'");
		
		bt10p.setVisibility(View.VISIBLE);
		bt50p.setVisibility(View.VISIBLE);
		bt100p.setVisibility(View.VISIBLE);
		
		btnPedirCarta.setVisibility(View.INVISIBLE);
        btnFicar.setVisibility(View.INVISIBLE);
        totalHumano.setVisibility(View.INVISIBLE);
        totalCpu.setVisibility(View.INVISIBLE);
        imgCartaHumano.setVisibility(View.INVISIBLE);
        imgCartaCpu.setVisibility(View.INVISIBLE);
        nomeHumano.setVisibility(View.INVISIBLE);
        nomeCpu.setVisibility(View.INVISIBLE);
        
        if ( apostarNovamente )
        {
        	recomecar(false);
        }
	}
	
	private void mostrarParaJogar()
	{
		bt10p.setVisibility(View.INVISIBLE);
		bt50p.setVisibility(View.INVISIBLE);
		bt100p.setVisibility(View.INVISIBLE);
		btnPedirCarta.setVisibility(View.VISIBLE);
        btnFicar.setVisibility(View.VISIBLE);
        totalHumano.setVisibility(View.VISIBLE);
        totalCpu.setVisibility(View.VISIBLE);
        imgCartaHumano.setVisibility(View.VISIBLE);
        imgCartaCpu.setVisibility(View.VISIBLE);
        nomeHumano.setVisibility(View.VISIBLE);
        nomeCpu.setVisibility(View.VISIBLE);
	}
	
	private void apostar(int valor)
	{
		jogo.setValorApostado(valor);
		dica.setText("Valor apostado: R$" + valor + ",00");
		mostrarParaJogar();
	}
	
	private void atualizaDinheiro()
	{
		String textoDinheiro = jogo.getHumano().getNome() + ": R$ " + jogo.getHumano().getDinheiro() + ",00"
	              +"\nAndroid: R$ " + jogo.getCpu().getDinheiro() + ",00";
		dinheiro.setText(textoDinheiro);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.itemSair:
			Intent intent2 = new Intent(this, Ranking.class);
			
			Bundle params = new Bundle();
			params.putString("nome", jogo.getHumano().getNome());
			params.putInt("pontuacao", jogo.getHumano().getDinheiro());
			intent2.putExtras(params);
			
			this.startActivity(intent2);
			break;
		}
 
		return true;
	}
}
