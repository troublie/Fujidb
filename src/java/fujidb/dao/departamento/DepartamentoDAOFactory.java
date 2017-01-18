/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.dao.departamento;


/**
 *
 * @author juliano.lopes
 */
public class DepartamentoDAOFactory {

    private DepartamentoDAOFactory() {
    }

    public static DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoDAOJPAImpl();
    }
}
