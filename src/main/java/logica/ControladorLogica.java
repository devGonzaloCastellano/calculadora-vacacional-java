package logica;


import persistencia.ControladorPersistencia;

/**
 * Clase que actúa como controlador de la lógica del sistema.
 * Sirve de puente entre la capa de lógica de negocio y la capa de persistencia.
 */
public class ControladorLogica {

    /**
     * Controlador de persistencia encargado de gestionar las operaciones
     * relacionadas con la base de datos.
     */
    public ControladorPersistencia controlPersis = new ControladorPersistencia();

    /**
     * Calcula los días de vacaciones correspondientes a un empleado,
     * según sus datos y reglas definidas en {@link CalculadoraVacaciones}.
     *
     * @param emp objeto {@link Empleado} con la información del empleado.
     * @return número de días de vacaciones que le corresponden.
     */
    public int calculadDiasVacaciones(Empleado emp){
        return CalculadoraVacaciones.calcularDias(emp);
    }

    /**
     * Guarda la información de un empleado en la base de datos.
     *
     * @param emp objeto {@link Empleado} a persistir.
     */
    public void guardarEmpleado(Empleado emp){
        controlPersis.guardarEmpleado(emp);
    }

}
