import java.text.DecimalFormat;
class Solution {
    public double[] convertTemperature(double celsius) {
        DecimalFormat df = new DecimalFormat("0.00000");

        double kelvin = celsius + 273.15;
        double farenheit = celsius * 1.8 + 32.00;

        double[] result = new double[2];
        result[0] = Double.parseDouble(df.format(kelvin).replace(',','.'));
        result[1] = Double.parseDouble(df.format(farenheit).replace(',','.'));
        return result;

    }
}