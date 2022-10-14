
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FinalGraphController implements Initializable {

    @FXML
    private CheckBox appendPlots;

    @FXML
    private TextField fromBox;

    @FXML
    private LineChart<Number, Number> lineChart;

    @FXML
    private TextField numberBox;

    @FXML
    private TextArea tSeriesSummury;

    @FXML
    private TextField toBox;

    static public StringBuilder myData = new StringBuilder();

    static double hi;
    static double myN;
    static double finalAnswer;

    @FXML
    void runSimulation(ActionEvent event) {
        double startPos = Double.parseDouble(fromBox.getText());
        double endPos = Double.parseDouble(toBox.getText());
        if (startPos >= endPos) {
            tSeriesSummury.setText("Start Position cannot be greater or equal to end position");
            throw new InputException("Start Position cannot be greater or equal to end position");
        }

        else {

            double numOfPoints = 100;
            myData = new StringBuilder();
            int numOfTrys = Integer.parseInt(numberBox.getText()) - 1;
            myData = new StringBuilder();

            XYChart.Series dataSeries = new XYChart.Series();
            dataSeries.setName("Sine Approximation");

            XYChart.Series dataSeries2 = new XYChart.Series();
            dataSeries2.setName("True Sine");

            for (double currentAngle = startPos; currentAngle <= endPos; currentAngle += (endPos - startPos)
                    / numOfPoints) {
                double newVar = Math.toRadians(currentAngle);
                myData.append("sin(" + String.format("%.1f", currentAngle) + ") = ");
                myData.append(String.format(" %.10f", newVar));
                double sineRecursionValue = sinRecursion(newVar, numOfTrys);

                dataSeries.getData().add(new XYChart.Data(currentAngle, sineRecursionValue));
                double newVar2 = Math.toRadians(currentAngle);
                dataSeries2.getData().add(new XYChart.Data(currentAngle, Math.sin(newVar)));

                myData.append(" = " + finalAnswer + "\n");
                tSeriesSummury.setText(myData.toString());

            }
            if (!appendPlots.isSelected()) {
                lineChart.getData().clear();
            }
            lineChart.getData().add(dataSeries);
            lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
            lineChart.getData().add(dataSeries2);
            lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tSeriesSummury.setEditable(false);
    }

    static double sinRecursion(double x, int n) {
        double value = ((Math.pow(-1, n) / factorial((2 * n) + 1))) * Math.pow(x, (2 * n) + 1);
        if (n == 0) {
            finalAnswer = value;
            return value;
        } else {
            if (value >= 0) {
                String nValue = String.format(" + %.10f", value);
                myData.append(nValue);
            } else {
                String nValue = String.format(" + %.10f", value);
                myData.append(nValue);
            }
            finalAnswer = value + sinRecursion(x, n - 1);
            return finalAnswer;
        }
    }
    
    public static long factorial(long number) {
        long fact = 0;
        if (number == 0) {
            return 1;
        }
        if (number == 1) {
            return 1;
        } else {
            fact = number * factorial(number - 1);
            return fact;
        }

    }

}