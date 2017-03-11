package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table(name = "opticaldriver")
public class OpticalDriver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "typeDriver")
    private String typeDriver;
    @Column(name = "builtIn")
    private String builtIn;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public OpticalDriver() {
    }

    public OpticalDriver(int id, String typeDriver, String builtIn) {
        this.id = id;
        this.typeDriver = typeDriver;
        this.builtIn = builtIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeDriver() {
        return typeDriver;
    }

    public void setTypeDriver(String typeDriver) {
        this.typeDriver = typeDriver;
    }

    public String getBuiltIn() {
        return builtIn;
    }

    public void setBuiltIn(String builtIn) {
        this.builtIn = builtIn;
    }
}
