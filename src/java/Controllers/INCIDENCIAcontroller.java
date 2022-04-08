package Controllers;

import DAOS.IncidenciaDAO;
import DTOS.Incidencia;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class INCIDENCIAcontroller extends HttpServlet {
    IncidenciaDAO problemas = new IncidenciaDAO();  
    Incidencia evento = new Incidencia();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String proceso = request.getParameter("accionEvento");
        
        switch (proceso){
            case "insertar":
                String fecha = request.getParameter("txtFecha");
                String user = request.getParameter("txtUser");
                String nombreEquipo = request.getParameter("txtNombreEquipo");
                String descripcion = request.getParameter("txtDescripcion");

                Incidencia evento=new Incidencia();
                evento.setFecha(fecha);
                evento.setUsuario(user);
                evento.setNombreHost(nombreEquipo);
                evento.setDescripcion(descripcion);
                problemas.registrar(evento);
                request.getRequestDispatcher("incidencias.jsp").forward(request, response);
                break;
                
            case "BuscarEvento":
                String usuarioEquipo=request.getParameter("txtBuscarUE");
                List<Incidencia>eventoUserEq=problemas.BuscarEvento(usuarioEquipo);
                request.setAttribute("ocurrencia", eventoUserEq);
                List<Incidencia>contar1=problemas.contarEventos(usuarioEquipo);
                request.setAttribute("cantidad", contar1);
                request.getRequestDispatcher("incidencias.jsp").forward(request, response);
                break;
                
            case "BuscarFecha":
                String eventoFecha=request.getParameter("txtBuscarFecha");
                List<Incidencia>eventoDate=problemas.BuscarEvento(eventoFecha);
                request.setAttribute("ocurrencia", eventoDate);
                List<Incidencia>contar2=problemas.contarEventos(eventoFecha);
                request.setAttribute("cantidad", contar2);
                request.getRequestDispatcher("incidencias.jsp").forward(request, response);
                break;
            
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}