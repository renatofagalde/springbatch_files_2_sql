package br.com.likwi.springbatchfiles2sql.batch.dominio;

import java.util.Date;

public class Pessoa {
    private int id;
    private String nome;
    private String email;
    private Date nascimento;
    private int idade;

    public Pessoa(int id, String nome, String email, Date nascimento, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public int getIdade() {
        return idade;
    }
}
