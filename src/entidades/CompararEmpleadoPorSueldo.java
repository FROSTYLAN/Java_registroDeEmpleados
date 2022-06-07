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
public class CompararEmpleadoPorSueldo implements Comparator<Empleado>{

    @Override
    public int compare(Empleado empleado1, Empleado empleado2) {
        float resultado;
        resultado = empleado1.getSueldo() - empleado2.getSueldo();
        
        if(resultado == 0.0000000f)
            return 0;
        else
            if(resultado < 0.0000000f)
                return -1;
            else
                return 1;
    }
    
}
