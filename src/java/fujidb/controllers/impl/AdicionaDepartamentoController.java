/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.controllers.impl;

import fujidb.controllers.AbstractController;
import fujidb.dao.departamento.DepartamentoDAO;
import static fujidb.dao.departamento.DepartamentoDAOFactory.getDepartamentoDAO;
import fujidb.entities.Departamento;

/**
 *
 * @author juliano.lopes
 */

public class AdicionaDepartamentoController extends AbstractController {

    @Override
    public void execute() {
        Departamento novoDepartamento = null;
        DepartamentoDAO departamento = getDepartamentoDAO();
        String nome = this.getRequest().getParameter("nome");
        novoDepartamento = departamento.criaDepartamento(nome);
        this.setReturnPage("/resultadoAdicionaDepartamento.jsp");
        this.getRequest().setAttribute("departamento", novoDepartamento);
    }
}
