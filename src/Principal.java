
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

        String[][] conversiones = {
                {"USD", "ARS"},
                {"ARS", "USD"},
                {"USD", "BOB"},
                {"BOB", "USD"},
                {"USD", "COP"},
                {"COP", "USD"},
        };

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

                String monedaOrigen = conversiones[opcion - 1][0];
                String monedaDestino = conversiones[opcion - 1][1];

                double resultado;
                if(monedaDestino.equals("USD")){
                    double tasaCambio = moneda.conversion_rates().get(monedaOrigen);
                    resultado = valor / tasaCambio;
                }else{
                    double tasaCambio = moneda.conversion_rates().get(monedaDestino);
                    resultado = valor * tasaCambio;
                }

                System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n",
                        valor, monedaOrigen, resultado, monedaDestino);

            }else if(opcion != 7){
                System.out.println("Opción no válida.");
            }

        }
        System.out.println("Finalizando aplicación de conversor de monedas.♣");
    }
}
