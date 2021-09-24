/*
 * Copyright 2021 Jovanni Narciso Sanchez Hernandez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.kokecena.effects;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * @author Jovanni Narciso Sanchez Hernandez
 */
public class Move {

    private static void initAnimation(Movement.Direction move, Component c, int startPosition, int endPosition, int ticks, int delay) {
        Timer animation = new Timer(delay, null);
        animation.setRepeats(true);
        animation.addActionListener(new Movement(move, c, startPosition, endPosition, ticks, animation));
        animation.start();
    }

    /**
     * <p>
     * Metodo para mover hacia arriba Aqui se juega con el Eje Y; Supongamos que
     * tenemos un componente en estos puntos
     * </p>
     * <br>Location X = 100, Y = 100
     * Y agregamos como posicion inicial 100
     * <br>Location X = 100, Y = 100 + 100 -> Y = 200
     * <p>
     * Ahora nuestro componente no se encuentra en el punto Y = 100 se encuentra
     * en el punto Y = 200, quiere decir que esta 100 pixeles mas abajo de su
     * posicion original
     * </p>
     * <p>
     * Ahora que tiene su punto de inicio, tambien debe añadirse la poisicion
     * final a la que llegara en este caso queremos que llegue a su posicion
     * original 100 para llegar a esta posicion tambien se pide los ticks, que
     * es la velocidad con la que llegara a la posicion original, 1 tick
     * equivale a 1px de la posicion de componente
     * </p>
     * <p>
     * Si le pasamos una velocidad de 5 ticks lo que hara es decrementar la
     * posicion actual del componente hasta llegar a la posicion final deseada.
     * </p>
     * <br>Y = 200 - 5
     * <br> setLocation(X, Y);
     * <br> Siguiente iteracion
     * <br> Y = 195 - 5
     * <br> setLocation(X,Y);
     * <br> .
     * <br> .
     * <br> .
     * <br> Y = 105 - 5
     * <br> setLocation(X, Y);
     * <br> si(Y menor igual a posFinal){
     * <br> animacion.stop();
     * <br> }
     *
     * @param c             Componente a mover
     * @param startPosition Posicion inicial
     * @param endPosition   Posicion final
     * @param ticks         Velocidad
     * @param delay         Retardo
     */
    public static void Up(Component c, int startPosition, int endPosition, int ticks, int delay) {
        initAnimation(Movement.Direction.UP, c, startPosition, endPosition, ticks, delay);
    }

    /**
     * <p>
     * Metodo para mover hacia abajo Aqui se juega con el Eje Y; Supongamos que
     * tenemos un componente en estos puntos
     * </p>
     * <br>Location X = 100, Y = 100
     * Y agregamos como posicion inicial 100
     * <br>Location X = 100, Y = 100 - 100 -> Y = 0
     * <p>
     * Ahora nuestro componente no se encuentra en el punto Y = 100 se encuentra
     * en el punto Y = 0, quiere decir que esta 100 pixeles mas arriba de su
     * posicion original
     * </p>
     * <p>
     * Ahora que tiene su punto de inicio, tambien debe añadirse la poisicion
     * final a la que llegara en este caso queremos que llegue a su posicion
     * original 100 para llegar a esta posicion tambien se pide los ticks, que
     * es la velocidad con la que llegara a la posicion original, 1 tick
     * equivale a 1px de la posicion de componente
     * </p>
     * <p>
     * Si le pasamos una velocidad de 5 ticks lo que hara es decrementar la
     * posicion actual del componente hasta llegar a la posicion final deseada.
     * </p>
     * <br>Y = 0 + 5
     * <br> setLocation(X, Y);
     * <br> Siguiente iteracion
     * <br> Y = 5 + 5
     * <br> setLocation(X,Y);
     * <br> .
     * <br> .
     * <br> .
     * <br> Y = 95 + 5
     * <br> setLocation(X, Y);
     * <br> si(Y Mayor o igual a posFinal){
     * <br> animacion.stop();
     * <br> }
     *
     * @param c             Componente a mover
     * @param startPosition Posicion inicial
     * @param endPosition   Posicion final
     * @param ticks         Velocidad
     * @param delay         Retardo
     */
    public static void Down(Component c, int startPosition, int endPosition, int ticks, int delay) {
        initAnimation(Movement.Direction.DOWN, c, startPosition, endPosition, ticks, delay);
    }

