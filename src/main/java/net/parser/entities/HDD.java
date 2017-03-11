package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table(name = "hdd")
public class HDD implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "rotationSpped")
    private String rotationSpped;
    @Column(name = "memoryDisk")
    private String memoryDisk;
    @Column(name = "interfaceOf")
    private String interfaceOf;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public HDD() {
    }

    public HDD(int id, String rotationSpped, String memoryDisk, String interfaceOf) {
        this.id = id;
        this.rotationSpped = rotationSpped;
        this.memoryDisk = memoryDisk;
        this.interfaceOf = interfaceOf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRotationSpped() {
        return rotationSpped;
    }

    public void setRotationSpped(String rotationSpped) {
        this.rotationSpped = rotationSpped;
    }

    public String getMemoryDisk() {
        return memoryDisk;
    }

    public void setMemoryDisk(String memoryDisk) {
        this.memoryDisk = memoryDisk;
    }

    public String getInterfaceOf() {
        return interfaceOf;
    }

    public void setInterfaceOf(String interfaceOf) {
        this.interfaceOf = interfaceOf;
    }
}
