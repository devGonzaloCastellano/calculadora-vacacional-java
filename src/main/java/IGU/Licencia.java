package IGU;

import Util.Constantes;
import Util.Funciones;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

/**
 * Ventana de licencia del sistema de control vacacional.
 *
 * Muestra términos y condiciones que el usuario debe aceptar
 * antes de continuar a la pantalla principal.
 * Si el usuario no acepta, se redirige nuevamente a Bienvenida.
 */
public class Licencia extends VentanaBase implements ActionListener, ChangeListener{

    private JLabel titulo, logo;
    private JCheckBox check;
    private JButton btAceptar, btCancelar;
    private JScrollPane scroll;
    private JTextArea ventana;

    /** Nombre ingresado en la pantalla de Bienvenida, usado en el texto de aceptación. */
    String nombre = "";

    /**
     * Constructor de la clase Licencia.
     * Inicializa la interfaz con tamaño, título y componentes visuales.
     * Recupera el nombre ingresado desde la clase Bienvenida
     */
    public Licencia(){
        super(620,380,"Licencia de uso");
        nombre = Bienvenida.texto;
        inicializarComponentes();
    }

    /**
     * Inicializa y configura los componentes gráficos:
     * título, área de texto con términos, casilla de aceptación,
     * botones de navegación y el logo de Coca-Cola.
     */
    public void inicializarComponentes(){
        titulo = Funciones.crearLabel("TERMINOS Y CONDICIONES",
                175,5,250,30,
                Constantes.Fuentes.SUBTITULO,
                Constantes.Colores.NEGRO);
        add(titulo);

        ventana = new JTextArea();
        ventana.setEditable(false);
        ventana.setFont(Constantes.Fuentes.COMPONENTE);
        ventana.setText("\n\n          TÉRMINOS Y CONDICIONES" +
                "\n\n               A. PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN" +
                "\n               B. PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRAFICAS" +
                "\n               C. ESTO ES UN MODELO DE PRUEBA DE UNA LICENCIA DE TÉRMINOS Y CONDICIONES" +
                "\n               SI USTED NO ACEPTA ESTOS TÉRMINOS, HAGA CLICK EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE " +
                "\n\n               PARA MAYOR INFORMACIÓN SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE:" +
                "\n               https://www.coca-cola.com/ar/es");
        scroll = new JScrollPane(ventana);
        scroll.setBounds(10,40,575,200);
        add(scroll);

        check = new JCheckBox("Yo " + nombre + ", Acepto");
        check.setBounds(10,250,300,30);
        check.addChangeListener(this);
        add(check);

        btAceptar = new JButton("Continuar");
        btAceptar.setBounds(10,290,100,30);
        btAceptar.addActionListener(this);
        btAceptar.setEnabled(false);
        add(btAceptar);

        btCancelar = new JButton("No Acepto");
        btCancelar.setEnabled(true);
        btCancelar.setBounds(120,290,100,30);
        btCancelar.addActionListener(this);
        add(btCancelar);

        ImageIcon imagen = new ImageIcon(getClass().getResource("/img/coca-cola.png"));
        logo = new JLabel(imagen);
        logo.setBounds(315,135,300,300);
        add(logo);
    }

    /**
     * Puente entre interfaces de Pantalla de Bienvenida y Pantalla Principal
     * según el botón que sea presionado, enviará a la que corresponda.
     * @param e el evento cambia las interfaces según sean presionados los botones
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btAceptar){
            new Principal().setVisible(true);
            this.dispose();
        }
        if (e.getSource() == btCancelar) {
            new Bienvenida().setVisible(true);
            this.dispose();
        }
    }

    /**
     * Verifica el estado del checkBox y modifica la habilitación de botones
     * @param e  a ChangeEvent object verifica si se ejecuto un evento
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        boolean aceptado = check.isSelected();
        btAceptar.setEnabled(aceptado);
        btCancelar.setEnabled(!aceptado);
    }
}
