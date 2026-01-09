package persistencia;

import logica.Empleado;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase encargada de la persistencia de datos de empleados.
 * <p>
 * Actualmente utiliza un archivo de texto plano (empleados.txt)
 * para almacenar la información de cada empleado de manera secuencial.
 * Cada registro se guarda en una línea, con los campos separados por punto y coma (;).
 * </p>
 */
public class ControladorPersistencia {

    /** Ruta del archivo donde se guardan los empleados */
    private static final String RUTA = "empleados.txt";

    /**
     * Guarda un empleado en el archivo de texto.
     * <p>
     * El formato de almacenamiento es:
     * <pre>
     * nombre;apellidoPaterno;apellidoMaterno;sector;antiguedad
     * </pre>
     * </p>
     *
     * @param emp objeto {@link Empleado} que contiene los datos a persistir.
     */
    public void guardarEmpleado(Empleado emp) {

        try (FileWriter documento = new FileWriter(RUTA, true)){
            documento.write(emp.getNombre() + ";"+
                    emp.getApellidoPaterno() + ";" +
                    emp.getApellidoMaterno() + ";" +
                    emp.getSector() + ";" +
                    emp.getAntiguedad() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
