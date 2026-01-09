package igu;

import logica.ControladorLogica;
import logica.Empleado;
import util.Constantes;
import util.Funciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase Principal
 * Esta clase representa la interfaz principal de la aplicación donde se ingresan
 * los datos del trabajador y se calcula la cantidad de días de vacaciones.
 * Contiene menús, botones y campos de texto para interacción del usuario.
 *
 * Hereda de {@link VentanaBase} y maneja eventos a través de {@link ActionListener}.
 */
public class Principal extends VentanaBase implements ActionListener {

    private JMenuBar mb;
    private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuColorFondo;
    private JMenuItem miCalculo, miRojo, miNegro, miVioleta, miCreador, miSalir, miNuevo;
    private JLabel logo, bienvenido, titulo, nombre, APaterno, AMaterno, sector, antiguedad, resultado, footer;
    private JTextField txtNombreTrabajador, txtAPaterno, txtAMaterno;
    private JComboBox cbSector, cbAntiguedad;
    private JScrollPane scroll;
    private JTextArea txtArea;
    private JButton btCalculo;

    String nombrePpal = "";
    private static final String TEXTO_RESULTADO_DEFECTO =
            "\n Aquí aparece el resultado del cálculo de las vacaciones";


    /**
     * Constructor de la clase Principal.
     * Inicializa la interfaz con tamaño, título, colores y componentes visuales.
     */
    public Principal() {
        super(650, 555, "Pantalla Principal");
        getContentPane().setBackground(new Color(255, 0, 0));
        nombrePpal = Bienvenida.texto;
        inicializarComponentes();
    }

