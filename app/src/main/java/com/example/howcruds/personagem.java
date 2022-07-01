package com.example.howcruds;

public class personagem {

    private String charNome;
    private String charClasse;
    private String charRaca;

    public String getCharNome() {
        return charNome;
    }

    public void setCharNome(String charNome) {
        this.charNome = charNome;
    }


    public String getCharClasse() {
        return charClasse;
    }

    public void setCharClasse(String charClasse) {
        this.charClasse = charClasse;
    }

    public String getCharRaca() {
        return charRaca;
    }

    public void setCharRaca(String charRaca) {
        this.charRaca = charRaca;
    }



    public personagem(String charNome, String charClasse, String charRaca) {
        this.charNome = charNome;
        this.charClasse = charClasse;
        this.charRaca = charRaca;


    }
}
