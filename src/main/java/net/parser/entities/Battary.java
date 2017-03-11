package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table(name = "battary")
public class Battary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "typeBattary")
    private String typeBattary;
    @Column(name = "lifeBattary")
    private String lifeBattary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Battary() {
    }

    public Battary(int id, String typeBattary, String lifeBattary) {
        this.id = id;
        this.typeBattary = typeBattary;
        this.lifeBattary = lifeBattary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeBattary() {
        return typeBattary;
    }

    public void setTypeBattary(String typeBattary) {
        this.typeBattary = typeBattary;
    }

    public String getLifeBattary() {
        return lifeBattary;
    }

    public void setLifeBattary(String lifeBattary) {
        this.lifeBattary = lifeBattary;
    }
}
