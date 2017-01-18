/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.controllers.impl;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import fujidb.controllers.AbstractController;
import fujidb.dao.usuario.UsuarioDAO;
import static fujidb.dao.usuario.UsuarioDAOFactory.getUsuarioDAO;
import fujidb.entities.Usuario;

/**
 *
 * @author juliano.lopes
 */
public class BuscaUsuarioController extends AbstractController {

    public void execute() {
        Usuario usuario = null;
        Collection cUsuario = null;
        try {
            UsuarioDAO usuarios = getUsuarioDAO();
            if (this.getRequest().getParameter("id") != null) {
                int id = Integer.parseInt(this.getRequest().getParameter("id"));
                usuario = usuarios.buscaUsuarioPorId(id);
                this.setReturnPage("/resultadoBuscaUsuarioID.jsp");
                this.getRequest().setAttribute("usuarioID", usuario);
            } else {
                String nome = this.getRequest().getParameter("nome");
                cUsuario = usuarios.buscaUsuarioPorNome(nome);
                this.setReturnPage("/resultadoBuscaUsuarioNome.jsp");
                this.getRequest().setAttribute("nome", cUsuario);
            }
        } catch (Exception ex) {
            Logger.getLogger(BuscaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
