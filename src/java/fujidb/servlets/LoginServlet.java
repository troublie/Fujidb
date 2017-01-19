/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.servlets;

import fujidb.dao.usuario.UsuarioDAO;
import static fujidb.dao.usuario.UsuarioDAOFactory.getUsuarioDAO;
import fujidb.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
// get request parameters for userID and password
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        //query na DB para puxar user and pass
        UsuarioDAO u = getUsuarioDAO();
        Usuario usuario = null;
        usuario = u.buscaUsuarioPorEmail(email);

        try {
            if (usuario.getEmail().equalsIgnoreCase(email) && usuario.getPassword().equals(senha)) {
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
//setting session to expiry in 30 mins
                session.setMaxInactiveInterval(30 * 60);
                Cookie userName = new Cookie("email", email);
                userName.setMaxAge(30 * 60);
                response.addCookie(userName);
                response.sendRedirect("sucessoLogin.jsp");
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Usuario ou senha incorretos.</font>");
                rd.include(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Usuario ou senha incorretos.</font>");
            rd.include(request, response);
        }
    }
}
