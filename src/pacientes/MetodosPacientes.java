/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacientes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel
 */
public class MetodosPacientes {
    public static String busquedaPaciente(ArrayList<Paciente>lista,int dato)
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
            return "Paciente no encontrado";
        }
        
     }
    public static String busquedaPaciente(ArrayList<Paciente>lista,String dato)
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
            return "Paciente no encontrado";
        }
     }
    public static int modificarPaciente(ArrayList<Paciente>lista,int dato)
    {
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).getId()==dato)
            {
                lista.get(i).setNombre(JOptionPane.showInputDialog("Teclea el nuevo nombre del paciente"));
                lista.get(i).setApellidos(JOptionPane.showInputDialog("Teclea el nuevo apellido del paciente"));
                lista.get(i).setEdad(Integer.parseInt(JOptionPane.showInputDialog("Teclea la nueva edad del paciente")));
                return 0;
            }
        }
        return -1;
    }
    public static int eliminarPaciente(ArrayList<Paciente>lista,int dato)
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
