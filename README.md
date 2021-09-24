# JovisAnimation [![Maven Central](https://img.shields.io/maven-central/v/io.github.kokecena/JovisAnimation.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.kokecena%22%20AND%20a:%22JovisAnimation%22)

Efectos basicos para componentes Swing, cuenta con 2 clases estaticas:
- Fade
  - Fade permite que un componente de tipo ventana haga un efecto de aparición y desaparición
  - cuenta con 6 metodos, 3 para aparición y 3 para desaparición, cada uno con un distintos parametros segun sea necesario
  - se necesita que la ventana tenga desactivado el atributo de decoración (JFrame, Frame, JDialog, Dialog) por lo que es mas recomendable utilizarlo en un JWindow
- Move
  - Fade permite mover todo tipo de componentes, pero esta limitado a que los componentes se encuentren colocados en contenedores sin layouts
  - cuenta con metodos Up, Down, Left, Right, el cual pedira una el componente a mover, una posicion inicial, posicion final, velocidad del movimiento y el retardo
  - cuenta con un metodo experimental para sacudir el componente (OJO: Utiliza hilos para realizar el movimiento de sacudida todos los demas metodos antes mencionados 
    utilizan la implementacion del Timer por lo que la GUI no se congelara al contrario de este metodo.
    OJO2: Solo lo he probado en componentes de tipo ventana no se como sea su funcionamiento en componentes normales)
  - cuenta con un ejemplo del funcionamiento base de los movimientos, me tome la tarea de abstraer lo basico de los movimientos para no repetir codigo innesesariamente
  
 ### Demo disponible
 
 Dentro de la libreria incluyo el codigo de la demo que muestro en este [video](https://www.youtube.com/watch?v=nzsKpaFOKaM)
 
 ### Repositorio en Maven
 
 Logre subir la libreria a maven por lo que solo tendrian que ingresar esto en el POM de su proyecto para hacer uso de la libreria, esto por que planeo
 de verdad mejorar mas el codigo, mi idea es crear una interfaz de animación para usarla globalmente dentro de los metodos, como un Timer, pero de tal manera que pueda
 ser reutilizable en animaciones sencillas, en la demo trate de hacer un efecto de pulsación en los TextField usando un timer, pero bueno aun es algo primitivo para lo que
 quiero utilizar, les dejo aqui la dependencia que deben agregar si quieren hacer uso de la libreria.
 
 ```
 <dependency>
  <groupId>io.github.kokecena</groupId>
  <artifactId>JovisAnimation</artifactId>
  <version>1.0.3</version>
</dependency>
```

Eso es todo y espero lo disfruten :)
