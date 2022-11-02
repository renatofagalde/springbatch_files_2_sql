package br.com.likwi.springbatchfiles2sql.batch.dominio;

public class DadosBancarios {
    private int id;
    private int pessoaId;
    private int agencia;
    private int conta;
    private int banco;

    public DadosBancarios(int id, int pessoaId, int agencia, int conta, int banco) {
        this.id = id;
        this.pessoaId = pessoaId;
        this.agencia = agencia;
        this.conta = conta;
        this.banco = banco;
    }

    public int getId() {
        return id;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public int getBanco() {
        return banco;
    }
}
