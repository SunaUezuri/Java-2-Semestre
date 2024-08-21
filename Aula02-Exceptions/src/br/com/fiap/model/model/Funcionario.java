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

    public double calculaFerias(int dias) throws Exception{
        //Validar os dias
        if (dias < 1 || dias > 30){
            throw new Exception("Tá pedindo demais meu consagrado...");
        }

        return (salario + salario / 3) * dias / 30;
    }

    public double calculaPLD(boolean metaObtida, int meses) throws Exception{

        //Validar os meses entre 1 e 12
        if (meses < 1 || meses > 12){
            throw new Exception("Quantidade de meses inválido!");
        }

        if (metaObtida){
            return salario * 5 * meses/12;
        }
        return 0;

    }
}
