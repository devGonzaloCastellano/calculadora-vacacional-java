package logica;

/**
 * Clase que representa a un empleado dentro del sistema.
 * Contiene información personal y laboral básica.
 */
public class Empleado {

    /** Nombre del empleado */
    private String nombre;

    /** Apellido paterno del empleado */
    private String apellidoPaterno;

    /** Apellido materno del empleado */
    private String apellidoMaterno;

    /** Sector en el que trabaja el empleado (ej: "Logística", "Gerencia") */
    private String sector;

    /** Antigüedad del empleado (ej: "1 año de servicio", "2 a 6 años de servicio") */
    private String antiguedad;



    // Constructor
    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, String sector, String antiguedad) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sector = sector;
        this.antiguedad = antiguedad;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getSector() {
        return sector;
    }

    public String getAntiguedad() {
        return antiguedad;
    }
}
