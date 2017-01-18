/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.controllers.impl;

import fujidb.controllers.AbstractController;
import fujidb.controllers.AbstractController;
import fujidb.dao.departamento.DepartamentoDAO;
import static fujidb.dao.departamento.DepartamentoDAOFactory.getDepartamentoDAO;
import fujidb.dao.departamento.DepartamentoNaoEncontradoException;
import fujidb.entities.Departamento;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliano.lopes
 */
public class AtualizaDepartamentoController extends AbstractController {

    public void execute() {
        boolean res = false;
        DepartamentoDAO depto = getDepartamentoDAO();
        int id = Integer.parseInt(this.getRequest().getParameter("id"));
        String nome = this.getRequest().getParameter("nome");
        try {
            depto.updateDepartamento(id, nome);
            res = true;
            this.getRequest().setAttribute("res", res);
            this.setReturnPage("/resultadoAtualizaDepartamento.jsp");
        } catch (DepartamentoNaoEncontradoException ex) {
            Logger.getLogger(AtualizaDepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            res = false;
            this.getRequest().setAttribute("res", res);
            this.setReturnPage("/resultadoAtualizaDepartamento.jsp");
        }

    }
}
