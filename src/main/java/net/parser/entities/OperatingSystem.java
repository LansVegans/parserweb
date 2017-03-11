package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table (name = "operatingSystem")
public class OperatingSystem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "operetingSystem")
    private String operetingSystem;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public OperatingSystem(int id, String operetingSystem) {
        this.id = id;
        this.operetingSystem = operetingSystem;
    }

    public OperatingSystem() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperetingSystem() {
        return operetingSystem;
    }

    public void setOperetingSystem(String operetingSystem) {
        this.operetingSystem = operetingSystem;
    }
}
