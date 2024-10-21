package com.ConversorDeMoneda.principal;

import static java.lang.Integer.parseInt;

public class IsInputValid {
    public int checkInt (String input) {
        int x;
        try {
            x = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
        if ((x > 0) && (x < 8)) {
            return x;
        } else {
            return -1;
        }
    }
    public double checkDouble (String monto){
        double x;
        try{
            x = Double.parseDouble(monto);
            return x;
        } catch(NumberFormatException e){
            return -1;
        }
    }
}
