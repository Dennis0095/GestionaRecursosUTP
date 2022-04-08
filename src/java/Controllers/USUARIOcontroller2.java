package Controllers;

import DAOS.UsuarioDAO;
import DTOS.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class USUARIOcontroller2 extends HttpServlet {
    UsuarioDAO usuarios=new UsuarioDAO();
    Usuario usuario=new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String accion=request.getParameter("txtProceso");
        
        switch(accion){
            case "registro":
                String id1=request.getParameter("txtid");
                String nombres = request.getParameter("txtNombres");
                String apellidos = request.getParameter("txtApellidos");
                String user = request.getParameter("txtUsuario");
                String clave = request.getParameter("txtClave");
                String correo = request.getParameter("txtCorreo");
                String area = request.getParameter("txtArea");
                String perfil = request.getParameter("txtPerfil");
               
                usuario.setId(id1);
                usuario.setNombres(nombres);
                usuario.setApellidos(apellidos);
                usuario.setUser(user);
                usuario.setClave(clave);
                usuario.setCorreo(correo);
                usuario.setArea(area);
                usuario.setPerfil(perfil);
                usuarios.insertar(usuario);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                break;
                
            case "buscarUsuario":
                String busqueda=request.getParameter("txtBuscarUsuario"); 
                List<Usuario>datos=usuarios.buscarUsuario(busqueda);
                request.setAttribute("user",datos);
                List<Usuario>contar=usuarios.contarUSER(busqueda);
                request.setAttribute("contar",contar);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
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