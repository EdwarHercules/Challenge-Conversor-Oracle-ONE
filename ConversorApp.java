
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class ConversorApp {
	public static void main(String[] args) {
		Map<String, Conversor> conversorMap = new HashMap<>();
		conversorMap.put("Conversor de Moneda", new MonedaConversor());
		conversorMap.put("Conversor de Temperatura", new TemperaturaConversor());
		conversorMap.put("Conversor de Distancia", new DistanciaConversor());

		boolean continuar = true;
		while(continuar) {
		
				try {
					Object[] possibilities = {"Conversor de Moneda", "Conversor de Temperatura", "Conversor de Distancia"};
					Component frame = null;
					Icon icon = null;
					String selectedOption = (String) JOptionPane.showInputDialog(
							frame,
							"Seleccione una opción de conversión:\n",
							"Menu",
							JOptionPane.PLAIN_MESSAGE,
							icon,
							possibilities,
							"Conversor de Moneda");

					if (selectedOption != null) {


						Conversor conversor = conversorMap.get(selectedOption);
						if (conversor != null) {
							conversor.convertir();
							int opcion = JOptionPane.showOptionDialog(
									null,
									"¿Desea continuar?",
									"Confirmación",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE,
									null,
									new Object[]{"Yes", "No", "Cancel"},
									"Yes");
							switch (opcion) {
							case JOptionPane.YES_OPTION:
								// Continuar en el bucle
								break;
							case JOptionPane.NO_OPTION:
								// finaliza el programa
							case JOptionPane.CANCEL_OPTION:
								// finaliza el programa
								JOptionPane.showMessageDialog(
										null,
										"Programa finalizado.",
										"Finalización",
										JOptionPane.INFORMATION_MESSAGE);
								continuar = false;
								break;
							}
						} else {
							System.out.println("Opción inválida");
						}
					} else {
						//Si no se selecciona una opcion se, finaliza el programa
						JOptionPane.showMessageDialog(
								null,
								"Programa finalizado.",
								"Finalización",
								JOptionPane.INFORMATION_MESSAGE);           
						continuar = false;
					}

				}catch(NumberFormatException | NullPointerException exception){
					JOptionPane.showMessageDialog(
							null,
							"Valor no valido.",
							"Finalización",
							JOptionPane.INFORMATION_MESSAGE);           
					continuar = false;

				}


			

		}

	}
}
