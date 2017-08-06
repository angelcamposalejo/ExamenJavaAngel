/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import historial.Historial;
import historial.MetodosHistorial;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import medicos.Medicos;
import medicos.MetodosMedicos;
import pacientes.MetodosPacientes;
import pacientes.Paciente;

/**
 *
 * @author Dulcinea
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Paciente> paciente=new ArrayList<>();
        ArrayList<Medicos> medico=new ArrayList<>();
        ArrayList<Historial>historial=new ArrayList<>();
        MetodosPacientes pacientesObj=new MetodosPacientes();
        MetodosMedicos medicosObj=new MetodosMedicos();
        MetodosHistorial historialObj=new MetodosHistorial();
        int opcion=0;
        do
        {
            opcion=Integer.parseInt(JOptionPane.showInputDialog("Teclea la operación que desea realziar:\n1.Gestionar Pacientes."
                + "\n2.Gestionar Medicos.\n3.Gestionar Historial Clinico.\n4.Salir."));
        switch(opcion)
        {
            case 1:
                //Gestionar Pacientes
                int opcionPaciente=Integer.parseInt(JOptionPane.showInputDialog("Teclea la operación que desea realziar con el paciente:"
                        + "\n1.Registrar."
                + "\n2.Consultar.\n3.Modificar\n4Eliminar."));
                switch(opcionPaciente)
                {
                    case 1:
                        //Registrar
                        int id=Integer.parseInt(JOptionPane.showInputDialog("Identificador del paciente:"));
                        String nombre=JOptionPane.showInputDialog("Nombre del paciente:");
                        String apellido=JOptionPane.showInputDialog("Apellido del paciente:");
                        int edad=Integer.parseInt(JOptionPane.showInputDialog("Edad del paciente:"));
                        String genero=JOptionPane.showInputDialog("Genero del paciente:");
                        paciente.add(new Paciente(id,nombre,apellido,edad,genero));
                        break;
                    case 2:
                        //Consultar
                        int opcionBusqueda=Integer.parseInt(JOptionPane.showInputDialog("Teclea la opción de busqueda deseada.\n"
                                + "1. Por Id\n2.Por Nombre"));
                        switch(opcionBusqueda)
                        {
                            case 1:
                                int idPaciente=Integer.parseInt(JOptionPane.showInputDialog("Teclea el id de paciente que desea bucar"));
                                JOptionPane.showMessageDialog(null,pacientesObj.busquedaPaciente(paciente,idPaciente));
                                break;
                            case 2:
                                String nombrePaciente=JOptionPane.showInputDialog("Teclea el nombre del paciente que desea buscar");
                                JOptionPane.showMessageDialog(null,pacientesObj.busquedaPaciente(paciente,nombrePaciente));
                                break;
                        }
                        break;
                    case 3:
                        //Modificar
                        int idPaciente=Integer.parseInt(JOptionPane.showInputDialog("Teclea el id del paciente que desea modificar"));
                        int resultadoBusqueda=pacientesObj.modificarPaciente(paciente,idPaciente);
                        if(resultadoBusqueda==-1)
                        {
                            JOptionPane.showMessageDialog(null,"Paciente no encontrado");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,pacientesObj.busquedaPaciente(paciente,idPaciente));
                        }
                        break;
                    case 4:
                        //Eliminar
                         idPaciente=Integer.parseInt(JOptionPane.showInputDialog("Teclea el id del paciente que desea eliminar"));
                         resultadoBusqueda=pacientesObj.eliminarPaciente(paciente,idPaciente);
                        if(resultadoBusqueda==-1)
                        {
                            JOptionPane.showMessageDialog(null,"Paciente no encontrado");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Paciente con el id"+idPaciente+" eliminado correctamente");
                        }
                        break;
                }
                break;
            case 2:
                //Gestionar Medicos
                int opcionMedicos=Integer.parseInt(JOptionPane.showInputDialog("Teclea la operación que desea realziar con el médico:"
                        + "\n1.Registrar."
                + "\n2.Consultar.\n3.Modificar\n4Eliminar."));
                switch(opcionMedicos)
                {
                    case 1:
                        //Registrar
                        int id=Integer.parseInt(JOptionPane.showInputDialog("Identificador del médico:"));
                        String nombre=JOptionPane.showInputDialog("Nombre del médico:");
                        String apellido=JOptionPane.showInputDialog("Apellido del médico:");
                        String especialidad=JOptionPane.showInputDialog("Especialidad del médico:");
                        medico.add(new Medicos(id,nombre,apellido,especialidad));
                        break;
                    case 2:
                        //Consultar
                        int opcionBusqueda=Integer.parseInt(JOptionPane.showInputDialog("Teclea la opción de busqueda deseada.\n"
                                + "1. Por Id\n2.Por Nombre"));
                        switch(opcionBusqueda)
                        {
                            case 1:
                                int idMedico=Integer.parseInt(JOptionPane.showInputDialog("Teclea el id de médico que desea bucar"));
                                JOptionPane.showMessageDialog(null,medicosObj.busquedaMedicos(medico,idMedico));
                                break;
                            case 2:
                                String nombreMedico=JOptionPane.showInputDialog("Teclea el nombre del médico que desea buscar");
                                JOptionPane.showMessageDialog(null,medicosObj.busquedaMedicos(medico,nombreMedico));
                                break;
                        }
                        break;
                    case 3:
                        //Modificar
                        int idMedico=Integer.parseInt(JOptionPane.showInputDialog("Teclea el id del médico que desea modificar"));
                        int resultadoBusqueda=medicosObj.modificarMedico(medico,idMedico);
                        if(resultadoBusqueda==-1)
                        {
                            JOptionPane.showMessageDialog(null,"Médico no encontrado");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,medicosObj.busquedaMedicos(medico,idMedico));
                        }
                        break;
                    case 4:
                        //Eliminar
                         idMedico=Integer.parseInt(JOptionPane.showInputDialog("Teclea el id del médico que desea eliminar"));
                         resultadoBusqueda=medicosObj.eliminarMedico(medico,idMedico);
                        if(resultadoBusqueda==-1)
                        {
                            JOptionPane.showMessageDialog(null,"Médico no encontrado");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Médico con el id"+idMedico+" eliminado correctamente");
                        }
                        break;
                }
                break;
            case 3:
                //Gestionar historial medico
                int opcionHistorial=Integer.parseInt(JOptionPane.showInputDialog("Teclea la operación que desea realziar con el historial:"
                        + "\n1.Registrar."
                + "\n2.Consultar.\n3.Modificar\n4Eliminar."));
                switch(opcionHistorial)
                {
                    case 1:
                        //Registrar
                        String codigo=JOptionPane.showInputDialog("Código del historial");
                        String fecha=JOptionPane.showInputDialog("Fecha:");
                        int idPaciente=Integer.parseInt(JOptionPane.showInputDialog("Id del paciente:"));
                        JOptionPane.showMessageDialog(null,pacientesObj.busquedaPaciente(paciente,idPaciente));
                        if(pacientesObj.busquedaPaciente(paciente,idPaciente).equals("Paciente no encontrado"))
                        {
                            break;
                        }
                        int idMedico=Integer.parseInt(JOptionPane.showInputDialog("Id del médico:"));
                        JOptionPane.showMessageDialog(null,medicosObj.busquedaMedicos(medico,idMedico));
                        if(medicosObj.busquedaMedicos(medico,idMedico).equals("Paciente no encontrado"))
                        {
                            break;
                        }
                        String observaciones=JOptionPane.showInputDialog("Observaciones:");
                        historial.add(new Historial(codigo,fecha,idPaciente,idMedico,observaciones));
                        break;
                    case 2:
                        //Consultar
                        codigo=JOptionPane.showInputDialog("Codigo del historial");
                        JOptionPane.showMessageDialog(null,historialObj.busquedaHistorial(historial,codigo,paciente,medico));
                        break;
                    case 3:
                        //Modificar
                        codigo=JOptionPane.showInputDialog("Teclea el id del código que desea modificar");
                        int resultadoBusqueda=historialObj.modificarHistorial(historial,codigo,paciente,medico);
                        if(resultadoBusqueda==-1)
                        {
                            JOptionPane.showMessageDialog(null,"Código no encontrado");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,historialObj.busquedaHistorial(historial,codigo,paciente,medico));
                        }
                        break;
                    case 4:
                        //Eliminar
                         codigo=JOptionPane.showInputDialog("Teclea el código del historial que desea eliminar");
                         resultadoBusqueda=historialObj.eliminarHistorial(historial,codigo);
                        if(resultadoBusqueda==-1)
                        {
                            JOptionPane.showMessageDialog(null,"Código no encontrado");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Historial con el código"+codigo+" eliminado correctamente");
                        }
                        break;
                }
                break;
            case 4:
                //salir
                JOptionPane.showMessageDialog(null,"Gracias vuelva pronto!!!" );
                System.exit(0);
        }
        }while(opcion!=4);
    }
     
}