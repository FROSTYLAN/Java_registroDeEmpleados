/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Comparator;

/**
 *
 * @author charl
 */
public class CompararEmpleadoPorEdad implements Comparator<Empleado>{

    @Override
    public int compare(Empleado empleado1, Empleado empleado2) {
        return empleado1.getEdad() - empleado2.getEdad();
    }
    
}
