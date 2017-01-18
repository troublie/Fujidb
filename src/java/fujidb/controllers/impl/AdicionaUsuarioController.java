/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.controllers.impl;

import fujidb.controllers.AbstractController;
import fujidb.dao.usuario.UsuarioDAO;
import static fujidb.dao.usuario.UsuarioDAOFactory.getUsuarioDAO;
import fujidb.entities.Departamento;
import fujidb.entities.Usuario;

/**
 *
 * @author juliano.lopes
 */
public class AdicionaUsuarioController extends AbstractController {

    @Override
    public void execute() {

        Usuario novoUsuario = null;
        UsuarioDAO usuario = getUsuarioDAO();
        Departamento depto = new Departamento();
        depto.setId(Integer.parseInt(this.getRequest().getParameter("depto_id")));
        String nome = this.getRequest().getParameter("nome");
        String sobreNome = this.getRequest().getParameter("sobreNome");
        String email = this.getRequest().getParameter("email");
        String senha = this.getRequest().getParameter("senha");
        novoUsuario = usuario.criaUsuario(depto, nome, sobreNome, email, senha);
        this.setReturnPage("/resultadoAdiciona.jsp");
        this.getRequest().setAttribute("usuario", novoUsuario);
    }
}
