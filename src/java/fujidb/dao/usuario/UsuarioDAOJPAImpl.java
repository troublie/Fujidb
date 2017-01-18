/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.dao.usuario;

import fujidb.dao.exception.DAORuntimeException;
import fujidb.entities.Departamento;
import fujidb.entities.Usuario;
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
public class UsuarioDAOJPAImpl implements UsuarioDAO {

    static final private Log log = LogFactory.getLog(UsuarioDAOJPAImpl.class);
    private boolean bIsClosed = false;

    public UsuarioDAOJPAImpl() {
    }

    @Override
    public Usuario buscaUsuarioPorId(final int id)
            throws UsuarioNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, id);
        if (u == null) {
            throw new UsuarioNaoEncontradoException("usuario não encontrado");
        }
        em.clear();
        em.close();
        emf.close();
        return u;
    }

    @Override
    public Collection buscaUsuarioPorNome(final String nome) {
        Collection result = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
        Root<Usuario> from = criteria.from(Usuario.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("nome"), nome));
        TypedQuery<Usuario> typed = em.createQuery(criteria);
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
    public void removeUsuario(final int id)
            throws UsuarioNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, id);
        if (u == null) {
            throw new UsuarioNaoEncontradoException("usuario não encontrado");
        }
        try {
            em.getTransaction().begin();
            em.remove(u);
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
    public Usuario criaUsuario(
            final Departamento depto,
            final String nome,
            final String sobrenome,
            final String email,
            final String senha) {

        Usuario usuario = new Usuario();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        usuario.setDepto(depto);
        usuario.setNome(nome);
        usuario.setSobreNome(sobrenome);
        usuario.setEmail(email);
        usuario.setPassword(senha);
        em.getTransaction().begin();
        em.persist(usuario);
        em.flush();
        em.getTransaction().commit();

        return usuario;
    }

    @Override
    public void updateUsuario(final int id,
            final Departamento depto,
            final String usuarioFirstName,
            final String usuarioLastName,
            final String usuarioEmail) throws UsuarioNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, id);
        if (u == null) {
            throw new UsuarioNaoEncontradoException("usuario não encontrado");
        }
        em.getTransaction().begin();
        u.setNome(usuarioFirstName);
        u.setSobreNome(usuarioLastName);
        u.setEmail(usuarioEmail);
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
    public Collection buscaTodosUsuarios() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FujidbPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select u from Usuario u");
        Collection result = null;
        result = q.getResultList();
        em.clear();
        em.close();
        emf.close();
        return result;
    }
}
