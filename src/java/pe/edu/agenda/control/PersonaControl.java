/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.agenda.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.agenda.dao.PersonaDao;
import pe.edu.agenda.to.PersonaTo;

/**
 *
 * @author hikaru
 */
public class PersonaControl extends HttpServlet{
    private static final String CREATE_OR_EDIT = "/form_persona.jsp";
    private static final String LIST_PERS = "/lista_persona.jsp";
    private final PersonaDao dao;
    PersonaTo to;

    public PersonaControl() {
        super();
        dao = new PersonaDao();
    }
    
    @Override
   protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
       String forward="";
       String action = request.getParameter("action");
       
       if (action.equalsIgnoreCase("delete")) {
           String id = request.getParameter("id");
           dao.eliminarPersona(Integer.parseInt(id));
           forward = LIST_PERS;
           request.setAttribute("personas", dao.listarPersona());
       }else if(action.equalsIgnoreCase("edit")){
           forward = CREATE_OR_EDIT;
           int id = Integer.parseInt(request.getParameter("id"));
           PersonaTo per = dao.buscarPersona(id);
           System.out.println("Buscando persona");
           request.setAttribute("persona", per);
       }else if (action.equalsIgnoreCase("listper")) {
           forward = LIST_PERS;
           request.setAttribute("personas", dao.listarPersona());
       }else{
           forward = CREATE_OR_EDIT;
       }
       
       RequestDispatcher view = request.getRequestDispatcher(forward);
       view.forward(request, response);
   }
   
    @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        to = new PersonaTo();
        to.setNombres(request.getParameter("nombres"));
        to.setApellidos(request.getParameter("apellidos"));
        to.setCelular(request.getParameter("celular"));
        to.setDni(request.getParameter("dni"));
        
        String per = request.getParameter("id");
        if (per==null || per.isEmpty()) {
            dao.crearPersona(to);
        }else{
        to.setId_persona(Integer.parseInt(per));
        dao.actualizarPersona(to);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_PERS);
        request.setAttribute("personas", dao.listarPersona());
        view.forward(request, response);
    }
        
}
