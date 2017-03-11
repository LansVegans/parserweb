package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table(name = "physParamN")
public class PhysParamN implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sizeOf")
    private String sizeOf;
    @Column(name = "weightOf")
    private String weightOf;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public PhysParamN() {
    }

    public PhysParamN(int id, String sizeOf, String weightOf) {
        this.id = id;
        this.sizeOf = sizeOf;
        this.weightOf = weightOf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeOf() {
        return sizeOf;
    }

    public void setSizeOf(String sizeOf) {
        this.sizeOf = sizeOf;
    }

    public String getWeightOf() {
        return weightOf;
    }

    public void setWeightOf(String weightOf) {
        this.weightOf = weightOf;
    }
}
