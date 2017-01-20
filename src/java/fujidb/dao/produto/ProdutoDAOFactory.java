/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.dao.produto;

/**
 *
 * @author juliano.lopes
 */
public class ProdutoDAOFactory {

    private ProdutoDAOFactory() {
    }

    public static ProdutoDAO getProdutoDAO() {
        return new ProdutoDAOJPAImpl();
    }
}
