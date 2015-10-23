package com.fuhr.classes;

public class Jogador {

    private String nome;
    private int dinheiro;
    private boolean auto;
    private int pontos = 0;
    private boolean perdeu = false;

    public Jogador(String nome, int dinheiroInicial, boolean auto)
    {
        this.nome = nome;
        this.dinheiro = dinheiroInicial;
        this.auto = auto;
    }
    
    public Carta jogar(Baralho baralho)
    {
    	Carta carta = baralho.obterCarta();
    	
    	pontos += carta.getNumero();
        if ( pontos > 21 )
        {
            perdeu = true;
        }
        
        return carta;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean isPerdeu() {
        return perdeu;
    }

    public void setPerdeu(boolean perdeu) {
        this.perdeu = perdeu;
    }        
    
}
