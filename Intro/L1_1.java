import javax.swing.JOptionPane;

public class L1_1 {
    public static void main(String[] args) {
    String strTemperature = JOptionPane.showInputDialog("Enter the tempearture in Fahrenheit");
    double temperature = Double.parseDouble(strTemperature);
    double celcius = (5f / 9f) * (temperature - 32);
    
    JOptionPane.showMessageDialog(null, "Temperature in Celcius is: " + celcius, "Temperature Calculation", JOptionPane.INFORMATION_MESSAGE);
    }
}
