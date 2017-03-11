package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table (name = "ram")
public class RAM implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "memory")
    private String memory;
    @Column(name = "typeMemory")
    private String typeMemory;
    @Column(name = "frequencyShiny")
    private String frequencyShiny;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public RAM() {
    }

    public RAM(int id, String memory, String typeMemory, String frequencyShiny) {
        this.id = id;
        this.memory = memory;
        this.typeMemory = typeMemory;
        this.frequencyShiny = frequencyShiny;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getTypeMemory() {
        return typeMemory;
    }

    public void setTypeMemory(String typeMemory) {
        this.typeMemory = typeMemory;
    }

    public String getFrequencyShiny() {
        return frequencyShiny;
    }

    public void setFrequencyShiny(String frequencyShiny) {
        this.frequencyShiny = frequencyShiny;
    }
}
