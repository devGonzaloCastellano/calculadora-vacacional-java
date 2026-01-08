package IGU;

import javax.swing.*;

/**
 * Clase abstracta que sirve como base para todas las ventanas de la aplicación.
 * <p>
 * Define configuraciones comunes como tamaño, título, posición,
 * operación de cierre, ícono y layout. Esto permite que las
 * subclases hereden un comportamiento consistente y eviten duplicar código.
 * </p>
 */
public abstract class VentanaBase extends JFrame {

    /**
     * Constructor base para inicializar una ventana con configuraciones estándar.
     *
     * @param width  ancho de la ventana en píxeles.
     * @param height alto de la ventana en píxeles.
     * @param titulo título que se mostrará en la barra de la ventana.
     */
    public VentanaBase(int width, int height, String titulo){
        setTitle(titulo);
        setSize(width,height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
    }

}
