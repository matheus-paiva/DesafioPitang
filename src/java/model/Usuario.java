package model;

import java.util.ArrayList;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Telefone> listaTel = new ArrayList<>() ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public ArrayList<Telefone> getListaTel() {
        return listaTel;
    }

    public void setListaTel(ArrayList<Telefone> listaTel) {
        this.listaTel = listaTel;
    }
    
    
}
