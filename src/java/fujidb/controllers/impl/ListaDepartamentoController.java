package fujidb.controllers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fujidb.controllers.AbstractController;
import fujidb.dao.departamento.DepartamentoDAO;
import fujidb.dao.departamento.DepartamentoDAOJPAImpl;
import fujidb.entities.Departamento;
import java.util.Collection;

/**
 *
 * @author juliano.lopes
 */
public class ListaDepartamentoController extends AbstractController {

    public void execute() {
        try {
            Collection result = new ArrayList<>();
            DepartamentoDAO usuarios = new DepartamentoDAOJPAImpl();
            result = (Collection) usuarios.buscaTodosDepartamentos();
            this.setReturnPage("/listaDepartamentos.jsp");
            this.getRequest().setAttribute("departamentos", result);
        } catch (Exception ex) {
            Logger.getLogger(UserListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
