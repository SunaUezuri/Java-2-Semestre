import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //Criar os objetos de alunos
        String criar = JOptionPane.showInputDialog("Gostaria de cadastrar um novo aluno?(S/N)");

        while (criar.equalsIgnoreCase("S")){
            String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
        }
    }
}
