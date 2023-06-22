package jobRotationSP;

public class Inverter_charac {
     public static void main(String[] args) {
        String padrao = "Eles passarão, eu passarinho";
        char[] array = new char[padrao.length()];

        for (int i = padrao.length() - 1, j = 0; i >= 0; i--, j++){
            array[j] = padrao.charAt(i);
        }
        String invertida = new String(array);
        System.out.println(invertida);
    }
}
