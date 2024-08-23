# Generador de Líneas de Captura de Pago

## Descripción

Esta aplicación en Java genera líneas de captura de pago basadas en referencias bancarias y montos proporcionados. Las líneas de captura siguen un formato específico que incluye varios campos como tipo de registro, número de folio, método de pago, forma de pago, y otros detalles relevantes. Además, la aplicación permite leer un archivo de entrada con múltiples referencias y montos, y genera un archivo de salida con las líneas de captura correspondientes.

## Funcionalidades

- **Generación de Línea de Captura**: La aplicación genera una línea de captura basada en una referencia bancaria y un monto proporcionado. La línea de captura se estructura en varios campos:
    - Tipo de Registro (`typeOfRegistration`): Fijo a "2".
    - Número de Folio (`folioNumber`): Un número aleatorio de 21 dígitos.
    - Método de Pago (`paymentMethod`): Fijo a "V1".
    - Forma de Pago (`paymentForm`): Fijo a "01".
    - Importe Bruto (`grossAmount`): Monto total en centavos representado en 16 dígitos.
    - Importe de Descuento (`discountedAmount`): Fijo a "0000000000".
    - Indicador de Descuento (`discountIndicator`): Fijo a "N".
    - Referencia Bancaria (`referenceText`): La referencia bancaria proporcionada, ajustada a 40 dígitos.

- **Procesamiento de Archivos**: La aplicación puede leer un archivo de texto que contenga líneas con referencias bancarias y montos separados por comas, generar las líneas de captura para cada par, y escribir el resultado en un archivo de salida.

## Uso

### Requisitos Previos

- **Java 8 o superior** debe estar instalado en el sistema.

### Instrucciones de Ejecución

1. **Compilación**: Compila el código fuente utilizando el siguiente comando:
   ```bash
   javac PaymentCaptureLine.java
