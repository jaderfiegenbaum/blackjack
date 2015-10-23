package com.fuhr.classes;

import com.fuhr.blackjack.R;

import android.widget.ImageView;

public class Carta {
	
	public final static String copas = "Copas";
	public final static String ouro = "Ouro";
	public final static String espadas = "Espadas";
	public final static String paus = "Paus";
	
	private String naipe;
	private int numero;
	private int img;
	
	public Carta(int numero, String naipe)
	{
		if ( numero > 1 && numero <= 14 )
		{
			this.numero = numero;
			this.naipe = naipe;			

			if ( naipe.equals(Carta.copas) )
			{
				switch(numero)
				{
					case 2 :
						img = R.drawable.copas2;
						break;
					case 3 :
						img = R.drawable.copas3;
						break;
					case 4 :
						img = R.drawable.copas4;
						break;
					case 5 :
						img = R.drawable.copas5;
						break;
					case 6 :
						img = R.drawable.copas6;
						break;
					case 7 :
						img = R.drawable.copas7;
						break;
					case 8 :
						img = R.drawable.copas8;
						break;
					case 9 :
						img = R.drawable.copas9;
						break;
					case 10 :
						img = R.drawable.copas10;
						break;
					case 11 :
						img = R.drawable.copas11;
						break;
					case 12 :
						img = R.drawable.copas12;
						break;
					case 13 :
						img = R.drawable.copas13;
						break;
					case 14 :
						img = R.drawable.copas14;
						break;
					default :
						img = R.drawable.blank;
						break;
				}
			}
			
			if ( naipe.equals(Carta.ouro) )
			{
				switch(numero)
				{
					case 2 :
						img = R.drawable.ouro2;
						break;
					case 3 :
						img = R.drawable.ouro3;
						break;
					case 4 :
						img = R.drawable.ouro4;
						break;
					case 5 :
						img = R.drawable.ouro5;
						break;
					case 6 :
						img = R.drawable.ouro6;
						break;
					case 7 :
						img = R.drawable.ouro7;
						break;
					case 8 :
						img = R.drawable.ouro8;
						break;
					case 9 :
						img = R.drawable.ouro9;
						break;
					case 10 :
						img = R.drawable.ouro10;
						break;
					case 11 :
						img = R.drawable.copas11;
						break;
					case 12 :
						img = R.drawable.ouro12;
						break;
					case 13 :
						img = R.drawable.ouro13;
						break;
					case 14 :
						img = R.drawable.ouro14;
						break;
					default :
						img = R.drawable.blank;
						break;
				}
			}
			
			if ( naipe.equals(Carta.espadas) )
			{
				switch(numero)
				{
					case 2 :
						img = R.drawable.espadas2;
						break;
					case 3 :
						img = R.drawable.espadas3;
						break;
					case 4 :
						img = R.drawable.espadas4;
						break;
					case 5 :
						img = R.drawable.espadas5;
						break;
					case 6 :
						img = R.drawable.espadas6;
						break;
					case 7 :
						img = R.drawable.espadas7;
						break;
					case 8 :
						img = R.drawable.espadas8;
						break;
					case 9 :
						img = R.drawable.espadas9;
						break;
					case 10 :
						img = R.drawable.espadas10;
						break;
					case 11 :
						img = R.drawable.espadas11;
						break;
					case 12 :
						img = R.drawable.espadas12;
						break;
					case 13 :
						img = R.drawable.espadas13;
						break;
					case 14 :
						img = R.drawable.espadas14;
						break;
					default :
						img = R.drawable.blank;
						break;
				}
			}
			
			if ( naipe.equals(Carta.paus) )
			{
				switch(numero)
				{
					case 2 :
						img = R.drawable.paus2;
						break;
					case 3 :
						img = R.drawable.paus3;
						break;
					case 4 :
						img = R.drawable.paus4;
						break;
					case 5 :
						img = R.drawable.paus5;
						break;
					case 6 :
						img = R.drawable.paus6;
						break;
					case 7 :
						img = R.drawable.paus7;
						break;
					case 8 :
						img = R.drawable.paus8;
						break;
					case 9 :
						img = R.drawable.paus9;
						break;
					case 10 :
						img = R.drawable.paus10;
						break;
					case 11 :
						img = R.drawable.paus11;
						break;
					case 12 :
						img = R.drawable.paus12;
						break;
					case 13 :
						img = R.drawable.paus13;
						break;
					case 14 :
						img = R.drawable.paus14;
						break;
					default :
						img = R.drawable.blank;
						break;
				}
			}
		}
	}
	
	public int getImage()
	{
		return img;
	}
	
	public String getNaipe()
	{
		return naipe;
	}
	
	public int getNumero()
	{
		return numero;
	}
	
	public void setNaipe(String naipe)
	{
		this.naipe = naipe;
	}
	
	public void setNumero(int numero)
	{
		this.numero = numero;
	}

}
