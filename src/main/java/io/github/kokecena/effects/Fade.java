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

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.IllegalComponentStateException;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * @author Jovanni Narciso Sanchez Hernandez
 */
public class Fade {

    /**
     * Animacion de aparicion de la ventana
     * <br>por defecto tiene un retardo de 5
     *
     * @param w
     */
    public static void fadeIn(Window w) {
        new FadeAnimation(true, w).initFade();
    }

    /**
     * Animacion de desaparicion de la ventana
     * <br>por defecto tiene un retardo de 5
     *
     * @param w
     */
    public static void fadeOut(Window w) {
        new FadeAnimation(false, w).initFade();
    }

    /**
     * Animacion de aparicion de la ventana
     * <br> Se le pasa un argumento indicando el retardo
     * de aparicion de la ventana
     *
     * @param w
     * @param delay
     */
    public static void fadeIn(Window w, int delay) {
        new FadeAnimation(true, delay, w).initFade();
    }

    /**
     * Animacion de desaparicion de la ventana
     * <br> Se le pasa un argumento indicando el retardo
     * de desaparicion de la ventana
     *
     * @param w
     * @param delay
     */
    public static void fadeOut(Window w, int delay) {
        new FadeAnimation(false, delay, w).initFade();
    }

    /**
     * Animacion de aparicion de la ventana
     * <br> Se le pasa un argumento indicando el retardo
     * de desaparicion de la ventana
     * <br> Se le pasa un argumento indicando la velocidad
     * con la que la opacidad incrementara
     *
     * @param w
     * @param delay
     */
    public static void fadeIn(Window w, int delay, float opacityTick) {
        new FadeAnimation(true, delay, opacityTick, w).initFade();
    }

    /**
     * Animacion de desaparicion de la ventana
     * <br> Se le pasa un argumento indicando el retardo
     * de desaparicion de la ventana
     * <br> Se le pasa un argumento indicando la velocidad
     * con la que la opacidad decrementara
     *
     * @param w
     * @param delay
     */
    public static void fadeOut(Window w, int delay, float opacityTick) {
        new FadeAnimation(false, delay, opacityTick, w).initFade();
    }

    public static class FadeAnimation {

        private boolean fadeIn;
        private Window w;
        private float opacityTick;
        private float opacityStart;
        private Timer animation;

        /**
         * Constructor principal de la animacion de aparicion
         *
         * @param fadeIn
         * @param delay       retardo
         * @param opacityTick velocidad
         * @param w           ventana
         */
        public FadeAnimation(boolean fadeIn, int delay, float opacityTick, Window w) {
            undecoratedException(w);
            illegalOpacityTick(opacityTick);
            this.fadeIn = fadeIn;
            this.opacityTick = fadeIn ? opacityTick : -opacityTick;
            this.opacityStart = fadeIn ? 0f : 1f;
            this.w = w;
            this.animation = new Timer(delay, null);

        }

        public FadeAnimation(final boolean fadeIn, int delay, final Window w) {
            this(fadeIn, delay, 0.1f, w);
        }

        public FadeAnimation(final boolean fadeIn, final Window w) {
            this(fadeIn, 5, 0.1f, w);
        }

        /**
         * Inicia la animacion de aparicion
         */
        public void initFade() {
            animation.setRepeats(true);
            animation.addActionListener(new ActionListener() {
                float currentOpacity = fadeIn ? 0 : 1f;

                @Override
                public void actionPerformed(ActionEvent e) {
                    currentOpacity += opacityTick;
                    w.setOpacity(fadeIn ? Math.min(currentOpacity, 1f) : Math.max(currentOpacity, 0f));
                    stopAnimation(currentOpacity);
                }
            });
            w.setOpacity(opacityStart);
            animation.start();
            if (fadeIn) {
                w.setVisible(true);
            }
        }

        /**
         * Detiene la animacion de aparición si se cumple la condicion
         *
         * @param currentOpacity
         */
        private void stopAnimation(float currentOpacity) {
            if (!nearToEnd(currentOpacity)) {
                return;
            }
            animation.stop();
            if (!fadeIn) {
                w.dispose();
            }

        }

        /**
         * Verifica si la opacidad actual esta cerca de la opacidad final
         * <br> 0 -> completamente invisible
         * <br> 1 -> completamente visible
         *
         * @param currentOpacity opacidad Actual
         * @return si esta cerca de la opacidad final
         */
        private boolean nearToEnd(float currentOpacity) {
            if (fadeIn) {
                return currentOpacity >= 1f;
            }
            return currentOpacity <= 0f;
        }

        /**
         * Comprueba si el componente ventana es instancia de
         * <br>Frame o Dialog
         * <br>Para comprobar si tiene la decoracion desactivada
         *
         * @param w
         */
        private void undecoratedException(final Window w) {
            final String message = "Undecorated window is required";
            if (w instanceof Frame) {
                if (!((Frame) w).isUndecorated()) {
                    throw new IllegalComponentStateException(message);
                }
            }
            if (w instanceof Dialog) {
                if (!((Dialog) w).isUndecorated()) {
                    throw new IllegalComponentStateException(message);
                }
            }
        }

        /**
         * Comprueba que la opacidad este dentro del rango de
         * <br> [0.1f ... 0.9f]
         *
         * @param opacityTick
         */
        private void illegalOpacityTick(float opacityTick) {
            if (opacityTick <= 0 || opacityTick >= 1) {
                throw new IllegalArgumentException("The value of opacity should be in the range [0.1f .. 0.9f].");
            }
        }

    }
}
