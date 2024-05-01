package Programa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Programa para generar archivos planos pseudoaleatorios de vendedores y productos.
 * Los archivos generados incluyen información sobre ventas de vendedores, información de productos y detalles de vendedores.
 * Este programa fue desarrollado como parte de un proyecto del Politécnico Gran Colombiano por Nelson Hernando Guarin Benitez y Jorge Luis Cano Toro.
 */
public class Vendedores {

    /**
     * Método principal que inicia el programa.
     * Genera archivos de ventas de vendedores, información de productos y detalles de vendedores.
     * Imprime un mensaje de éxito si el proceso se completa sin errores.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        try {
            generateSalesMenFiles(5); // Generar 5 archivos de ventas de vendedores
            generateProductsFile(5); // Generar información de 5 productos
            generateSalesManInfoFile(12); // Generar información de 12 vendedores
            System.out.println("Proceso completado con éxito.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

    /**
     * Genera archivos de ventas de vendedores.
     * @param numFiles El número de archivos de ventas de vendedores que se van a generar.
     * @throws IOException Si ocurre un error al escribir en los archivos.
     */
    public static void generateSalesMenFiles(int numFiles) throws IOException {
        for (int i = 1; i <= numFiles; i++) {
            String fileName = "Vendedores_" + i + ".txt";
            generateSalesMenFile(fileName);
        }
    }

    /**
     * Genera un archivo de ventas de vendedores con datos pseudoaleatorios.
     * @param fileName El nombre del archivo que se va a generar.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public static void generateSalesMenFile(String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            // Escribir ventas pseudoaleatorias en el archivo
            writer.write("TipoDocumentoVendedor;NúmeroDocumentoVendedor\n");
            for (int j = 1; j <= random.nextInt(10); j++) {
                writer.write(generateRandomData(random));
            }
        }
    }

    /**
     * Genera un archivo de información de productos con datos pseudoaleatorios.
     * @param numProducts El número de productos para incluir en el archivo.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public static void generateProductsFile(int numProducts) throws IOException {
        String fileName = "productos.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            // Escribir información pseudoaleatoria de productos en el archivo
            for (int i = 1; i <= numProducts; i++) {
                writer.write("IDProducto" + i + ";NombreProducto" + i + ";" + (random.nextDouble() * 100) + "\n");
            }
        }
    }

    /**
     * Genera un archivo de información de vendedores con datos pseudoaleatorios.
     * @param numSalesmenCount El número de vendedores para incluir en el archivo.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public static void generateSalesManInfoFile(int numSalesmenCount) throws IOException {
        String fileName = "Vendedor.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            // Escribir información pseudoaleatoria de vendedores en el archivo
            for (int i = 1; i <= numSalesmenCount; i++) {
                writer.write("TipoDocumento" + i + ";" + random.nextInt(1000) + ";NombresVendedor" + i + ";ApellidosVendedor" + i + "\n");
            }
        }
    }

    /**
     * Genera datos pseudoaleatorios para el tipo de documento y el número de documento del vendedor.
     * @param random Objeto Random para generar números aleatorios.
     * @return Una cadena que representa el tipo de documento y el número de documento del vendedor.
     */
    private static String generateRandomData(Random random) {
        String tipoDocumento = random.nextInt(2) == 0 ? "CC" : "TI"; // Genera aleatoriamente "CC" o "TI"
        int numeroDocumento = 1000000 + random.nextInt(9000000); // Genera un número de documento aleatorio de 7 dígitos
        return tipoDocumento + ";" + numeroDocumento + "\n";
    }
}

