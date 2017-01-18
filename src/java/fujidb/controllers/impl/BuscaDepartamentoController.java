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
import fujidb.dao.departamento.DepartamentoDAO;
import static fujidb.dao.departamento.DepartamentoDAOFactory.getDepartamentoDAO;
import fujidb.dao.departamento.DepartamentoNaoEncontradoException;
import fujidb.entities.Departamento;

/**
 *
 * @author juliano.lopes
 */
public class BuscaDepartamentoController extends AbstractController {

    @Override
    public void execute() {
        Departamento departamento = null;
        Collection cDepartamento = null;
        boolean res = false;
        try {
            DepartamentoDAO departamentos = getDepartamentoDAO();
            if (this.getRequest().getParameter("id") != null) {
                int id = Integer.parseInt(this.getRequest().getParameter("id"));
                departamento = departamentos.buscaDepartamentoPorId(id);
                res = true;
                this.setReturnPage("/resultadoBuscaDepartamentoID.jsp");
                this.getRequest().setAttribute("res", res);
                this.getRequest().setAttribute("departamentoID", departamento);
            } else {

                String nome = this.getRequest().getParameter("nome");
                cDepartamento = departamentos.buscaDepartamentoPorNome(nome);
                res = true;
                this.setReturnPage("/resultadoBuscaDepartamentoNome.jsp");
                this.getRequest().setAttribute("res", res);
                this.getRequest().setAttribute("nome", cDepartamento);
            }

        } catch (DepartamentoNaoEncontradoException | NumberFormatException ex) {
            Logger.getLogger(BuscaDepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            res = false;
            this.getRequest().setAttribute("res", res);
            this.setReturnPage("/resultadoBuscaDepartamentoErro.jsp");
        }
    }
}
