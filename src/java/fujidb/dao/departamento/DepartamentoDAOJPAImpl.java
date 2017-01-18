/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.dao.departamento;


import fujidb.dao.exception.DAORuntimeException;
import fujidb.entities.Departamento;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.logging.*;

/**
 *
 * @author juliano.lopes
 */
public class DepartamentoDAOJPAImpl implements DepartamentoDAO {

    static final private Log log = LogFactory.getLog(DepartamentoDAOJPAImpl.class);
    private boolean bIsClosed = false;

    public DepartamentoDAOJPAImpl() {
    }

    @Override
    public Departamento buscaDepartamentoPorId(final int id)
            throws DepartamentoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Departamento d = em.find(Departamento.class, id);
        if (d == null) {
            throw new DepartamentoNaoEncontradoException("departamento não encontrado");
        }
        em.clear();
        em.close();
        emf.close();
        return d;
    }

    @Override
    public Collection buscaDepartamentoPorNome(final String nome) {
        Collection result = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Departamento> criteria = builder.createQuery(Departamento.class);
        Root<Departamento> from = criteria.from(Departamento.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("nome"), nome));
        TypedQuery<Departamento> typed = em.createQuery(criteria);
        try {
            result = typed.getResultList();
        } catch (final NoResultException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        }
        em.clear();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public void removeDepartamento(final int id)
            throws DepartamentoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Departamento d = em.find(Departamento.class, id);
        if (d == null) {
            throw new DepartamentoNaoEncontradoException("departamento não encontrado");
        }
        try {
            em.getTransaction().begin();
            em.remove(d);
            em.flush();
            em.getTransaction().commit();
        } catch (final NoResultException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }

    @Override
    public Departamento criaDepartamento(
            final String nome){
        
        Departamento departamento = new Departamento();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        departamento.setNome(nome);
        em.getTransaction().begin();
        em.persist(departamento);
        em.flush();
        em.getTransaction().commit();

        return departamento;
    }

    @Override
    public void updateDepartamento(final int id,
            final String nome) throws DepartamentoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Departamento d = em.find(Departamento.class, id);
        if (d == null) {
            throw new DepartamentoNaoEncontradoException("departamento não encontrado");
        }
        em.getTransaction().begin();
        d.setNome(nome);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        log.info("close() called");
        bIsClosed = true;
    }

    @Override
    public boolean isClosed() {
        return bIsClosed;
    }

    @Override
    public Collection buscaTodosDepartamentos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select d from Departamento d");
        Collection result = null;
        result = q.getResultList();
        em.clear();
        em.close();
        emf.close();
        return result;
    }
}
