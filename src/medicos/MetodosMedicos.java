/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dulcinea
 */
public class MetodosMedicos {
    public static String busquedaMedicos(ArrayList<Medicos>lista,int dato)
     {
         String resultado="";
         int contador=0;
         for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).getId()==dato)
            {
                resultado+=lista.get(i);
                contador++;
            }
        }
        if(contador>0)
        {
            return resultado;
        }
        else
        {
            return "Médico no encontrado";
        }
        
     }
    public static String busquedaMedicos(ArrayList<Medicos>lista,String dato)
     {
         String resultado="";
         int contador=0;
         for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).getNombre().equals(dato))
            {
                resultado+=lista.get(i);
                contador++;
            }
        }
        if(contador>0)
        {
            return resultado;
        }
        else
        {
            return "Médico no encontrado";
        }
     }
    public static int modificarMedico(ArrayList<Medicos>lista,int dato)
    {
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).getId()==dato)
            {
                lista.get(i).setNombre(JOptionPane.showInputDialog("Teclea el nuevo nombre del médico"));
                lista.get(i).setApellidos(JOptionPane.showInputDialog("Teclea el nuevo apellido del médico"));
                lista.get(i).setEspecialidad(JOptionPane.showInputDialog("Teclea la nueva especialidad del médico"));
                return 0;
            }
        }
        return -1;
    }
    public static int eliminarMedico(ArrayList<Medicos>lista,int dato)
    {
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).getId()==dato)
            {
                lista.remove(i);
                return 0;
            }
        }
        return -1;
    }
}
