##Manejo de Archivos en Java
**Obtener Snacks del Archivo**
**En esta línea se agregan los elementos.**
**snacks. add(snack);**
**//Agregamos el snack leído a la lista.**

**Cada vez que se encuentra una coma se separan en un arreglo y cada elemento del arreglo vamos obteniendo sus elementos. String[] lineaSnack = linea.split(","); y estamos aplicando el parseo.**

**Esta variable temporal interna snacks va a  ir recuperando los snacks y los va agregando a esta lista ArrayList<>();.**

**Agregar Snacks Iniciales al Archivo
Cerrando el flujo de nuestro archivo para que se escriba la información al archivo con salida.close(); sino se queda en memoria.**

**anexar = archivo.exists();
//la variable anexar si existe se cambia su valor a true.
//Esta línea es muy importante, ya que, de esta depende si se va a sobrescribir o agregar la información.**

***Escribir a un Archivo en Java
Con el método close cerramos el flujo. salida.close();**

**Anexar significa agregar contenido al archivo sin borrar el contenido anterior.**

**Con el paquete import java.nio.file.Files; y import java.nio.file.Paths; podemos leer todas las líneas del archivo. nio significa new input output.**

**Leer todo el Archivo en Java
Y con la clase Paths vamos a proporcionar la ruta del archivo y con la ayuda del método get indicamos el nombre del archivo.**

**Con este método leemos todas las líneas del archivo Files.readAllLines().**

**Antes de terminar de leer nuestro archivo es importante cerrar el archivo llamando a la variable y el método entrada.close().**

**Antes de terminar el ciclo, nos movemos a la siguiente línea, llamando a nuestra variable linea y el método entrada.readLine().**

**Utilizamos un ciclo while para leer todas las líneas del archivo.**

**Para poder leer un archivo primero le pasamos un objeto File posteriormente creamos un objeto de FileReader y para simplificar la lectura del archivo y poder leer línea por línea o sea líneas completas creamos otro objeto BufferedReader.**

**Para abrir el archivo creamos la variable entrada y con la clase BufferedReader leemos líneas completas del archivo y con la clase FileReader le pasamos el objeto archivo.**

##Manejo de Archivos en Java
**Si queremos imprimir todos los detalles de los errores mandamos a llamar al método printStackTrace(). Muestra las líneas, las clases, los archivos que generaron el error.**

**Con FileWriter se crea el archivo y envolviendo en el objeto PrintWriter podemos  escribir en el archivo. Y hasta que mandamos a salida.close() es cuando se guarda el archivo en el disco duro.**

**IOException es una excepción más específica para la captura de excepciones.**