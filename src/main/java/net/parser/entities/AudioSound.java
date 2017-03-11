package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table(name = "audiosound")
public class AudioSound implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "micro")
    private String micro;
    @Column(name = "stereeSpeeakers")
    private String stereeSpeeakers;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public AudioSound(int id, String micro, String stereeSpeeakers) {
        this.id = id;
        this.micro = micro;
        this.stereeSpeeakers = stereeSpeeakers;
    }

    public AudioSound() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMicro() {
        return micro;
    }

    public void setMicro(String micro) {
        this.micro = micro;
    }

    public String getStereeSpeeakers() {
        return stereeSpeeakers;
    }

    public void setStereeSpeeakers(String stereeSpeeakers) {
        this.stereeSpeeakers = stereeSpeeakers;
    }
}
