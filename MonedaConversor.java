
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class MonedaConversor implements Conversor {
	private static final Map<String, Double> FACTORES_CONVERSION_MONEDAS;
	
	static {
		FACTORES_CONVERSION_MONEDAS = new HashMap<>();
		FACTORES_CONVERSION_MONEDAS.put("De Lempira a Dolar", 0.04);
		FACTORES_CONVERSION_MONEDAS.put("De Lempira a Euro", 0.036);
		FACTORES_CONVERSION_MONEDAS.put("De Lempira a Libra", 1.26);
		FACTORES_CONVERSION_MONEDAS.put("De Lempira a Yen", 5.61);
		FACTORES_CONVERSION_MONEDAS.put("De Lempira a Won Coreano", 51.75);
		FACTORES_CONVERSION_MONEDAS.put("De Dolar a Lempiras", 24.49);
        FACTORES_CONVERSION_MONEDAS.put("De Euro a Lempiras", 27.50);
        FACTORES_CONVERSION_MONEDAS.put("De Libra a Lempiras", 0.79);
	}
	
	
	
	public void convertir() {
        //	Component frame = null;
        //Icon icon = null;
        double moneda = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que desee convertir: "));
        String[] opcionesConversion = FACTORES_CONVERSION_MONEDAS.keySet().toArray(new String[0]);
        String convertir = (String) JOptionPane.showInputDialog(
                null,
                "Elije la moneda a la cual deseas convertir tu dinero:\n",
                "Menu",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcionesConversion,
                "De Lempira a Dolar");

        if (convertir != null) {
        	double conversion = moneda * FACTORES_CONVERSION_MONEDAS.get(convertir);
        	mostrarResultados(conversion, convertir);
            
            } 
      }
	private void mostrarResultados(double conversion, String convertir) {
		String monedaDestino = convertir.split(" a ")[1];
		JOptionPane.showMessageDialog(null,"Tiene $" + conversion + " " + monedaDestino);
	}
    
}
