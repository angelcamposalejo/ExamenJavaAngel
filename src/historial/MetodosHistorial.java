/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package historial;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import medicos.Medicos;
import pacientes.Paciente;

/**
 *
 * @author Dulcinea
 */
public class MetodosHistorial {
     public static String busquedaHistorial(ArrayList<Historial>lista,String dato,ArrayList<Paciente>paciente,ArrayList<Medicos>medico)
     {
         int contador=0;
         String resultado="";
         for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).getCodigo().equals(dato))
            {
                //resultado+=lista.get(i);
                String codigo=lista.get(i).getCodigo();
                int idPaciente=lista.get(i).getIdPaciente();
                String pacienteNombre="";
                for(int j=0;j<paciente.size();j++)
                {
                    if(paciente.get(j).getId()==idPaciente)
                    {
                         pacienteNombre+=paciente.get(j);
                    }
                }
                int idMedico=lista.get(i).getIdMedico();
                String medicoNombre="";
                for(int z=0;z<medico.size();z++)
                {
                   if(medico.get(z).getId()==idMedico)
                   {
                       medicoNombre+=medico.get(z);
                   }
                }
                String observaciones=lista.get(i).getObservaciones();
                resultado+="Historial\n\nCódigo: "+codigo+"\n\nPaciente:"+pacienteNombre+"\n\nMedico:"+medicoNombre+"\n\nObservaciones:"+observaciones;
                contador++;
    
            }
        }
         if(contador==0)
         {
             return "Historial no encontrado";
         }
         else
         {
            return resultado;
         }
        
     }
     public static int modificarHistorial(ArrayList<Historial>lista,String dato,ArrayList<Paciente>paciente,ArrayList<Medicos>medicos)
    {
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).getCodigo().equals(dato))
            {
                lista.get(i).setFecha(JOptionPane.showInputDialog("Teclea la nueva fecha"));
                int contadorPaciente=0;
                while(contadorPaciente==0)
                {
                    int idPaciente=Integer.parseInt(JOptionPane.showInputDialog("Teclea el nuevo id del paciente"));
                    for(int j=0;j<paciente.size();j++)
                    {
                        if(paciente.get(j).getId()==idPaciente)
                        {
                             //Actualizar el id del paciente
                            lista.get(i).setIdPaciente(idPaciente);
                            contadorPaciente++;
                        }
                        
                    
                    }
                }
                int contadorMedico=0;
                while(contadorMedico==0)
                {
                    int idMedico=Integer.parseInt(JOptionPane.showInputDialog("Teclea el nuevo id del médico"));
                    for(int z=0;z<medicos.size();z++)
                    {
                        if(medicos.get(z).getId()==idMedico)
                        {
                            lista.get(i).setIdMedico(idMedico);
                            contadorMedico++;
                        }
                    }
                }
                lista.get(i).setObservaciones(JOptionPane.showInputDialog("Teclea las nuevas observaciones:"));
                
                
                return 0;
            }
        }
        return -1;
    }
    public static int eliminarHistorial(ArrayList<Historial>lista,String dato)
    {
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).getCodigo().equals(dato))
            {
                lista.remove(i);
                return 0;
            }
        }
        return -1;
    } 
  
}
