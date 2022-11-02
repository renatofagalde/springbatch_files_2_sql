package br.com.likwi.springbatch.migracao;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;

public class GeracaoMassaTest {

    Faker faker = new Faker();
    @Test
    public void gerarBaseArquivo() throws Exception{
        BufferedWriter writer= new BufferedWriter(new FileWriter("pessoas1000.csv",true));
        for(int i=0;i<=10000000;i++){
            Pessoa pessoa = new Pessoa(i, faker.name().firstName(), faker.internet().emailAddress().concat("_").concat(i + ""),
                    new Date(), (int) ((Math.random() * (99 - 18)) + 10));
            writer.append(pessoa.delimitado());
        }

        writer.close();
    }
}

class Pessoa {
    private int id;
    private String nome;
    private String email;
    private Date dataNascimento;
    private int idade;

    public Pessoa(int id, String nome, String email, Date dataNascimento, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public String delimitado(){
        String s = ",";
        return nome
                .concat(s)
                .concat(email)
                .concat(s)
                .concat("2013-04-14 17:31:54,47")
                .concat(s)
                .concat(id+"\n");
    }
}

