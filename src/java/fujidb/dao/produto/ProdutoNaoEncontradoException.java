/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.dao.produto;

import org.apache.commons.lang.exception.NestableException;

/**
 *
 * @author juliano.lopes
 */
public class ProdutoNaoEncontradoException extends NestableException {

    public ProdutoNaoEncontradoException(String msg) {
        super(msg);
    }

    public ProdutoNaoEncontradoException(Throwable t) {
        super(t);
    }

    public ProdutoNaoEncontradoException(String msg, Throwable t) {
        super(msg, t);
    }
}
