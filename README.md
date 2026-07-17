# Calculadora Java - Proyecto SENA

Una calculadora de escritorio desarrollada en Java, enfocada en aplicar el patrón de arquitectura MVC (Modelo-Vista-Controlador) y buenas prácticas de programación orientada a objetos. 

## 🚀 Características
* **Operaciones básicas:** Suma, resta, multiplicación y división.
* **Jerarquía matemática:** El motor de cálculo respeta el orden de las operaciones, resolviendo multiplicaciones y divisiones antes que sumas y restas.
* **Manejo de errores:** Alertas visuales emergentes si se intenta evaluar una sentencia vacía o con sintaxis inválida.
* **Interfaz amigable:** Diseño escalable creado con componentes de Java Swing.

## 🏗️ Arquitectura (MVC)
El proyecto divide el código en tres capas principales para separar la lógica gráfica de la matemática:

* **Modelo (`src/calculadora/modelo`):** Contiene el "cerebro" de la aplicación. Incluye una máquina de estados para separar los números de los símbolos (`AnalizadorSentencia`), un sistema que almacena las operaciones válidas usando funciones lambda (`MotorCalculadora`) y un algoritmo para resolver la lista final (`EvaluadorExpresion`).
* **Vista (`src/calculadora/vista`):** Construida de manera visual en NetBeans. Se encarga únicamente de dibujar la ventana, los botones y reportar los clics del usuario.
* **Controladores (`src/calculadora/controlador`):** Los intermediarios. Toman los textos de la vista, se los pasan al modelo para ser evaluados de forma segura, y devuelven el resultado a la pantalla.

## 🛠️ Tecnologías y Herramientas
* **Lenguaje:** Java 
* **Interfaz Gráfica:** Java Swing
* **IDE:** NetBeans
* **Control de Versiones:** Git (historial documentado con convenciones de commits semánticos).

## 📂 Estructura del Código
El código fuente principal está organizado por paquetes según su responsabilidad en el patrón MVC:
```text
src/calculadora/
 ├── modelo/          # Lógica de negocio y evaluación matemática
 ├── vista/           # Componentes visuales (.java y .form)
 ├── controlador/     # Coordinación entre vista y modelo
 └── Calculadora.java # Clase principal e inicialización de dependencias
```