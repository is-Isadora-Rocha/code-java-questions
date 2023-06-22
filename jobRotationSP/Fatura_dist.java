package jobRotationSP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fatura_dist {
    private static final PATH_ARQUIVO = "C:\\Users\\Isadora\\Downloads\\dados_2.xml";
    private static final String TAG_VALOR = "<valor>";
    private static final String REGEX = "[^\\d.]";

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        File arquivo = new File(PATH_ARQUIVO);
        LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(arquivo));
        linhaLeitura.skip(arquivo.length());
        int qtdLinhas = linhaLeitura.getLineNumber();
        try (BufferedReader arq = new BufferedReader(new FileReader(arquivo))) {
            List<Double> listaValores = new ArrayList();
            for (int cont = 0; cont < qtdLinhas; cont++) {
                String linha = arq.readLine();
                if (linha.contains(TAG_VALOR)) {
                    String valor = linha.replaceAll(REGEX, "");
                    if (!(Double.parseDouble(valor) == 0.0)) {
                        listaValores.add(Double.parseDouble(valor));
                    }
                }
            }
            printarMaioreMenorValor(listaValores);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printarMaioreMenorValor(List<Double> listaValores) {
        double max = Collections.max(listaValores);
        double min = Collections.min(listaValores);
        System.out.println("LISTA COM VALORES = " + listaValores);
        System.out.println("O MAIOR VALOR É " + max);
        System.out.println("O MENOR VALOR É " + min);
    }

}