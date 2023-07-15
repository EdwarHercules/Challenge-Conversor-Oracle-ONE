import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class TemperaturaConversor implements Conversor{

	private static Map<String,TemperaturaConversionFunction> conversiones;

	public TemperaturaConversor() {
		conversiones = new HashMap<>();
		conversiones.put("Celsius a Fahrenheit", temperatura -> (temperatura * 9 / 5) + 32);
		conversiones.put("Celsius a Kelvin", temperatura -> temperatura + 273.15);
		conversiones.put("Fahrenheit a Celsius", temperatura -> (temperatura - 32) * 5 / 9);
		conversiones.put("Fahrenheit a Kelvin", temperatura -> (temperatura + 459.67) * 5 / 9);
		conversiones.put("Kelvin a Celsius", temperatura -> temperatura - 273.15);
		conversiones.put("Kelvin a Fahrenheit", temperatura -> temperatura * 9 / 5 - 459.67);
	}



	public void convertir() {
		//	Component frame = null;
		//Icon icon = null;
		double temperatura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la temperatura que desee convertir: "));
		String[] opcionesConversion = conversiones.keySet().toArray(new String[0]);
		String convertir = (String) JOptionPane.showInputDialog(
				null,
				"Elije la temperatura a la cual deseas convertir:\n",
				"Menu",
				JOptionPane.PLAIN_MESSAGE,
				null,
				opcionesConversion,
				"De Celsius a Fahrenheit");

		if (convertir != null) {
			TemperaturaConversionFunction conversion = conversiones.get(convertir);
			double resultado = conversion.convertir(temperatura);

			JOptionPane.showMessageDialog(null, "La temperatura convertida es: " + resultado + " " + convertir.split(" a ")[1]);

		} 
	}
	
    private interface TemperaturaConversionFunction {
        double convertir(double temperatura);
    }

}