    /**
     * <p>
     * Metodo para mover hacia arriba la derecha se juega con el Eje X;
     * Supongamos que tenemos un componente en estos puntos
     * </p>
     * <br>Location X = 100, Y = 100
     * Y agregamos como posicion inicial 100
     * <br>Location X = 100 - 100 -> X = 0, Y = 100
     * <p>
     * Ahora nuestro componente no se encuentra en el punto X = 200 se encuentra
     * en el punto X = 0, quiere decir que esta 100 pixeles mas a su izquierda
     * de su posicion original
     * </p>
     * <p>
     * Ahora que tiene su punto de inicio, tambien debe añadirse la poisicion
     * final a la que llegara en este caso queremos que llegue a su posicion
     * original 100 para llegar a esta posicion tambien se pide los ticks, que
     * es la velocidad con la que llegara a la posicion original, 1 tick
     * equivale a 1px de la posicion de componente
     * </p>
     * <p>
     * Si le pasamos una velocidad de 5 ticks lo que hara es incrementar la
     * posicion actual del componente hasta llegar a la posicion final deseada.
     * </p>
     * <br> X = 0 + 5
     * <br> setLocation(X, Y);
     * <br> Siguiente iteracion
     * <br> X = 5 + 5
     * <br> setLocation(X,Y);
     * <br> .
     * <br> .
     * <br> .
     * <br> X = 95 + 5
     * <br> setLocation(X, Y);
     * <br> si(X mayor igual a posFinal){
     * <br> animacion.stop();
     * <br> }
     *
     * @param c             Componente a mover
     * @param startPosition Posicion inicial
     * @param endPosition   Posicion final
     * @param ticks         Velocidad
     * @param delay         Retardo
     */
    public static void Right(Component c, int startPosition, int endPosition, int ticks, int delay) {
        initAnimation(Movement.Direction.RIGHT, c, startPosition, endPosition, ticks, delay);
    }

    /**
     * <p>
     * Metodo para mover hacia la izquierda aqui se juega con el Eje X;
     * Supongamos que tenemos un componente en estos puntos
     * </p>
     * <br>Location X = 100, Y = 100
     * Y agregamos como posicion inicial 100
     * <br>Location X = 100 + 100 -> X = 200, Y = 100
     * <p>
     * Ahora nuestro componente no se encuentra en el punto X = 100 se encuentra
     * en el punto X = 200, quiere decir que esta 100 pixeles mas a su derecha
     * de su posicion original
     * </p>
     * <p>
     * Ahora que tiene su punto de inicio, tambien debe añadirse la poisicion
     * final a la que llegara en este caso queremos que llegue a su posicion
     * original 100 para llegar a esta posicion tambien se pide los ticks, que
     * es la velocidad con la que llegara a la posicion original, 1 tick
     * equivale a 1px de la posicion de componente
     * </p>
     * <p>
     * Si le pasamos una velocidad de 5 ticks lo que hara es decrementar la
     * posicion actual del componente hasta llegar a la posicion final deseada.
     * </p>
     * <br> X = 200 - 5
     * <br> setLocation(X, Y);
     * <br> Siguiente iteracion
     * <br> X = 195 - 5
     * <br> setLocation(X,Y);
     * <br> .
     * <br> .
     * <br> .
     * <br> X = 105 - 5
     * <br> setLocation(X, Y);
     * <br> si(X menor igual a posFinal){
     * <br> animacion.stop();
     * <br> }
     *
     * @param c             Componente a mover
     * @param startPosition Posicion inicial
     * @param endPosition   Posicion final
     * @param ticks         Velocidad
     * @param delay         Retardo
     */
    public static void Left(Component c, int startPosition, int endPosition, int ticks, int delay) {
        initAnimation(Movement.Direction.LEFT, c, startPosition, endPosition, ticks, delay);
    }

