package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table(name = "communications")
public class Communications implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "wifi")
    private String wifi;
    @Column(name = "bluetooth")
    private String bluetooth;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Communications() {
    }

    public Communications(int id, String wifi, String bluetooth) {
        this.id = id;
        this.wifi = wifi;
        this.bluetooth = bluetooth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }
}
