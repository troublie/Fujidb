/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.dao.departamento;

import org.apache.commons.lang.exception.*;

/**
 *
 * @author juliano.lopes
 */
public class DepartamentoNaoEncontradoException extends NestableException {

    public DepartamentoNaoEncontradoException(String msg) {
        super(msg);
    }

    public DepartamentoNaoEncontradoException(Throwable t) {
        super(t);
    }

    public DepartamentoNaoEncontradoException(String msg, Throwable t) {
        super(msg, t);
    }
}
