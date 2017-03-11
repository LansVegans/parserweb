package net.parser.entities;

/**
 * Created by LansVegans on 22.02.2017.
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "additionalChar")
public class AdditionalChar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "colorOf")
    private String colorOf;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public AdditionalChar() {
    }

    public AdditionalChar(int id, String colorOf) {
        this.id = id;
        this.colorOf = colorOf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorOf() {
        return colorOf;
    }

    public void setColorOf(String colorOf) {
        this.colorOf = colorOf;
    }
}
