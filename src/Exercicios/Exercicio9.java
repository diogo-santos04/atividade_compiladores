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

        // 1. Definição dos padrões (Nomes de grupos curtos e sem caracteres especiais complexos)
        Map<String, String> token = new LinkedHashMap<>();
        token.put("RESERVADA", "\\b(int|float|if|else|while)\\b");
        token.put("NUMERO", "\\d+");
        token.put("IDENTIFICADOR", "[a-zA-Z_][a-zA-Z0-9_]*");
        token.put("OPERADOR", "[+\\-*/=]");
        token.put("DELIMITADOR", "[;()]");

        // 2. Construção da Regex
        StringBuilder regexBuilder = new StringBuilder();
        for (String nome : token.keySet()) {
            // Criamos grupos nomeados: (?<RESERVADA>\b(int|float|...)\b)
            regexBuilder.append(String.format("|(?<%s>%s)", nome, token.get(nome)));
        }
        
        // O substring(1) remove o primeiro "|" extra
        Pattern pattern = Pattern.compile(regexBuilder.substring(1));
        Matcher matcher = pattern.matcher(codigo);

        // 3. Varredura
        System.out.println("\n--- Resultado da Análise Léxica ---");
        while (matcher.find()) {
            for (String nome : token.keySet()) {
                if (matcher.group(nome) != null) {
                    // Ajuste para exibição bonita
                    String label = nome.equals("RESERVADA") ? "PALAVRA_RESERVADA" : nome;
                    System.out.println(label + " → " + matcher.group(nome));
                    break;
                }
            }
        }
    }
}