package com.example.howcruds;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDHow extends SQLiteOpenHelper {

    private static final String NOME_BD = "howdb.db";
    private static final int VERS_BD = 1;

    // ------------TABELAS-------------

    //TABELA CHAR - Constantes
    private static final String TABELA_CHAR = "personagens";
    private static final String ID_CHAR = "idPersonagens";
    private static final String NOME_CHAR = "NomePersonagem";
    private static final String CLASSE_CHAR = "Classe";
    private static final String RACA_CHAR = "Raca";


    //TABELA JOGADOR - Constantes
    private static final String TABELA_JOGA = "jogadores";
    private static final String ID_JOGA = "idJogador";
    private static final String NOME_JOGA = "nomeJogador";
    private static final String FAV_CLASSE = "classeFavorita";

    //TABELA CAMPANHA - Constantes
    private static final String TABELA_CAMP = "campanhas";
    private static final String ID_CAMP = "idCampanha";
    private static final String NOME_CAMP = "nomeCampanha";
    private static final String SISTEMA = "sistema";

    public BDHow(Context context) {
        super(context, NOME_BD, null, VERS_BD);

    }


    //Sequencia para criar as tabelas ao iniciar o banco de dados.

    @Override
    public void onCreate(SQLiteDatabase db) {

        String criarTabelaChar = "CREATE TABLE " + TABELA_CHAR + " ("
                + ID_CHAR + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOME_CHAR + " TEXT,"
                + CLASSE_CHAR + " TEXT,"
                + RACA_CHAR + " TEXT)";

        String criarTabelaJoga = "CREATE TABLE " + TABELA_JOGA+ " ("
                + ID_JOGA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOME_JOGA + " TEXT,"
                + FAV_CLASSE + " TEXT)";

        String criarTabelaCamp = "CREATE TABLE " + TABELA_CAMP + " ("
                + ID_CAMP + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOME_CAMP + " TEXT,"
                + SISTEMA + " TEXT)";

        db.execSQL(criarTabelaChar);
        db.execSQL(criarTabelaJoga);
        db.execSQL(criarTabelaCamp);
    }

    //--------------Comandos de [C]RUD--------------------------------

    public void inserirPersonagem(String  nomeChar, String classeChar, String racaChar){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NOME_CHAR, nomeChar);
        values.put(CLASSE_CHAR, classeChar);
        values.put(RACA_CHAR, racaChar);

        db.insert(TABELA_CHAR,null, values);
        db.close();


    }

    public void inserirJogador(String nomeJoga, String favClasse){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NOME_JOGA, nomeJoga);
        values.put(FAV_CLASSE, favClasse);

        db.insert(TABELA_JOGA,null, values);
        db.close();
    }

    public void inserirCampanha(String nomeCamp, String sistema){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NOME_CAMP, nomeCamp);
        values.put(SISTEMA, sistema);

        db.insert(TABELA_CAMP,null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVers, int newVers) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CHAR);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_JOGA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CAMP);

        onCreate(db);
    }
    //-----------------------------------------------------------------------------

    //-----------------Metodo para ler os registros-----------------------------


    //Ler registros dos personagens
    public ArrayList<personagem> mostrarPersonagens() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor personagens = db.rawQuery("SELECT * FROM " + TABELA_CHAR, null);
        ArrayList<personagem> personagemArrayList = new ArrayList<>();

        if (personagens.moveToFirst()) {
            do {
                personagemArrayList.add(new personagem(personagens.getString(1),
                        personagens.getString(2),
                        personagens.getString(3)));
            } while (personagens.moveToNext());
        }
        personagens.close();
        return personagemArrayList;
    }

    //Ler registros dos jogadores
    public ArrayList<jogador> mostrarJogador() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor jogadores = db.rawQuery("SELECT * FROM " + TABELA_JOGA, null);
        ArrayList<jogador> jogadorArrayList = new ArrayList<>();

        if (jogadores.moveToFirst()) {
            do {
                jogadorArrayList.add(new jogador(jogadores.getString(1),
                        jogadores.getString(2)));
            } while (jogadores.moveToNext());
        }
        jogadores.close();
        return jogadorArrayList;
    }

    //Ler registros das campanhas
    public ArrayList<campanha> mostrarCampanha() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor campanhas = db.rawQuery("SELECT * FROM " + TABELA_CAMP, null);
        ArrayList<campanha> campanhaArrayList = new ArrayList<>();

        if (campanhas.moveToFirst()) {
            do {
                campanhaArrayList.add(new campanha(campanhas.getString(1),
                        campanhas.getString(2)));
            } while (campanhas.moveToNext());
        }
        campanhas.close();
        return campanhaArrayList;
    }


    //----------------------------------------------------------------------------------------------


    //Editar registros


    //Editar registros de Personagens
    public void updatePersonagem(String originalPersonagem, String nomeChar, String classeChar,
                             String racaChar) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NOME_CHAR, nomeChar);
        values.put(CLASSE_CHAR, classeChar);
        values.put(RACA_CHAR, racaChar);

        db.update(TABELA_CHAR, values, "NomePersonagem=?", new String[]{originalPersonagem});
        db.close();
    }

    //Editar registros de Jogador
    public void updateJogador(String originalJogador, String nomeJogador, String classeJogador) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NOME_JOGA, nomeJogador);
        values.put(FAV_CLASSE, classeJogador);

        db.update(TABELA_JOGA, values, "nomeJogador=?", new String[]{originalJogador});
        db.close();
    }

    //Editar registros de Campanha
    public void updateCampanha(String originalCampanha, String nomeCamp, String sistemaCamp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NOME_CAMP, nomeCamp);
        values.put(SISTEMA, sistemaCamp);

        db.update(TABELA_CAMP, values, "nomeCampanha=?", new String[]{originalCampanha});
        db.close();
    }

}
