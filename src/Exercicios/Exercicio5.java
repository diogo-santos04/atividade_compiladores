package Exercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercicio5 extends BaseExercicio {
    @Override
    public void executar(){
        String texto = "Maria tem 23 anos e comprou 5 livros por 120 reais";

        String regex = "\\d+{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("A string analisada é: " + texto);
        System.out.println("Números encontrados no texto:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        } 
    }
}
