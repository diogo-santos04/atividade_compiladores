package Exercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercicio6 extends BaseExercicio {
    @Override
    public void executar() {
        String texto = "10/10/2020";

        String regex = "(\\d{2})/(\\d{2})/(\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("A string analisada é: " + texto);
        System.out.println("Números encontrados no texto:");
        while (matcher.find()) {
            System.out.println("Dia: " + matcher.group(1));
            System.out.println("Mês: " + matcher.group(2));
            System.out.println("Ano: " + matcher.group(3));
        }
    }
}
