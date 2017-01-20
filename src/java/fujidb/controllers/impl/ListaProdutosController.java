/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.controllers.impl;

import fujidb.controllers.AbstractController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fujidb.controllers.AbstractController;
import fujidb.dao.produto.ProdutoDAO;
import fujidb.dao.produto.ProdutoDAOJPAImpl;
import fujidb.entities.Produto;
import java.util.Collection;

/**
 *
 * @author juliano.lopes
 */
public class ListaProdutosController extends AbstractController {

    public void execute() {
        try {
            Collection result = new ArrayList<>();
            ProdutoDAO produtos = new ProdutoDAOJPAImpl();
            result = (Collection) produtos.buscaTodosProdutos();
            this.setReturnPage("/listaProdutos.jsp");
            this.getRequest().setAttribute("produtos", result);
        } catch (Exception ex) {
            Logger.getLogger(UserListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


