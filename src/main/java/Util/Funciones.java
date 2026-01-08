package Util;

import javax.swing.*;
import java.awt.*;

public class Funciones {

    /**
     * Crea las Labels usadas en el software de manera generica
     * @param texto indica el texto presentado en pantalla
     * @param x Eje X
     * @param y Eje Y
     * @param w Ancho
     * @param h Alto
     * @param fuente Tipo de fuente
     * @param color Color
     * @return Devuelve un Label armado
     */
    public static JLabel crearLabel(String texto, int x, int y, int w, int h, Font fuente, Color color) {
        JLabel label = new JLabel(texto);
        label.setBounds(x, y, w, h);
        label.setFont(fuente);
        label.setForeground(color);
        return label;
    }
}
