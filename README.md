# Conversor de Moneda

Este proyecto es una aplicación creada en Java versión 21, sirve para realizar conversiones de monedas en tiempo real. Utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio actualizadas comparándolas con el dólar estadounidense (USD).

## Descripción

La aplicación permite al usuario convertir entre varias monedas predefinidas, como el peso argentino (ARS), peso boliviano (BOB), y peso colombiano (COP). Las tasas de cambio se obtienen en tiempo real a través de la API y se utilizan para realizar los cálculos de conversión.

## Funcionalidades

- **Consulta de Tasas de Cambio**: El programa se conecta a la API de ExchangeRate-API para obtener las tasas de cambio actualizadas con respecto al USD.
- **Conversión de Monedas**: Permite convertir valores entre:
    - Dólar (USD) a Peso Argentino (ARS) y viceversa
    - Dólar (USD) a Peso Boliviano (BOB) y viceversa
    - Dólar (USD) a Peso Colombiano (COP) y viceversa
- **Menú Interactivo**: El usuario puede seleccionar la conversión que desea realizar y especificar el monto a convertir.

## Estructura del Proyecto

- **Principal.java**: Contiene la lógica del menú interactivo, donde el usuario puede seleccionar el tipo de conversión y especificar el monto a convertir.
- **ConsultaMoneda.java**: Se conecta a la API para obtener las tasas de cambio en tiempo real.
- **Moneda.java**: Modelo que representa la respuesta de la API, que contiene el código base y las tasas de cambio para las diferentes monedas.

### Ejecución de la Aplicación

1. Al iniciar el programa, se presenta el menú a través de un loop while.
2. El usuario selecciona una opción (del 1 al 6) y luego ingresa el valor que desea convertir.
3. La aplicación realiza la conversión basada en la tasa de cambio actual y muestra el resultado en pantalla.
4. Para salir de la aplicación lo hacemos con la opción 7.
5. Cualquier otro número no será válido.

> **Nota**: Las tasas de cambio varían de acuerdo al tiempo o momento en que se consulte la API.

## Dependencias

Este proyecto utiliza las siguientes dependencias:

- [Gson](https://github.com/google/gson): Para deserializar la respuesta JSON de la API.
- **Java HTTP Client**: Para realizar solicitudes HTTP a la API de ExchangeRate-API.

## Cómo Ejecutar el Proyecto

1. Clonar el repositorio o copiar el código fuente en tu entorno de trabajo.
2. Agregar la dependencia de `Gson` en tu proyecto. Puedes hacerlo descargando el archivo .jar en el sitio web de Maven.
3. Ejecutar la clase `Principal` para iniciar el conversor de moneda.

## API Utilizada

Este proyecto se basa en la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio en tiempo real. Se utiliza el endpoint `/latest/USD`, que devuelve las tasas de cambio con respecto al USD.

> **Nota**: Asegúrate de reemplazar `https://v6.exchangerate-api.com/v6/e03f36b37747c963527864cb/latest/USD` con tu propia clave de API, si estás utilizando tu propia cuenta de ExchangeRate-API.

## Manejo de Errores

Si ocurre un error al intentar conectarse a la API (por ejemplo, si la API no está disponible), se lanza un `RuntimeException` con el mensaje: "No encontré esa moneda."


---

¡Gracias por utilizar este conversor de moneda en Java!
