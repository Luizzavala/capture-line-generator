import java.util.Random;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PaymentCaptureLine {

    /**
     * Genera una línea de captura de pago basada en una referencia bancaria y un monto.
     *
     * @param bancaryReference La referencia bancaria proporcionada.
     * @param amount           El monto asociado a la referencia bancaria.
     * @return Una cadena que representa la línea de captura generada.
     */
    public static String paymentCaptureLineGenerator(String bancaryReference, double amount) {
        Random random = new Random();
        String typeOfRegistration = "2";
        String folioNumber = String.format("%021d", Long.parseLong(String.valueOf(random.nextInt(2147483647))));
        String paymentMethod = "V1"; //
        String paymentForm = "01"; //
        String grossAmount = String.format("%016d", (long) (amount * 100));
        String discountedAmount = "0000000000";
        String discountIndicator = "N";
        String referenceText = String.format("%040d", Long.parseLong(bancaryReference));
        return typeOfRegistration + folioNumber + paymentMethod + paymentForm + grossAmount
                + discountedAmount + discountIndicator + grossAmount + referenceText;
    }

    /**
     * Lee un archivo de entrada con referencias bancarias y montos, genera líneas
     * de captura para cada uno, y guarda el resultado en un archivo de salida.
     *
     * @param inputFile  La ruta del archivo de entrada que contiene las referencias bancarias y montos.
     * @param outputFile La ruta del archivo de salida donde se guardarán las líneas de captura generadas.
     * @throws IOException Si ocurre un error durante la lectura o escritura de archivos.
     */
    public static void generateAndSaveReferencesFromFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile)); BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String reference = parts[0];
                String amount = parts[1];
                String paymentCaptureLine = paymentCaptureLineGenerator(reference, Double.parseDouble(amount));
                bw.write(paymentCaptureLine + "\n");
            }
            System.out.println("References generated and saved to " + outputFile);
        }
    }


    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Repositorios\\Nuevos Proyectos\\CaptureLineGenerator\\assets\\inputFile.txt";
        String outputFile = "C:\\Repositorios\\Nuevos Proyectos\\CaptureLineGenerator\\assets\\outPutFile.txt";
        generateAndSaveReferencesFromFile(inputFile, outputFile);
    }
}