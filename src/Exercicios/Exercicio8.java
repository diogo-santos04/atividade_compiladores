package Exercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercicio8 extends BaseExercicio {
    @Override
    public void executar() {
        String texto = "Cliente: João Silva\nCelular: (67) 99876-1234";

        String regex = "(\\([0-9]{2}\\)) (9)([0-9]{4})(\\-[0-9]{4})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        String resultado = matcher.replaceAll("$1 $2****$4");
        
        System.out.println("Texto original:\n");
        System.out.println(texto);

        System.out.println("\nTexto mascarado:\n");
        System.out.println(resultado);
    }
}
