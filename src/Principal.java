import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        ConsultaMoneda consulta = new ConsultaMoneda();

        Moneda moneda;
        try{
            moneda = consulta.consultaMoneda();
        }catch (RuntimeException ex) {
            System.out.println("Error al obtener tasas de cambio: " + ex.getMessage());
            return;
        }

        int opcion = 0;

        while(opcion != 7){
            System.out.println("""
                ************************************************
                Sea bienvenido/a al Conversor de Moneda =)
                
                1) Dólar => Peso argentino
                2) Peso argentino => Dólar
                3) Dólar => Peso boliviano
                4) Peso boliviano => Dólar
                5) Dólar => Peso colombiano
                6) Peso colombiano => Dólar
                7) Salir
                Elija una opción válida:
                ************************************************
                """);
            opcion = lectura.nextInt();

            if(opcion >= 1 && opcion <= 6){
                System.out.println("Ingrese el valor que desea convertir: ");
                double valor = lectura.nextDouble();
                double resultado = 0;

                switch (opcion){
                    case 1: // Dólar peso => argentino
                        resultado = valor * moneda.conversion_rates().get("ARS");
                        System.out.printf("El valor %.2f [USD] corresponde al valor final de =>>> %.2f [ARS]%n", valor, resultado);
                        break;
                    case 2: // Peso argentino => dólar
                        resultado = valor / moneda.conversion_rates().get("ARS");
                        System.out.printf("El valor %.2f [ARS] corresponde al valor final de =>>> %.2f [USD]%n", valor, resultado);
                        break;
                    case 3: // Dólar => peso boliviano
                        resultado = valor * moneda.conversion_rates().get("BOB");
                        System.out.printf("El valor %.2f [USD] corresponde al valor final de =>>> %.2f [BOB]%n", valor, resultado);
                        break;
                    case 4: // Peso boliviano => dólar
                        resultado = valor / moneda.conversion_rates().get("BOB");
                        System.out.printf("El valor %.2f [BOB] corresponde al valor final de =>>> %.2f [USD]%n", valor, resultado);
                        break;
                    case 5: // Dólar => peso colombiano
                        resultado = valor * moneda.conversion_rates().get("COP");
                        System.out.printf("El valor %.2f [USD] corresponde al valor final de =>>> %.2f [COP]%n", valor, resultado);
                        break;
                    case 6: // Peso colombiano => dólar
                        resultado = valor / moneda.conversion_rates().get("COP");
                        System.out.printf("El valor %.2f [COP] corresponde al valor final de =>>> %.2f [USD]%n", valor, resultado);
                        break;
                }

            }else if(opcion != 7){
                System.out.println("Opción no válida.");
            }

        }
        System.out.println("Finalizando aplicación de conversor de monedas.♣");
    }
}
