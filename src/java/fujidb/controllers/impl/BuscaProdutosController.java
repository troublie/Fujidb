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
import fujidb.dao.produto.ProdutoDAO;
import static fujidb.dao.produto.ProdutoDAOFactory.getProdutoDAO;
import fujidb.entities.Produto;

/**
 *
 * @author juliano.lopes
 */
public class BuscaProdutosController extends AbstractController {

    public void execute() {
        Produto produto = null;
        Collection cProdutos = null;
        try {
            ProdutoDAO produtos = getProdutoDAO();
            if (this.getRequest().getParameter("id") != null) {
                int id = Integer.parseInt(this.getRequest().getParameter("id"));
                produto = produtos.buscaProdutoPorId(id);
                this.setReturnPage("/resultadoBuscaProdutoID.jsp");
                this.getRequest().setAttribute("id", produto);
            } else {
                String pn = this.getRequest().getParameter("pn");
                cProdutos = produtos.buscaProdutoPorPN(pn);
                this.setReturnPage("/resultadoBuscaProdutoPorPartNumber.jsp");
                this.getRequest().setAttribute("pn", cProdutos);
            }
        } catch (Exception ex) {
            Logger.getLogger(BuscaProdutosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}