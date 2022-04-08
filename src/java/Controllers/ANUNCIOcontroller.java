package Controllers;

import DAOS.AnunciosDAO;
import DTOS.Anuncios;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ANUNCIOcontroller extends HttpServlet {
    AnunciosDAO comunicado = new AnunciosDAO();
    Anuncios anuncio = new Anuncios();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accionAnuncio");
        
        switch(accion){
            case "insertar":
                String id=request.getParameter("txtid");
                String titulo=request.getParameter("txtAnuncioTitulo");
                String fecha=request.getParameter("txtAnuncioFecha");
                String noticia=request.getParameter("txtAnuncioComunicado");
                Anuncios anuncio = new Anuncios();
                anuncio.setId(id);
                anuncio.setTitulo(titulo);
                anuncio.setNoticia(noticia);
                anuncio.setFecha(fecha);
                comunicado.insertar(anuncio);
                request.getRequestDispatcher("anuncios.jsp").forward(request, response);
                break;
            
          case "jalarAnuncio":
                String anuncio1=request.getParameter("txtAnuncio1");
                List<Anuncios>jalaAnuncio1=comunicado.jalarNoticia(anuncio1);
                request.setAttribute("anuncio1", jalaAnuncio1);
                request.getRequestDispatcher("paginaUsuario.jsp").forward(request, response);
                break;
           
            default:
                throw new AssertionError();
        }
        
    }   

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}