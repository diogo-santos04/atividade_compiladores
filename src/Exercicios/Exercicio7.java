package Exercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercicio7 extends BaseExercicio {
    @Override
    public void executar(){
         String texto = "Cliente: João Silva\nCPF: 123.432.343-23";

        // Expressão regular para CPF
        String regex = "(\\d{3})\\.(\\d{3})\\.(\\d{3})-(\\d{2})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        String resultado = matcher.replaceAll("***.***.***-$4");

        System.out.println("Texto original:\n");
        System.out.println(texto);

        System.out.println("\nTexto mascarado:\n");
        System.out.println(resultado);

    }
}
