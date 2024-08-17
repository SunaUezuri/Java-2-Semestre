package br.com.fiap.model;

public class Funcionario {

    private String nome;
    protected double salario;

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nSalário: " + salario;
    }

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double calculaFerias(){
        return salario += salario / 3;
    }

    public double calculaPLD(double metaObtida){
        if (metaObtida == 25.0){
            
        }
    }
}
