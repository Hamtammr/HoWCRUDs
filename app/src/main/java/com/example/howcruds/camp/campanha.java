package com.example.howcruds.camp;

public class campanha {

    private String campNome;
    private String sistema;

    public String getCampNome() {
        return campNome;
    }

    public void setCampNome(String campNome) {
        this.campNome = campNome;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }



    // constructor
    public campanha(String campNome, String sistema) {
        this.campNome = campNome;
        this.sistema = sistema;

    }
}
