package Exercicios;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercicio9 extends BaseExercicio {
    @Override
    public void executar() {
        String codigo = "float valor = num1 + (num2 * 10);";
        System.out.println("A string analisada é: " + codigo);

        Map<String, String> token = new LinkedHashMap<>();
        
        // \b garante que a busca seja pela palavra exata
        token.put("RESERVADA", "\\b(int|float|if|else|while)\\b");
        
        // \d+ busca por um ou mais dígitos
        token.put("NUMERO", "\\d+");
        
        // [a-zA-Z_] começa com letra/underline, [a-zA-Z0-9_]* continua com letras/números
        token.put("IDENTIFICADOR", "[a-zA-Z_][a-zA-Z0-9_]*");
        
        // Busca pelos caracteres matemáticos e de atribuição
        token.put("OPERADOR", "[+\\-*/=]");
        
        // Busca pelos caracteres de pontuação e controle
        token.put("DELIMITADOR", "[;()]");

        // Construção dinâmica do regex
        StringBuilder regexBuilder = new StringBuilder();
        for (String nome : token.keySet()) {
            // Cria grupos nomeados no formato: (?<NOME>padrao)
            // O símbolo "|" atua como o operador "OU" entre os grupos
            regexBuilder.append(String.format("|(?<%s>%s)", nome, token.get(nome)));
        }
        
        // substring(1) remove o primeiro "|" que sobrou no início da string
        String regexFinal = regexBuilder.substring(1);
        
        // Compila a Regex e cria o Matcher para varrer a string 'codigo'
        Pattern pattern = Pattern.compile(regexFinal);
        Matcher matcher = pattern.matcher(codigo);

        System.out.println("\n--- Resultado da Análise Léxica ---");
        
        // Enquanto encontrar um trecho de texto que combine com a Regex...
        while (matcher.find()) {
            // Verifica qual dos grupos definidos no Map foi o responsável pelo "match"
            for (String nome : token.keySet()) {
                if (matcher.group(nome) != null) {
                    // printa eles
                    System.out.println(nome + " → " + matcher.group(nome));
                    
                    // Interrompe o loop interno (o token já foi classificado)
                    break;
                }
            }
        }
    }
}