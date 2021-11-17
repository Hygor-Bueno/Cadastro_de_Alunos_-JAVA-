package registerstudents;

import java.util.Arrays;

public class Validator {

    public boolean maxLength(String value, int maxLength) {
        boolean response = true;
        if (value.length() > maxLength) {
            response = false;
        }
        return response;
    }

    public boolean minLength(String value, int maxLength) {
        boolean response = true;
        if (value.length() < maxLength) {
            response = false;
        }
        return response;
    }

    public boolean equalLength(String value, int maxLength) {
        boolean response = true;
        if (value.length() == maxLength) {
            response = false;            
        }else{
            System.out.println("ATENÇÃO VALOR INVÁLIDO. O VALOR PRECISA TER " + maxLength + " DIGITOS.");
        }
        return true;
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

    public boolean minValue(int[] minValue) {
        boolean response = false;
      
        Arrays.sort(minValue);

        for (int i = 1; i < minValue.length; i++) {
            if (minValue[i] == minValue[i - 1]) {
                response = true;
                System.out.println("O VALOR " + minValue[i] + " JÁ FOI UTILIZADO");
            }
        }
        return true;
    }
}
