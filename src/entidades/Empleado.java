/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author charl
 */
public class Empleado implements Comparable<Empleado>{
    private String nombre;
    private int edad;
    private float sueldo;
    
    public Empleado() {
        nombre = "NN";
        edad = 0;
        sueldo = 0.0f;
    }
    
    public Empleado(String nombre, int edad, float sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }
    
    public float getSueldo() {
        return sueldo;
    }
    
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getTamaño() {
        return getNombre().length()*2 +4 + 4;
    }

    @Override
    public int compareTo(Empleado empleado) {
        return this.getNombre().compareToIgnoreCase(empleado.getNombre());
    }
}
