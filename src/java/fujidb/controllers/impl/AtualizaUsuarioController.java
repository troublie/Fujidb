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
import fujidb.entities.Departamento;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliano.lopes
 */
public class AtualizaUsuarioController extends AbstractController {

    public void execute() {
        boolean res = false;
        UsuarioDAO usuario = getUsuarioDAO();
        Departamento depto = new Departamento();
        int id = Integer.parseInt(this.getRequest().getParameter("id"));
        String nome = this.getRequest().getParameter("nome");
        String sobrenome = this.getRequest().getParameter("sobreNome");
        String email = this.getRequest().getParameter("email");
        String senha = this.getRequest().getParameter("senha");
        depto.setId(Integer.parseInt(this.getRequest().getParameter("depto_id")));
        try {
            usuario.updateUsuario(id, depto, nome, sobrenome, email);
            res = true;
            this.setReturnPage("/resultadoAtualizaUsuario.jsp");
            this.getRequest().setAttribute("res", res);
        } catch (UsuarioNaoEncontradoException ex) {
            Logger.getLogger(AtualizaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            res = false;
            this.setReturnPage("/resultadoAtualizaUsuario.jsp");
            this.getRequest().setAttribute("res", res);
        }
    }
}
