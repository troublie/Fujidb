/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.dao.produto;

import fujidb.entities.Produto;
import java.util.Collection;

/**
 *
 * @author juliano.lopes
 */
public interface ProdutoDAO {

    public Produto buscaProdutoPorId(int id) throws ProdutoNaoEncontradoException;

    public Produto buscaProdutoPorPartNumber(String partNumber);
    
    public Collection buscaProdutoPorPN(String partNumber);

    public Collection buscaTodosProdutos();

    public boolean removeProdutoPorPn(String partNumber) throws ProdutoNaoEncontradoException;

    public Produto criaProduto(String partNUmber, String partName);

    public void updateProduto(int id, String partNumber, String partName, String partNameTrad, String ncm, String detalhes) throws ProdutoNaoEncontradoException;

    public void close();

    public boolean isClosed();
}

