/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexion.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luisa
 */
@WebServlet(name = "Guardar", urlPatterns = {"/Guardar"})
public class Guardar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            //LOGICA PARA INSERTAR EN LA ABSE DE DATOS
            
            //GUARDAMOS LOS DATOS ENVIADOS POR EL FORMULARIO EN VARIABLES
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String direccion = request.getParameter("direccion");
            
            //INVOCAMOS LA CONEXION
            //CREAMOS UNA VARIABLE DE TIPO Persona LA CUAL MANEJA LA CONEXION
            Persona persona = new Persona();
            
            //EMPEZAMOS A ENVIAR OS DATOS A NUESTRO OBJETO PERSONA
            persona.setNombres(nombres);
            persona.setApellidos(apellidos);
            persona.setDireccion(direccion);
            
            //LA CLASE ENTIDAD LO QUE HACE EES CREARNOS LOS METODO PARA ENVIAR
            //LA INFORMACION A NUESTRO OBJETO 
            
            //CREAMOS UNA VARIABLE EntityManager QUE NOS AYUDARA A MANEJAR LA CONEXION
            EntityManager em;
            EntityManagerFactory emf;
            
            //INDICAMOS QUE UTILIZAREMOS UNA PERSISTENCIA EN EL PROYECTO, EL NOMBRE VIENE
            //ESPECIFICADO EN EL ARCHIVO EN EL FOLDER Configuration Files -> persistence.xml
            emf = Persistence.createEntityManagerFactory("PersistenciaJavaPU");
            em = emf.createEntityManager();
            
            // PREPARAMOS LA CONEXION QUE VA A UTILIZAR LA PERSISTENCIA
            em.getTransaction().begin();
            //INDICO QUE CLASE VOY A UTILIZAR PERSISTENCIA
            em.persist(persona);
            //LIMPIAMOS LOS OBJETOS OBSOLETOS EN MEMORIA
            em.flush();
            //EJECUTAMOS LA TRANSACCION DE DATOS
            em.getTransaction().commit();
            
            //REDIRECCIONAMOS A UNA PAGINA
            response.sendRedirect("correcto.jsp");
            
            
            
            
            
            
            
          
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
