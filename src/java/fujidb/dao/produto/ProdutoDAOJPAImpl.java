/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.dao.produto;

import fujidb.dao.exception.DAORuntimeException;
import fujidb.entities.Produto;
import fujidb.entities.Produto_;
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
public class ProdutoDAOJPAImpl implements ProdutoDAO {

    static final private Log log = LogFactory.getLog(ProdutoDAOJPAImpl.class);
    private boolean bIsClosed = false;

    @Override
    public Produto buscaProdutoPorId(int id)
            throws ProdutoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Produto d = em.find(Produto.class, id);
        if (d == null) {
            throw new ProdutoNaoEncontradoException("produto não encontrado");
        }
        em.clear();
        em.close();
        emf.close();
        return d;
    }

    @Override
    public Produto buscaProdutoPorPartNumber(final String partNumber) {
        Produto result = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
        Root<Produto> from = criteria.from(Produto.class);
        criteria.select(from);
        //criteria.where(builder.equal(from.get("partNumber"), partNumber));
        criteria.where(builder.like(from.get("partNumber"), partNumber));
        TypedQuery<Produto> typed = em.createQuery(criteria);
        try {
            result = typed.getSingleResult();
        } catch (final NoResultException ex) {
            log.error(ex);
            //throw new DAORuntimeException(ex);
        }
        em.clear();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public Collection<Produto> buscaProdutoPorPN(String partNumber) {
        Collection result = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Produto> criteria = cb.createQuery(Produto.class);
        Root<Produto> root = criteria.from(Produto.class);
        criteria.select(root);
        criteria.where(cb.like(root.get(Produto_.partNumber), "%" + partNumber + "%"));
        TypedQuery<Produto> typed = em.createQuery(criteria);
        try {
            result = typed.getResultList();
        } catch (final NoResultException ex) {
            log.error(ex);
        }
        return result;
    }

    @Override
    public Collection buscaTodosProdutos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select p from Produto p");
        Collection result = null;
        result = q.getResultList();
        em.clear();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public boolean removeProdutoPorPn(String partNumber) throws ProdutoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        boolean result = false;
        Produto p = buscaProdutoPorPartNumber(partNumber);
        if (p == null) {
            throw new ProdutoNaoEncontradoException("produto não encontrado");
        }
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.flush();
            em.getTransaction().commit();
        } catch (final NoResultException ex) {
            log.error(ex);

        } finally {
            em.clear();
            em.close();
            emf.close();
            result = true;
        }
        return result;
    }

    @Override
    public Produto criaProduto(String partNumber, String partName) {
        Produto produto = new Produto();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        produto.setPartNumber(partNumber);
        produto.setPartName(partName);
        em.getTransaction().begin();
        em.persist(produto);
        em.flush();
        em.getTransaction().commit();

        return produto;
    }

    @Override
    public void updateProduto(int id, String partNumber, String partName,
            String partNameTrad, String ncm, String detalhes)
            throws ProdutoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Produto p = em.find(Produto.class, id);
        if (p == null) {
            throw new ProdutoNaoEncontradoException("produto não encontrado");
        }
        p.setPartNumber(partNumber);
        p.setPartName(partName);
        p.setPartNameTrad(partNameTrad);
        p.setNcm(ncm);
        p.setDetalhes(detalhes);
        em.getTransaction().begin();
        em.persist(p);
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
}
