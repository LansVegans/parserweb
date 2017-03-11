package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table(name = "interfacess")
public class Interfacess implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "usb3_0")
    private String usb3_0;
    @Column(name = "usb3_1")
    private String usb3_1;
    @Column(name = "output")
    private String output;
    @Column(name = "displayPort")
    private String displayPort;
    @Column(name = "thunderbolt")
    private String thunderbolt;
    @Column(name = "thunderbolt3")
    private String thunderbolt3;
    @Column(name = "cardReader")
    private String cardReader;
    @Column(name = "hdmi")
    private String hdmi;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Interfacess() {
    }

    public Interfacess(int id, String usb3_0, String usb3_1, String output, String displayPort, String thunderbolt, String thunderbolt3, String cardReader, String hdmi) {
        this.id = id;
        this.usb3_0 = usb3_0;
        this.usb3_1 = usb3_1;
        this.output = output;
        this.displayPort = displayPort;
        this.thunderbolt = thunderbolt;
        this.thunderbolt3 = thunderbolt3;
        this.cardReader = cardReader;
        this.hdmi = hdmi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsb3_0() {
        return usb3_0;
    }

    public void setUsb3_0(String usb3_0) {
        this.usb3_0 = usb3_0;
    }

    public String getUsb3_1() {
        return usb3_1;
    }

    public void setUsb3_1(String usb3_1) {
        this.usb3_1 = usb3_1;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getDisplayPort() {
        return displayPort;
    }

    public void setDisplayPort(String displayPort) {
        this.displayPort = displayPort;
    }

    public String getThunderbolt() {
        return thunderbolt;
    }

    public void setThunderbolt(String thunderbolt) {
        this.thunderbolt = thunderbolt;
    }

    public String getThunderbolt3() {
        return thunderbolt3;
    }

    public void setThunderbolt3(String thunderbolt3) {
        this.thunderbolt3 = thunderbolt3;
    }

    public String getCardReader() {
        return cardReader;
    }

    public void setCardReader(String cardReader) {
        this.cardReader = cardReader;
    }

    public String getHdmi() {
        return hdmi;
    }

    public void setHdmi(String hdmi) {
        this.hdmi = hdmi;
    }
}
