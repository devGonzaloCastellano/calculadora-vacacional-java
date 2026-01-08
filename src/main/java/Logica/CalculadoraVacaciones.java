package Logica;

/**
 * Clase utilitaria encargada de calcular la cantidad de días de vacaciones
 * que corresponden a un empleado en función de su sector y antigüedad.
 */
public class CalculadoraVacaciones {

    /**
     * Calcula los días de vacaciones correspondientes a un empleado
     * según su sector y años de servicio.
     *
     * <p><b>Reglas implementadas:</b></p>
     * <ul>
     *   <li><b>At. al cliente:</b>
     *       1 año → 6 días, 2-6 años → 14 días, 7+ años → 20 días.</li>
     *   <li><b>Logística:</b>
     *       1 año → 7 días, 2-6 años → 15 días, 7+ años → 22 días.</li>
     *   <li><b>Gerencia:</b>
     *       1 año → 10 días, 2-6 años → 20 días, 7+ años → 30 días.</li>
     * </ul>
     *
     * @param emp objeto {@link Empleado} con la información de sector y antigüedad.
     * @return número de días de vacaciones, o {@code 0} si no se cumple ninguna regla.
     */
    public static int calcularDias(Empleado emp){
        String sector = emp.getSector();
        String antiguedad = emp.getAntiguedad();

        if (sector.equals("At. al cliente")){
            if (antiguedad.equals("1 año de servicio")) return 6;
            if (antiguedad.equals("2 a 6 años de servicio")) return 14;
            if (antiguedad.equals("7 años o más de servicio")) return 20;
        }
        if (sector.equals("Logística")){
            if (antiguedad.equals("1 año de servicio")) return 7;
            if (antiguedad.equals("2 a 6 años de servicio")) return 15;
            if (antiguedad.equals("7 años o más de servicio")) return 22;
        }
        if (sector.equals("Gerencia")){
            if (antiguedad.equals("1 año de servicio")) return 10;
            if (antiguedad.equals("2 a 6 años de servicio")) return 20;
            if (antiguedad.equals("7 años o más de servicio")) return 30;
        }

        return 0;
    }
}
