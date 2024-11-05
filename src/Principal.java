import java.util.Map;

public class Principal {
    public static void main(String[] args) {

        ConsultaMoneda consulta = new ConsultaMoneda();

        try{

            Moneda moneda = consulta.consultaMoneda();
            System.out.println("Base: " + moneda.base_code());
            System.out.println("Tasas de cambio: ");

            for(Map.Entry<String, Double> entry : moneda.conversion_rates().entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        }catch(NumberFormatException ex){
            System.out.println("Moneda no encontrada: " + ex.getMessage());
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
