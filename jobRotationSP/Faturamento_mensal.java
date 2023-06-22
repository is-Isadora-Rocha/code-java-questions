package jobRotationSP;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Faturamento_mensal {
    private static final Double SP = 67.83643;
    private static final Double RJ = 36.67866;
    private static final Double MG = 29.22988;
    private static final Double ES = 27.16548;
    private static final Double OUTROS = 19.84953;

    private static final String SP_DISTRIBUIDORA = "SP";
    private static final String RJ_DISTRIBUIDORA = "RJ";
    private static final String MG_DISTRIBUIDORA = "MG";
    private static final String ES_DISTRIBUIDORA = "ES";
    private static final String OUTROS_DISTRIBUIDORA = "OUTROS";

    public static void main(String[] args) {
        List<Double> listaValores = Arrays.asList(SP, RJ, MG, ES, OUTROS);
        //add os valores das distribuidoras
        List<String> listaDistribuidoras = Arrays.asList(SP_DISTRIBUIDORA, RJ_DISTRIBUIDORA, MG_DISTRIBUIDORA,
                ES_DISTRIBUIDORA, OUTROS_DISTRIBUIDORA);
        //add os nomes das distribuidoras
        Double total = listaValores.stream().mapToDouble(Double::doubleValue).sum(); //calcula o total
        for (int contNome = 0; contNome < listaDistribuidoras.size(); contNome++){
            System.out.println("========================================");
            String porcentagemFormatada = valorPorcentagem(listaValores.get(contNome), total);
            System.out.println("A PORCENTAGEM DA DISTRIBUIDORA DE "+listaDistribuidoras.get(contNome)+
                    " : " + porcentagemFormatada);
            System.out.println("========================================");
        }
    }
    public static String valorPorcentagem(Double valorDistribuidora, Double valorTotal) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setMaximumFractionDigits(2);
        String porcentagemFormatada = df.format((valorDistribuidora * 100) / valorTotal).replace(",",".") + "%";
        return porcentagemFormatada;
    }
}
