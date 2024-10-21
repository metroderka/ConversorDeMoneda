package com.ConversorDeMoneda.principal;
import java.text.DecimalFormat;
import java.util.Scanner;


public class PrincipalConsultaApi {
    public static void main(String[] args) {
        IsInputValid checkOption = new IsInputValid();
        IsInputValid checkMonto = new IsInputValid();
        DecimalFormat dosDecimales = new DecimalFormat("#.##");
        int opcion; double monto;
        String base; String target;
        Scanner scn = new Scanner(System.in);
        ConsultaMonedas consulta = new ConsultaMonedas();
        double cambio;
        String[] listaCambio  = new String[] { "USD","ARS",
                                               "ARS","USD",
                                               "USD","BRL",
                                               "BRL","USD",
                                               "USD","COP",
                                               "COP","USD" };
        while (true) {
            System.out.println("""
                    
                    Sea bienvenido al conversor de moneda =]
                    
                    1) Dólar ==> Peso argentino
                    2) Peso argentino ==> Dólar
                    3) Dólar ==> Real brasileño
                    4) Real brasileño ==> Dólar
                    5) Dólar ==> Peso colombiano
                    6) Peso colombiano ==> Dólar
                    7) Salir
                    Elija una opción válida:
                    **********************************************
                    """);
            System.out.println("Ingrese opción:");
            opcion = checkOption.checkInt(scn.nextLine());

            if (opcion == 7) {
                System.out.println("Fin del programa");
                break;
            }else if ( opcion == -1 ){
                System.out.println("Opción inválida");
                continue;
            }
            System.out.println("Ingrese valor que desea convertir:");
            monto = checkMonto.checkDouble(scn.nextLine());

            if (monto == -1){
                System.out.println("Opción inválida");
            }
            else {
                base = listaCambio[(opcion-1)*2];
                target = listaCambio[(opcion-1)*2+1];

                cambio = consulta.buscaCambio(base, target);

                System.out.println("El valor " + dosDecimales.format(monto).replace(",",".") + " [" + base + "] "+
                        "corresponde al valor final de ==> "+ dosDecimales.format(cambio*monto).replace(",",".") + " [" + target + "] \n"+
                        "**********************************************");
            }
        }
    }
}
