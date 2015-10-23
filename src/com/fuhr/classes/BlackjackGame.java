package com.fuhr.classes;

public class BlackjackGame 
{
	
	private Baralho baralho;
	
	private Jogador humano;
	
	private Jogador cpu;
	
	private boolean terminou = false;
	
	private int valorApostado = 0;
	
	public BlackjackGame()
	{
		baralho = new Baralho();
		
		humano = new Jogador("Eu", 1000, false);
		cpu = new Jogador("Android", 999999999, true);
	}
	
	public Carta humanoJogar()
	{
		Carta carta = humano.jogar(baralho);
		
		if ( humano.isPerdeu() )
		{
			terminou = true;
		}
		
		return carta;
	}
	
	public Carta cpuJogar()
	{
		Carta carta = cpu.jogar(baralho);
		
		if ( cpu.isPerdeu() )
		{
			terminou = true;
		}
		
		return carta;
	}
	
	public boolean isTerminou()
	{
		return terminou;
	}
	
	public void setTerminou(boolean terminou)
	{
		this.terminou = terminou;
	}
	
	public Jogador getHumano()
	{
		return humano;
	}
	
	public Jogador getCpu()
	{
		return cpu;
	}
	
	public Jogador obterVencedor()
	{
		if ( humano.getPontos() == cpu.getPontos() )
		{
			return null;
		}
		else if ( humano.getPontos() > cpu.getPontos() )
		{
			if ( humano.getPontos() <= 21 )
			{
				return humano;
			}
			else
			{
				return cpu;
			}
		}
		else
		{
			if ( cpu.getPontos() <= 21 )
			{
				return cpu;
			}
			else
			{
				return humano;
			}
		}
	}
	
	public int getValorApostado()
	{
		return valorApostado;
	}
	
	public int setValorApostado(int valor)
	{
		return this.valorApostado = valor;
	}
	
	public Baralho getBaralho()
	{
		return baralho;
	}
	
	public void setBaralho(Baralho baralho)
	{
		this.baralho = baralho;
	}
	
	public void reiniciarBaralho()
	{
		this.baralho = new Baralho();
	}

}
