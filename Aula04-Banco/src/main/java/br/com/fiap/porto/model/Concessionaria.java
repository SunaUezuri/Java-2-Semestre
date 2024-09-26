package br.com.fiap.porto.model;

public class Concessionaria {

    private int id;
    private String nome;
    private String cnpj;
    private int armazenamento;

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nCNPJ: " + cnpj +
                "\nArmazenamento: " + armazenamento;
    }

    public Concessionaria(String nome, String cnpj, int armazenamento) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.armazenamento = armazenamento;
    }

    public Concessionaria(int id, String nome, String cnpj, int armazenamento) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.armazenamento = armazenamento;
    }

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }
}
