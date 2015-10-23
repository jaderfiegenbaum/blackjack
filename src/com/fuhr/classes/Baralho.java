package com.fuhr.classes;

import java.util.ArrayList;

public class Baralho 
{
	
	private ArrayList<Carta> cartas = new ArrayList<Carta>();
	
	public Baralho()
	{
            for(int i = 2; i < 14; i++)
            {
                    Carta copas = new Carta(i, Carta.copas);
                    Carta ouro = new Carta(i, Carta.ouro);
                    Carta espadas = new Carta(i, Carta.espadas);
                    Carta paus = new Carta(i, Carta.paus);

                    cartas.add(copas);
                    cartas.add(ouro);
                    cartas.add(espadas);
                    cartas.add(paus);
            }
	}
	
	public Carta obterCarta()
	{
		Carta carta = null;
		
		while (carta == null && cartas.size() > 0 )
		{
			try
			{
		        int random = (int) (Math.random() * cartas.size() + 1);
		
		        carta = cartas.get(random);
		        cartas.remove(random);
			}
			catch (Exception e){}
		}

        return carta;
	}
	
}
