import java.util.Scanner;
import java.util.Locale;

public class CalculoIMC {
    public static void main(String[] args) {
        Scanner lerTeclado = new Scanner(System.in);
        lerTeclado.useLocale(Locale.US); // força uso do ponto como separador decimal

        System.out.print("Digite seu nome: ");
        String nome = lerTeclado.nextLine();

        System.out.print("Digite seu gênero (M/F/N): ");
        char genero = Character.toUpperCase(lerTeclado.next().charAt(0));

        System.out.print("Digite sua altura (em metros, ex: 1.75): ");
        double altura = lerTeclado.nextDouble();

        System.out.print("Digite seu peso (em kg): ");
        double peso = lerTeclado.nextDouble();

        double imc = peso / (altura * altura);

        // Se for "N", usar a tabela Feminino
        if (genero == 'N') {
            genero = 'F';
        }

        String classificacao = "";

        if (genero == 'M') {
            if (imc >= 40) classificacao = "Obesidade Mórbida";
            else if (imc >= 30) classificacao = "Obesidade Moderada";
            else if (imc >= 25) classificacao = "Obesidade Leve";
            else if (imc >= 20) classificacao = "Normal";
            else classificacao = "Abaixo do Normal";
        } else { // Feminino
            if (imc >= 39) classificacao = "Obesidade Mórbida";
            else if (imc >= 29) classificacao = "Obesidade Moderada";
            else if (imc >= 24) classificacao = "Obesidade Leve";
            else if (imc >= 19) classificacao = "Normal";
            else classificacao = "Abaixo do Normal";
        }

        System.out.println("\n--- Resultado ---");
        System.out.println("Nome: " + nome);
        System.out.println("Gênero: " + (genero == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("IMC: %.2f\n", imc);
        System.out.println("Classificação: " + classificacao);

        lerTeclado.close();
    }
}
