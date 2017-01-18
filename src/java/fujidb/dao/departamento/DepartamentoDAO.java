/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.dao.departamento;

import fujidb.entities.Departamento;
import java.util.Collection;

/**
 *
 * @author juliano.lopes
 */
public interface DepartamentoDAO {

    public Departamento buscaDepartamentoPorId(int id) throws DepartamentoNaoEncontradoException;

    public Collection buscaDepartamentoPorNome(String nome);

    public Collection buscaTodosDepartamentos();

    public void removeDepartamento(int id) throws DepartamentoNaoEncontradoException;

    public Departamento criaDepartamento(String nome);

    public void updateDepartamento(int id, String nome) throws DepartamentoNaoEncontradoException;

    public void close();

    public boolean isClosed();
}
