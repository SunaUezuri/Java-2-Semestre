public class Aluno {

    private String rm;
    private String nome;
    private int idade;
    private double nota;

    @Override
    public String toString() {
        return  "RM: " + rm +
                "Aluno: " + nome +
                "Idade: " + idade +
                "Nota: " + nota;

    }

    public Aluno(String rm, String nome, int idade, double nota) {
        this.rm = rm;
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
