package Exercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercicio2 extends BaseExercicio {
    @Override
    public void executar(){
        String texto = "123.32";
        String regex = "^[0-9]+\\.[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("A string analisada é: " + texto);
        if (matcher.matches()) {
            System.out.println("A string é um decimal");
        } else {
            System.out.println("A string não é um decimal");
        }
    }
}
