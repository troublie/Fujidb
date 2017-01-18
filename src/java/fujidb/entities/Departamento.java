/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author juliano.lopes
 */
@Entity
@Table(name = "depto")
public class Departamento implements Serializable {

    @Id
    @Column(name = "depto_id")
    @SequenceGenerator(name = "deptoGenerator", sequenceName = "depto_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deptoGenerator")
    private int id;
    @Column(name = "nome")
    private String nome;

    public Departamento() {

    }

    @OneToMany(mappedBy = "depto")
    private List<Usuario> usuarios;
    
    public List<Usuario> getUsuarios(){
        return usuarios;
    }
    
    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