    /**
     * Método que inicializa todos los componentes de la interfaz:
     * campos de texto, comboBox, labels, botones, scrolls y menú.
     */
    public void inicializarComponentes() {
        //Barra de Menú
        mb = new JMenuBar();
        mb.setBackground(Constantes.Colores.ROJO);
        setJMenuBar(mb);

        menuOpciones = new JMenu("Opciones");
        menuOpciones.setBackground(Constantes.Colores.ROJO);
        menuOpciones.setFont(Constantes.Fuentes.TEXTO);
        menuOpciones.setForeground(Constantes.Colores.BLANCO);
        mb.add(menuOpciones);

        menuCalcular = new JMenu("Calcular");
        menuCalcular.setBackground(Constantes.Colores.ROJO);
        menuCalcular.setFont(Constantes.Fuentes.TEXTO);
        menuCalcular.setForeground(Constantes.Colores.BLANCO);
        mb.add(menuCalcular);

        menuAcercaDe = new JMenu("Acerca De");
        menuAcercaDe.setBackground(Constantes.Colores.ROJO);
        menuAcercaDe.setFont(Constantes.Fuentes.TEXTO);
        menuAcercaDe.setForeground(Constantes.Colores.BLANCO);
        mb.add(menuAcercaDe);

        menuColorFondo = new JMenu("Color de Fondo");
        menuColorFondo.setFont(Constantes.Fuentes.TEXTO);
        menuColorFondo.setForeground(Constantes.Colores.ROJO);
        menuOpciones.add(menuColorFondo);

        miCalculo = new JMenuItem("Calculo");
        miCalculo.setFont(Constantes.Fuentes.TEXTO);
        miCalculo.setForeground(Constantes.Colores.ROJO);
        menuCalcular.add(miCalculo);
        miCalculo.addActionListener(this);

        miRojo = new JMenuItem("Rojo");
        miRojo.setFont(Constantes.Fuentes.TEXTO);
        miRojo.setForeground(Constantes.Colores.ROJO);
        menuColorFondo.add(miRojo);
        miRojo.addActionListener(this);

        miNegro = new JMenuItem("Negro");
        miNegro.setFont(Constantes.Fuentes.TEXTO);
        miNegro.setForeground(Constantes.Colores.ROJO);
        menuColorFondo.add(miNegro);
        miNegro.addActionListener(this);

        miVioleta = new JMenuItem("Violeta");
        miVioleta.setFont(Constantes.Fuentes.TEXTO);
        miVioleta.setForeground(Constantes.Colores.ROJO);
        menuColorFondo.add(miVioleta);
        miVioleta.addActionListener(this);

        miNuevo = new JMenuItem("Nuevo");
        miNuevo.setFont(Constantes.Fuentes.TEXTO);
        miNuevo.setForeground(Constantes.Colores.ROJO);
        menuOpciones.add(miNuevo);
        miNuevo.addActionListener(this);

        miCreador = new JMenuItem("Creador");
        miCreador.setFont(Constantes.Fuentes.TEXTO);
        miCreador.setForeground(Constantes.Colores.ROJO);
        menuAcercaDe.add(miCreador);
        miCreador.addActionListener(this);

        miSalir = new JMenuItem("Salir");
        miSalir.setFont(Constantes.Fuentes.TEXTO);
        miSalir.setForeground(Constantes.Colores.ROJO);
        menuOpciones.add(miSalir);
        miSalir.addActionListener(this);


        //Formulario
        ImageIcon imagen = new ImageIcon("src/main/resources/img/logo-coca.png");
        logo = new JLabel(imagen);
        logo.setBounds(5, 5, 250, 100);
        add(logo);

        bienvenido = Funciones.crearLabel("Bienvenido " + nombrePpal,
            280, 30, 350, 50,
            Constantes.Fuentes.TITULO,
            Constantes.Colores.BLANCO);
        add(bienvenido);

        titulo = Funciones.crearLabel("Datos del trabajador para el cálculo de vacaciones",
            25, 140, 900, 25,
            Constantes.Fuentes.TITULO,
            Constantes.Colores.BLANCO);
        add(titulo);

        nombre = Funciones.crearLabel("Nombres",
            25, 188, 180, 25,
            Constantes.Fuentes.TEXTO,
            Constantes.Colores.BLANCO);
        add(nombre);

        txtNombreTrabajador = new JTextField();
        txtNombreTrabajador.setBounds(25, 213, 150, 25);
        txtNombreTrabajador.setBackground(Constantes.Colores.GRIS);
        txtNombreTrabajador.setFont(Constantes.Fuentes.COMPONENTE);
        txtNombreTrabajador.setForeground(Constantes.Colores.ROJO);
        add(txtNombreTrabajador);

        APaterno = Funciones.crearLabel("Apellido Paterno",
            25, 248, 180, 25,
            Constantes.Fuentes.TEXTO,
            Constantes.Colores.BLANCO);
        add(APaterno);

        txtAPaterno = new JTextField();
        txtAPaterno.setBounds(25, 273, 150, 25);
        txtAPaterno.setBackground(Constantes.Colores.GRIS);
        txtAPaterno.setFont(Constantes.Fuentes.COMPONENTE);
        txtAPaterno.setForeground(Constantes.Colores.ROJO);
        add(txtAPaterno);

        AMaterno = Funciones.crearLabel("Apellido Materno",
            25, 308, 180, 25,
            Constantes.Fuentes.TEXTO,
            Constantes.Colores.BLANCO);
        add(AMaterno);

        txtAMaterno = new JTextField();
        txtAMaterno.setBounds(25, 334, 150, 25);
        txtAMaterno.setBackground(Constantes.Colores.GRIS);
        txtAMaterno.setFont(Constantes.Fuentes.COMPONENTE);
        txtAMaterno.setForeground(Constantes.Colores.ROJO);
        add(txtAMaterno);

        btCalculo = new JButton("Calcular");
        btCalculo.setBounds(25, 390, 150, 30);
        btCalculo.setBackground(Constantes.Colores.GRIS);
        btCalculo.setFont(Constantes.Fuentes.COMPONENTE);
        btCalculo.setForeground(Constantes.Colores.ROJO);
        btCalculo.addActionListener(this);
        add(btCalculo);

        sector = Funciones.crearLabel("Sector",
            220, 188, 180, 25,
            Constantes.Fuentes.TEXTO,
            Constantes.Colores.BLANCO);
        add(sector);

        cbSector = new JComboBox();
        cbSector.setBounds(220, 213, 150, 25);
        cbSector.setBackground(Constantes.Colores.GRIS);
        cbSector.setFont(Constantes.Fuentes.COMPONENTE);
        cbSector.setForeground(Constantes.Colores.ROJO);
        add(cbSector);
        cbSector.addItem("");
        cbSector.addItem("At. al cliente");
        cbSector.addItem("Logística");
        cbSector.addItem("Gerencia");

        antiguedad = Funciones.crearLabel("Antigüedad",
            220, 248, 180, 25,
            Constantes.Fuentes.TEXTO,
            Constantes.Colores.BLANCO);
        add(antiguedad);

        cbAntiguedad = new JComboBox<String>();
        cbAntiguedad.setBounds(220, 273, 150, 25);
        cbAntiguedad.setBackground(Constantes.Colores.GRIS);
        cbAntiguedad.setFont(Constantes.Fuentes.COMPONENTE);
        cbAntiguedad.setForeground(Constantes.Colores.ROJO);
        add(cbAntiguedad);
        cbAntiguedad.addItem("");
        cbAntiguedad.addItem("1 año de servicio");
        cbAntiguedad.addItem("2 a 6 años de servicio");
        cbAntiguedad.addItem("7 años o más de servicio");

        resultado = Funciones.crearLabel("Resultado",
            220, 307, 180, 25,
            Constantes.Fuentes.TEXTO,
            Constantes.Colores.BLANCO);
        add(resultado);

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setBackground(Constantes.Colores.GRIS);
        txtArea.setFont(Constantes.Fuentes.COMPONENTE);
        txtArea.setForeground(Constantes.Colores.ROJO);
        txtArea.setText(TEXTO_RESULTADO_DEFECTO);
        scroll = new JScrollPane(txtArea);
        scroll.setBounds(220, 333, 385, 90);
        add(scroll);

        footer = Funciones.crearLabel("©2025 The Coca-Cola Company | Todos los derechos reservados",
            100, 445, 500, 30,
            Constantes.Fuentes.TEXTO,
            Constantes.Colores.BLANCO);
        add(footer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == miCalculo || e.getSource() == btCalculo) {
            realizarCalculo();
        }

        if (e.getSource() == miRojo) {
            cambiarColorFondo(Constantes.Colores.ROJO);
        }

        if (e.getSource() == miNegro) {
            cambiarColorFondo(Constantes.Colores.NEGRO);
        }

        if (e.getSource() == miVioleta) {
            cambiarColorFondo(Constantes.Colores.VIOLETA);
        }

        if (e.getSource() == miNuevo) {
            limpiarCampos();
        }

        if (e.getSource() == miSalir) {
            new Bienvenida().setVisible(true);
            this.dispose();
        }

        if (e.getSource() == miCreador) {
            JOptionPane.showMessageDialog(null, "Desarrollado por Dev Gonzalo Castellano \n " +
                    "                  Version 2.0 \n" +
                    "         Fecha de creación : 23/8/25");

        }

    }

