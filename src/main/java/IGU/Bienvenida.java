package IGU;

import Util.Constantes;
import Util.Funciones;

import javax.swing.*;
import java.awt.event.*;

/**
 * Ventana inicial del sistema de control vacacional.
 *
 * Permite al usuario ingresar su nombre, que será utilizado
 * en las siguientes pantallas (ej: licencia, principal).
 */
public class Bienvenida extends VentanaBase implements ActionListener{

    //Componentes
    private JTextField casilla;
    private JLabel logo, titulo, nombre,footer;
    private JButton ingresar;

    /**
     * Nombre ingresado por el usuario en la pantalla de bienvenida.
     * Se usa en otras pantallas como referencia global.
     */
    public static String texto = "";

    /**
     * Constructor de la clase Bienvenida.
     * Inicializa la interfaz con tamaño, título, colores y componentes visuales.
     */
    public Bienvenida(){
        super(350,450,"Bienvenido");
        getContentPane().setBackground(Constantes.Colores.ROJO);
        inicializarComponentes();
    }

    /**
     *
     * Método que inicializa todos los componentes de la interfaz:
     * campo de texto, labels, y un botón.
     */
    public void inicializarComponentes(){
        ImageIcon imagen = new ImageIcon(getClass().getResource("/img/logo-coca.png"));
        logo = new JLabel(imagen);
        logo.setBounds(25,15,300,150);
        add(logo);

        titulo = Funciones.crearLabel("Control Vacacional",
                60,135,300,30,
                Constantes.Fuentes.TITULO,
                Constantes.Colores.BLANCO);
        add(titulo);

        nombre = Funciones.crearLabel("Ingrese su nombre:",
                45,212,200,30,
                Constantes.Fuentes.TEXTO,
                Constantes.Colores.BLANCO);
        add(nombre);

        footer = Funciones.crearLabel("© 2025 The Coca-Cola Company",
            55,375,300,30,
            Constantes.Fuentes.TEXTO,
            Constantes.Colores.BLANCO);
        add(footer);

        casilla = new JTextField();
        casilla.setBounds(45,240,255,25);
        casilla.setBackground(Constantes.Colores.GRIS);
        casilla.setFont(Constantes.Fuentes.COMPONENTE);
        casilla.setForeground(Constantes.Colores.ROJO);
        add(casilla);

        ingresar = new JButton("Ingresar");
        ingresar.setBounds(125,280,100,30);
        ingresar.setBackground(Constantes.Colores.GRIS);
        ingresar.setFont(Constantes.Fuentes.COMPONENTE);
        ingresar.setForeground(Constantes.Colores.ROJO);
        ingresar.addActionListener(this);
        add(ingresar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Si el usuario presiona el botón ingresar, válida el nombre y pasa a Pantalla Licencia
        if (e.getSource() == ingresar){
            texto = casilla.getText().trim();
            if (texto.equals("")){
                JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre.");
            }else{
                new Licencia().setVisible(true);
                this.dispose();
            }
        }

    }
}
