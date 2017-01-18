/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.controllers.impl;

import fujidb.controllers.AbstractController;
import fujidb.dao.usuario.UsuarioDAO;
import static fujidb.dao.usuario.UsuarioDAOFactory.getUsuarioDAO;
import fujidb.dao.usuario.UsuarioNaoEncontradoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliano.lopes
 */
public class RemoveUsuarioController extends AbstractController {

    @Override
    public void execute() {
        boolean res = false;
        try {
            UsuarioDAO usuario = getUsuarioDAO();
            int id = Integer.parseInt(this.getRequest().getParameter("idRem"));
            usuario.removeUsuario(id);
            res = true;
            this.setReturnPage("/resultadoRemoveUsuario.jsp");
            this.getRequest().setAttribute("idRem", res);
        } catch (UsuarioNaoEncontradoException ex) {
            Logger.getLogger(RemoveUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            res = false;
            this.setReturnPage("/resultadoRemoveUsuario.jsp");
            this.getRequest().setAttribute("idRem", res);
        }
    }
}
