/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.*;
import java.util.*;
import java.io.*;

/**
 * DAL: Data Access Layer
 * @author charl
 */
public class DALEmpleado {
    private static RandomAccessFile flujo;
    private static final int TAMREG = 120;
    private static int numRegistros;
    private static final String N_ARCHIVO = "empleado.txt";
    
    private static String crearArchivo() {
        try{
            flujo = new RandomAccessFile(N_ARCHIVO, "rw");
            numRegistros = (int)Math.ceil((double)flujo.length() / (double)TAMREG);
        } catch (IOException ex) {
            return "Problema al crear el flujo: " + ex.getMessage();
        }
        return null;
    }
    
    public static String escribirEmpleado(Empleado empleado) {
        String mensaje = "";
        try {
            crearArchivo();
            flujo.close();
            mensaje = setEmpleado(numRegistros, empleado);
            if(mensaje.compareTo("ok")==0)
                numRegistros++;
        } catch (IOException ex) {
            mensaje = "Excepción: " + ex.getMessage();
        } finally {
            return mensaje;
        }
    }
    
    public static String setEmpleado(int posicion, Empleado empleado) {
        String mensaje = "";
        try {
            if(empleado.getTamaño()+2 > TAMREG)
                mensaje = "Tamaño de registro es insuficiente";
            else
                crearArchivo();
                flujo.seek(posicion * TAMREG);
                flujo.writeUTF(empleado.getNombre());
                flujo.writeInt(empleado.getEdad());
                flujo.writeFloat(empleado.getSueldo());
                mensaje = "ok";      
        } catch (IOException ex) {
            mensaje = "Excepción: " + ex.getMessage();
        } finally {
            try {
                flujo.close();
            } catch(IOException ex) {
                mensaje = "El flujo ya estaba cerrado: " + ex.getMessage();
            }
        }
        return mensaje;
    }

    public static Empleado getEmpleado(int pos) {
        String nombre;
        int edad;
        float sueldo;
        Empleado empleado = null;
    
        try {
            crearArchivo();
            flujo.seek(pos * TAMREG);
            nombre = flujo.readUTF();
            edad = flujo.readInt();
            sueldo = flujo.readFloat();
            empleado = new Empleado(nombre, edad, sueldo);
        } catch (IOException ex) {
            System.out.println("Problema de E/S: " + ex.getMessage());
        } finally {
            try {
                flujo.close();
            } catch (IOException ex) {
                System.out.println("El flujo ya estaba cerrado: " + ex.getMessage());
            }
        }
        return empleado;
    }
    
    public static List<Empleado> getContenido() {
        List<Empleado> lista = new ArrayList<>();
        
        try {
            crearArchivo();
            flujo.close();
            for(int i = 0; i<numRegistros; i++)
                lista.add(getEmpleado(i));
        } catch (IOException ex) {
            System.out.println("Problema de E/S: " + ex.getMessage());
        }
        return lista;
    }
    
    public static int getNumeroRegistros() {
        int numeroRegistros = -1;
        
        try {
            crearArchivo();
            numeroRegistros = numRegistros;
            flujo.close();
        } catch (IOException ex) {
            System.out.println("Problema de E/S: " + ex.getMessage());
        } finally {
            return numeroRegistros;
        }
    }
}

    