package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table(name = "physParamB")
public class PhysParamB implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "weightB")
    private String weightB;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public PhysParamB() {
    }

    public PhysParamB(int id, String weightB) {
        this.id = id;
        this.weightB = weightB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeightB() {
        return weightB;
    }

    public void setWeightB(String weightB) {
        this.weightB = weightB;
    }
}
