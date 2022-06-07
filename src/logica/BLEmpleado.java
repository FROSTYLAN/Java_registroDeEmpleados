/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.DALEmpleado;
import entidades.Empleado;
import java.util.List;

/**
 *
 * @author charl
 */
public class BLEmpleado {
    
     public static String escribirEmpleado(String nombre, int edad, float sueldo) {
        String mensaje = null;
        Empleado empleado = null;
        if(nombre.trim().length()>0 && edad>=18 && sueldo>=1050.0f) {
            empleado = new Empleado(nombre, edad, sueldo);
            mensaje = DALEmpleado.escribirEmpleado(empleado);
        }
        return mensaje;
    }
    
    public static String setEmpleado(int posicion, String nombre, int edad, float sueldo) {
        String mensaje = null;
        Empleado empleado = null;
        if(posicion>=0 && posicion<=DALEmpleado.getNumeroRegistros()) {
            if(nombre.trim().length()>0 && edad>=18 && sueldo>=1050.0f) {
                empleado = new Empleado(nombre, edad, sueldo);
                mensaje = DALEmpleado.setEmpleado(posicion, empleado);
            } else
                mensaje = "Datos no válidos";
        } else
            mensaje = "Número de registro no es válido";
        return mensaje;
    }
    
    public static Empleado getEmpleado(int pos) {
        Empleado empleado = null;
        if(pos>=0 && pos<DALEmpleado.getNumeroRegistros()) {
            empleado = DALEmpleado.getEmpleado(pos);
        }
        return empleado;
    }
    
    public static List<Empleado> getContenido() {
        if(DALEmpleado.getNumeroRegistros()>0)
            return DALEmpleado.getContenido();
        return null;
    }
    
    public static int getNumeroRegistros() {
        return DALEmpleado.getNumeroRegistros();
    }   
    
}
