package com.example.howcruds;

public class jogador {

    private String jogaNome;
    private String favClasse;

    public String getJogaNome() {
        return jogaNome;
    }

    public void setJogaNome(String jogaNome) {
        this.jogaNome = jogaNome;
    }

    public String getFavClasse() {
        return favClasse;
    }
    public void setFavClasse(String favClasse) {
        this.favClasse = favClasse;
    }


    public jogador(String jogaNome, String favClasse) {
        this.jogaNome = jogaNome;
        this.favClasse = favClasse;

    }
}