    /**
     * Detecta si hay algún campo vacío en la interfaz
     * * @param campos Array de String con los valores de cada campo a revisar
     * @return true si hay al menos un campo vacío, false si todos están completos
     */
    private boolean hayCamposVacios(String... campos) {
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cambia el color de fondo de la pantalla principal
     * @param color Color a ingresar en la pantalla principal
     */
    private void cambiarColorFondo(Color color) {
        getContentPane().setBackground(color);
    }

    /**
     * Realiza el cálculo de días de vacaciones del trabajador ingresado,
     * mostrando el resultado en la interfaz y guardando los datos en un archivo.
     */
    private void realizarCalculo() {
        String nombreTrabajador = txtNombreTrabajador.getText();
        String AP = txtAPaterno.getText();
        String AM = txtAMaterno.getText();
        String Sector = cbSector.getSelectedItem().toString();
        String Antiguedad = cbAntiguedad.getSelectedItem().toString();

        Empleado emp = new Empleado(nombreTrabajador, AP, AM, Sector, Antiguedad);
        ControladorLogica control = new ControladorLogica();
        int dias = control.calculadDiasVacaciones(emp);

        //Mostrar Resultado
        if (hayCamposVacios(nombreTrabajador, AM, AP, Sector, Antiguedad)) {
            JOptionPane.showMessageDialog(null, "Debes completar los campos");
        } else {
            txtArea.setText("\n El trabajador " + emp.getNombre() + " " + emp.getApellidoPaterno() + " " + emp.getApellidoMaterno() +
                    "\n quien trabaja en " + emp.getSector() + " con " + emp.getAntiguedad() +
                    "\n recibe " + dias + " días de vacaciones");
            control.guardarEmpleado(emp);
        }
    }

    /**
     * Limpia todos los campos de la interfaz, dejando los valores por defecto.
     */
    private void limpiarCampos() {
        txtNombreTrabajador.setText("");
        txtAMaterno.setText("");
        txtAPaterno.setText("");
        cbSector.setSelectedIndex(0);
        cbAntiguedad.setSelectedIndex(0);
        txtArea.setText(TEXTO_RESULTADO_DEFECTO);
    }
}
