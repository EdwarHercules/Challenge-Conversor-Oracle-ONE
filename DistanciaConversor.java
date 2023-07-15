import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class DistanciaConversor implements Conversor {
    private Map<String, DistanciaConversionFunction> conversiones;

    public DistanciaConversor() {
        conversiones = new HashMap<>();
        conversiones.put("Metro a Kilómetro", distancia -> distancia / 1000);
        conversiones.put("Metro a Centímetro", distancia -> distancia * 100);
        conversiones.put("Kilómetro a Metro", distancia -> distancia * 1000);
        conversiones.put("Kilómetro a Milla", distancia -> distancia * 0.621371);
        conversiones.put("Milla a Kilómetro", distancia -> distancia * 1.60934);
    }

    public void convertir() {
        Component frame = null;
        Icon icon = null;
        double distancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia que desea convertir: "));
        Object[] opcionesConversion = conversiones.keySet().toArray();
        String convertir = (String) JOptionPane.showInputDialog(
                frame,
                "Seleccione una opción de conversión:\n",
                "Menú",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                opcionesConversion,
                "Metro a Kilómetro");

        if (convertir != null) {
            DistanciaConversionFunction conversion = conversiones.get(convertir);
            double resultado = conversion.convertir(distancia);

            JOptionPane.showMessageDialog(null, "La distancia convertida es: " + resultado + " " + convertir.split(" a ")[1]);
        }
    }

    private interface DistanciaConversionFunction {
        double convertir(double distancia);
    }
}