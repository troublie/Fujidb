/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.controllers.impl;

import fujidb.controllers.AbstractController;
import fujidb.dao.produto.ProdutoDAO;
import static fujidb.dao.produto.ProdutoDAOFactory.getProdutoDAO;
import fujidb.dao.produto.ProdutoNaoEncontradoException;
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
public class AtualizaProdutoController extends AbstractController {

  public void execute() {
        boolean res = false;
        ProdutoDAO produto = getProdutoDAO();
        int id = Integer.parseInt(this.getRequest().getParameter("id"));
        String partNumber = this.getRequest().getParameter("pn");
        String partName = this.getRequest().getParameter("pname");
        String partNameTrad = this.getRequest().getParameter("pntrad");
        String ncm = this.getRequest().getParameter("ncm");
        String remarks = this.getRequest().getParameter("details");
        try {
            produto.updateProduto(id, partNumber, partName, partNameTrad, ncm, remarks);
            res = true;
            this.setReturnPage("/resultadoAtualizaProduto.jsp");
            this.getRequest().setAttribute("res", res);
        } catch (ProdutoNaoEncontradoException ex) {
            Logger.getLogger(AtualizaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            res = false;
            this.setReturnPage("/resultadoAtualizaProduto.jsp");
            this.getRequest().setAttribute("res", res);
        }
    }
}
