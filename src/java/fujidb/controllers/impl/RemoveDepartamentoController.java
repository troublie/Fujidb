/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.controllers.impl;

import fujidb.controllers.AbstractController;
import fujidb.dao.departamento.DepartamentoDAO;
import static fujidb.dao.departamento.DepartamentoDAOFactory.getDepartamentoDAO;
import fujidb.dao.departamento.DepartamentoNaoEncontradoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliano.lopes
 */
public class RemoveDepartamentoController extends AbstractController {

    @Override
    public void execute() {
        try {
            boolean res = false;
            DepartamentoDAO departamento = getDepartamentoDAO();
            int id = Integer.parseInt(this.getRequest().getParameter("idRem"));
            departamento.removeDepartamento(id);
            res = true;
            this.setReturnPage("/resultadoRemoveDepartamento.jsp");
            this.getRequest().setAttribute("idRem", res);
        } catch (DepartamentoNaoEncontradoException ex) {
            Logger.getLogger(RemoveDepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