    /**
     * <br>(Experimental)
     * Sacude el componente en el tiempo que se le indique
     * en vibrationLenght
     * <br>¡OJO!
     * <br>No usa un timer como los demas metodos, por lo que su
     * uso detendra todo los componentes GUI que tengas
     * a la vista hasta que termine la animacion.
     *
     * @param c               Componente a sacudir
     * @param vibrationLength Duracion de la sacudida
     */
    public static void shake(Component c, int vibrationLength) {
        try {
            final int originalX = c.getX();
            final int originalY = c.getY();
            for (int i = 0; i < vibrationLength; i++) {
                Thread.sleep(10);
                c.setLocation(originalX, originalY + vibrationLength);
                Thread.sleep(10);
                c.setLocation(originalX, originalY - vibrationLength);
                Thread.sleep(10);
                c.setLocation(originalX + vibrationLength, originalY);
                Thread.sleep(10);
                c.setLocation(originalX, originalY);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    /**
     * Ejemplo base del funcionamiento de movimiento
     *
     * @param c             Componente a mover
     * @param startPosition Posicion de inicio
     * @param endPosition   Posicion final
     * @param ticks         Velocidad
     * @param delay         Retardo
     */
    public static void exampleUp(Component c, int startPosition, int endPosition, int ticks, int delay) {
        Timer t = new Timer(delay, null);
        t.setRepeats(true);
        t.addActionListener(new ActionListener() {
            int x = c.getX();
            int y = c.getY() + startPosition;

            @Override
            public void actionPerformed(ActionEvent e) {
                c.setLocation(x, y);
                y -= ticks;
                if (y <= endPosition) {
                    c.setLocation(x, endPosition);
                    t.stop();
                }
            }
        });
        t.start();
    }

    static class Movement implements ActionListener {

        private final Direction direction; //Tipo de movimiento
        private final Component componentToMove; //Componente a mover
        private final Timer timer; //Temporizador
        private final int endPosition; //Posicion final
        private final int ticks; //Velocidad
        private int posX; //Posicion en X
        private int posY; //Posicion en Y
        /**
         * Constructor para generar el movimiento
         *
         * @param direction     Tipo de movimiento
         * @param c             Componente a mover
         * @param startPosition Posicion Inicial
         * @param endPosition   Posicion final
         * @param ticks         Velocidad
         * @param timer         Temporizador
         */
        public Movement(Direction direction, Component c, int startPosition, int endPosition, int ticks, Timer timer) {
            this.direction = direction;
            this.componentToMove = c;
            this.timer = timer;
            setPosition(startPosition);
            this.endPosition = endPosition;
            this.ticks = ticks;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!componentToMove.isVisible() || isNearToEndPosition()) {
                setEndLocation();
                timer.stop();
                return;
            }
            componentToMove.setLocation(posX, posY);
            if (direction == Direction.UP || direction == Direction.DOWN) {
                posY += (Direction.UP == direction) ? -ticks : ticks;
            } else {
                posX += (Direction.LEFT == direction) ? -ticks : ticks;
            }
        }

        /**
         * Suma o resta una posicion inicial para crear el efecto de movimiento
         * Ej. Si se quiere mover hacia arriba, al componente se le suma a su
         * eje Y haciendo que baje de su punto inicial
         * <p>
         * Original X = 10, Y = 10
         * <p>
         * Direccion ARRIBA, Posicion de Inicio = 20
         * <p>
         * Original_X = 10 Nuevo_Y = 10 + 20
         * <p>
         * componente.setLocation(OriginalX, Nuevo_Y)
         * <p>
         * Recordemos que cuando se incrementa el valor de Y en un componente
         * este se dirije hacia abajo, y esa es su posicion inicial.
         *
         * @param startPosition
         */
        private void setPosition(int startPosition) {
            switch (direction) {
                case UP:
                case DOWN:
                    this.posX = componentToMove.getX();
                    this.posY = componentToMove.getY() + (direction == Direction.UP ? startPosition : -startPosition);
                    break;
                default:
                    this.posX = componentToMove.getX() + (direction == Direction.LEFT ? startPosition : -startPosition);
                    this.posY = componentToMove.getY();
            }
        }

        /**
         * Localiza el componente al punto final correctamente
         */
        private void setEndLocation() {
            switch (direction) {
                case UP:
                case DOWN:
                    componentToMove.setLocation(posX, Direction.UP == direction ? Math.min(endPosition, posY) : Math.max(endPosition, posY));
                    break;
                default:
                    componentToMove.setLocation(Direction.LEFT == direction ? Math.min(endPosition, posX) : Math.max(endPosition, posX), posY);
            }
        }

        /**
         * Comprueba si la direccion se encuentra cerca de la posicion final
         * especificada.
         *
         * @return Si esta cerca de la posicion final
         */
        private boolean isNearToEndPosition() {
            switch (direction) {
                case UP:
                    return posY <= endPosition;
                case DOWN:
                    return posY >= endPosition;
                case LEFT:
                    return posX <= endPosition;
                case RIGHT:
                    return posX >= endPosition;
            }
            throw new RuntimeException("Unknown position");
        }

        /**
         * Tipo de movimiento
         */
        static enum Direction {
            UP,
            DOWN,
            LEFT,
            RIGHT;
        }

    }

}
