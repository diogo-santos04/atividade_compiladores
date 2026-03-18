package Exercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercicio3 extends BaseExercicio {
    @Override
    public void executar(){
        String texto = "10/10/2020";
        String regex = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        System.out.println("A string analisada é: " + texto);
        if (matcher.matches()) {
            System.out.println("A string esta em formato de data");
        } else {
            System.out.println("A string não esta em formato de data");
        }
    }
}
