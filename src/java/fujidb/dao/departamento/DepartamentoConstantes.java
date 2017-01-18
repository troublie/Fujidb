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
final class DepartamentoConstantes {

    static public final String URL = "jdbc:derby://localhost:1527/FujiDB";
    static public final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static public final String USER = "admin";
    static public final String PASSWORD = "fuji123";
    static public final String USUARIO_TABLE_NAME = "departamento";
    static public final String USUARIO_ID_SEQUENCE_NAME = "departamento_id_sequence";

    private DepartamentoConstantes() {
    }
}
