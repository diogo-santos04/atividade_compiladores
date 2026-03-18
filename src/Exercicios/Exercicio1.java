package Exercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercicio1 extends BaseExercicio {
    @Override
    public void executar() {
        String texto = "12a345";

        // Expressão regular: apenas números
        String regex = "^[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("A string analisada é: " + texto);
        if (matcher.matches()) {
            System.out.println("A string contém apenas números.");
        } else {
            System.out.println("A string contém outros caracteres.");
        }
    }
}
