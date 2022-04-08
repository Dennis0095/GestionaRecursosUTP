package Controllers;

import DAOS.UsuarioDAO;
import DTOS.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class USUARIOcontroller extends HttpServlet {
    UsuarioDAO usuarioDAO;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proceso = request.getParameter("txtProceso");
        switch (proceso) {
            case "login":
                login(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
        }
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
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usuarioDAO=new UsuarioDAO();
        String user = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave1");
        Usuario usuario = new Usuario();
        
        usuario.setUser(user);
        usuario.setClave(clave);
            
        /*HttpSession sessionOK = request.getSession();
        if (usuarioDAO.loguear(usuario)!=null) {
            usuario = usuarioDAO.loguear(usuario);
            
            sessionOK.setAttribute("nombres",usuario.getNombres());
            sessionOK.setAttribute("apellidos",usuario.getApellidos());
            sessionOK.setAttribute("usuario",usuario.getUser());
            sessionOK.setAttribute("correo", usuario.getCorreo());
            sessionOK.setAttribute("area", usuario.getArea());
            sessionOK.setAttribute("perfil",usuario.getPerfil());
            sessionOK.setAttribute("estado",usuario.getEstado());
            
            request.getRequestDispatcher("recursosTI.jsp").forward(request, response);
            
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }*/
        HttpSession sessionOK = request.getSession();            
            sessionOK.setAttribute("nombres","dennis");
            sessionOK.setAttribute("apellidos", "mendez");
            sessionOK.setAttribute("usuario", 2);
            sessionOK.setAttribute("correo", "dnrich95@gmail.com");
            sessionOK.setAttribute("area", "administrativo");
            sessionOK.setAttribute("perfil", "administrador");
            sessionOK.setAttribute("estado", 1);
        request.getRequestDispatcher("recursosTI.jsp").forward(request, response);
    }
   
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessionOK = request.getSession();

        sessionOK.removeAttribute("nombres");
        sessionOK.removeAttribute("apellidos");
        sessionOK.removeAttribute("usuario");
        sessionOK.removeAttribute("correo");
        sessionOK.removeAttribute("area");
        sessionOK.removeAttribute("perfil");
        sessionOK.removeAttribute("estado");
        sessionOK.invalidate();        
        request.getRequestDispatcher("logout.jsp").forward(request, response);
    } 
}