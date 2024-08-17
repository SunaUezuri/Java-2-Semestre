import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        try {
            //Ler um número
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Insira um número: "));
            System.out.println(numero);

            //Ler outro número
           int numerico = Integer.parseInt(JOptionPane.showInputDialog("Insira outro número: "));
            System.out.println(numerico);

            //Dividir um número pelo outro
            int divisao = numero / numerico;

            System.out.println("O resultado é: " + divisao);
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("Parceiro, não dá pra dividir com isso ae não...");
        } catch (Exception e){
            System.out.println("Tratando todos os erros");
        } finally {
            System.out.println("Finalizando programa");

        }




    }
}
