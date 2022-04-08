package Controllers;

import DAOS.EquiposDAO;
import DTOS.Equipos;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EQUIPOcontroller extends HttpServlet {
    EquiposDAO equipos=new EquiposDAO();
    Equipos equipo=new Equipos();

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
        String accion=request.getParameter("accion");
        
        switch(accion){
            case "Agregar":
                String id1=request.getParameter("txtid");
                String nombreHost = request.getParameter("txtNombreEquipo");
                String tipo = request.getParameter("txtTipo");
                String marca = request.getParameter("txtMarca");
                String modelo = request.getParameter("txtModelo");
                String serie = request.getParameter("txtNSerie");
                String caf = request.getParameter("txtCAF");
                String ubicacion = request.getParameter("txtUbicacion");
                String area = request.getParameter("txtArea");
                String observaciones = request.getParameter("txtObservaciones");
                
                equipo.setId(id1);
                equipo.setNombreHost(nombreHost);
                equipo.setTipo(tipo);
                equipo.setMarca(marca);
                equipo.setModelo(modelo);
                equipo.setSerie(serie);
                equipo.setCaf(caf);
                equipo.setUbicacion(ubicacion);
                equipo.setArea(area);
                equipo.setObservaciones(observaciones);
                equipos.insertar(equipo);
                request.getRequestDispatcher("registrarEquipo.jsp").forward(request, response);
                break;    
                
            case "seleccionar":
                String id2=request.getParameter("idJaladoDB");
                Equipos artefacto = equipos.selectById(id2); 
                request.setAttribute("seleccion",artefacto);
                request.getRequestDispatcher("modificarEquipo.jsp").forward(request, response);
                break;
                
            case "modificar":
                String id3=request.getParameter("idJaladoDB2");
                String nombreHost1 = request.getParameter("txtNombreEquipo1");
                String tipo1 = request.getParameter("txtTipo1");
                String marca1 = request.getParameter("txtMarca1");
                String modelo1 = request.getParameter("txtModelo1");
                String serie1 = request.getParameter("txtNSerie1");
                String caf1 = request.getParameter("txtCAF1");
                String ubicacion1 = request.getParameter("txtUbicacion1");
                String area1 = request.getParameter("txtArea1");
                String observaciones1 = request.getParameter("txtObservaciones1");
                
                equipo.setId(id3);
                equipo.setNombreHost(nombreHost1);
                equipo.setTipo(tipo1);
                equipo.setMarca(marca1);
                equipo.setModelo(modelo1);
                equipo.setSerie(serie1);
                equipo.setCaf(caf1);
                equipo.setUbicacion(ubicacion1);
                equipo.setArea(area1);
                equipo.setObservaciones(observaciones1);
                equipos.modificar(equipo);
                request.getRequestDispatcher("recursosTI.jsp").forward(request, response);
                break;
                
        /*    case "borrar":
                String id4=request.getParameter("idJaladoDB");
                equipos.borrar(id4);
                request.getRequestDispatcher("consultarEquipo.jsp").forward(request, response);   */
                        
            case "ultimos":
                List<Equipos>ultimos=equipos.Ultimos();
                request.setAttribute("ultimos",ultimos);
                request.getRequestDispatcher("registrarEquipo.jsp").forward(request, response);
                break;
             
            case "botonBuscar":
                String busqueda=request.getParameter("txtBusqueda"); //esto jala del formulario buscar
                List<Equipos>datos=equipos.Busqueda(busqueda);
                List<Equipos>contar=equipos.contarPOR(busqueda);
                request.setAttribute("caracteristicas",datos);
                request.setAttribute("contar",contar);
                request.getRequestDispatcher("recursosTI.jsp").forward(request, response);
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