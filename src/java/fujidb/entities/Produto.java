/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fujidb.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author juliano.lopes
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @Column(name = "produto_id")
    @SequenceGenerator(name = "produtoGenerator", sequenceName = "produto_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoGenerator")
    private int id;
    @Column(name = "part_number")
    private String partNumber;
    @Column(name = "part_name")
    private String partName;
    @Column(name = "part_name_trad")
    private String partNameTrad;
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "detalhes")
    private String detalhes;

    public Produto() {

    }

    public Produto(int id, String partNumber, String partName, String partNameTrad, String ncm, String detalhes) {
        this.id = id;
        this.partNumber = partNumber;
        this.partName = partName;
        this.partNameTrad = partNameTrad;
        this.ncm = ncm;
        this.detalhes = detalhes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartNameTrad() {
        return partNameTrad;
    }

    public void setPartNameTrad(String partNameTrad) {
        this.partNameTrad = partNameTrad;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    

}
