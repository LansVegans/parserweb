package net.parser.entities;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table(name = "cpu")
public class CPU implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="manufacturerCPU")
    private String manufacturerCPU;
    @Column(name ="modelCPU")
    private String modelCPU;
    @Column(name ="frequencyCPU")
    private String frequencyCPU;
    @Column(name ="numCores")
    private String numCores;
    @Column(name ="maxFrequency")
    private String maxFrequency;
    @Column(name ="cacheL2")
    private String cacheL2;
     @Column(name ="cacheL3")
    private String cacheL3;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public CPU(String manufacturerCPU, String modelCPU, String frequencyCPU, String numCores, String maxFrequency, String cacheL2, String cacheL3) {
        this.manufacturerCPU = manufacturerCPU;
        this.modelCPU = modelCPU;
        this.frequencyCPU = frequencyCPU;
        this.numCores = numCores;
        this.maxFrequency = maxFrequency;
        this.cacheL2 = cacheL2;
        this.cacheL3 = cacheL3;
    }

    public CPU() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturerCPU() {
        return manufacturerCPU;
    }

    public void setManufacturerCPU(String manufacturerCPU) {
        this.manufacturerCPU = manufacturerCPU;
    }

    public String getModelCPU() {
        return modelCPU;
    }

    public void setModelCPU(String modelCPU) {
        this.modelCPU = modelCPU;
    }

    public String getFrequencyCPU() {
        return frequencyCPU;
    }

    public void setFrequencyCPU(String frequencyCPU) {
        this.frequencyCPU = frequencyCPU;
    }

    public String getNumCores() {
        return numCores;
    }

    public void setNumCores(String numCores) {
        this.numCores = numCores;
    }

    public String getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(String maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    public String getCacheL2() {
        return cacheL2;
    }

    public void setCacheL2(String cacheL2) {
        this.cacheL2 = cacheL2;
    }

    public String getCacheL3() {
        return cacheL3;
    }

    public void setCacheL3(String cacheL3) {
        this.cacheL3 = cacheL3;
    }
}
