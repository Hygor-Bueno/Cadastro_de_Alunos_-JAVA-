package registerstudents;

public class Validator {

    View view = new View();

    public boolean maxLength(String value, int maxLength) {
        boolean response = true;
        if (value.length() > maxLength) {
            System.out.println("************************************************************************");
            System.out.println("ATENÇÃO VALOR INVÁLIDO. O VALOR PRECISA TER NO MAXIMO" + maxLength + " DIGITOS.");
            response = false;
        }
        return response;
    }
    public boolean maxLength(int value, int maxLength) {
        boolean response = true;
        if (value > maxLength) {
            System.out.println("************************************************************************");
            System.out.println("ATENÇÃO VALOR INVÁLIDO. O VALOR MÁXIMO PERMITIDO É DE " + maxLength + " .");
            response = false;
        }
        return response;
    }
 
    public boolean minLength(String value, int minLength) {
        boolean response = true;
        if (value.length() < minLength) {
            System.out.println("************************************************************************");
            System.out.println("ATENÇÃO VALOR INVÁLIDO. O VALOR PRECISA TER NO MINIMO" + minLength + " DIGITOS.");
            response = false;
        }
        return response;
    }

    public boolean equalLength(String value, int equalLength) {
        boolean response = true;
        if (value.length() != equalLength) {
            response = false;
            System.out.println("************************************************************************");
            System.out.println("ATENÇÃO VALOR INVÁLIDO. O VALOR PRECISA TER " + equalLength + " DIGITOS.");
        }
        return response;
    }

    public int lowerValue(int[] lowerValue) {
        int value = lowerValue[0];
        for (int index = 0; index < lowerValue.length; index++) {
            if (value > lowerValue[index]) {
                value = lowerValue[index];
            }
        }
        return value;
    }

    public boolean equalValue(int[] list, int value) {
        boolean response = true;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == value) {
                response = false;
                System.out.println("************************************************************************");
                System.out.println("O VALOR " + list[i] + " JÁ FOI UTILIZADO");
            }
        }
        return response;
    }
    
}
