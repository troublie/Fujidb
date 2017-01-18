package fujidb.controllers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fujidb.controllers.AbstractController;
import fujidb.dao.usuario.UsuarioDAO;
import fujidb.dao.usuario.UsuarioDAOJPAImpl;
import fujidb.entities.Usuario;
import java.util.Collection;

/**
 *
 * @author juliano.lopes
 */
public class UserListController extends AbstractController {

    public void execute() {
        try {
            Collection result = new ArrayList<>();
            UsuarioDAO usuarios = new UsuarioDAOJPAImpl();
            result = (Collection) usuarios.buscaTodosUsuarios();
            this.setReturnPage("/listaUsuarios.jsp");
            this.getRequest().setAttribute("usuarios", result);
        } catch (Exception ex) {
            Logger.getLogger(UserListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
