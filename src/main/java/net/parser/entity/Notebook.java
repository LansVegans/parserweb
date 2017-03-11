package net.parser.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 04.03.2017.
 */
@Entity
@Table (name = "notebook")
public class Notebook implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_notebook")
    private int id;
    @Column(name = "notebook_name")
    private  String notebook_name;
    @Column(name = "model")
    private String model;
    @Column (name = "descrp")
    private String desrp;
    @Column (name = "smallimg")
    private String smallImg;
    @Column (name = "smallimg1")
    private String smallImg1;
    @Column (name = "smallimg2")
    private String smallImg2;
    @Column (name = "smallimg3")
    private String smallImg3;
    @Column (name = "memoryHDD")
    private String memoryHDD;
    @Column (name = "price")
    private String price;
    @Column(name = "colorOf")
    private String colorOf;
    @Column(name = "micro")
    private String micro;
    @Column(name = "stereeSpeeakers")
    private String stereeSpeeakers;
    @Column(name = "typeBattary")
    private String typeBattary;
    @Column(name = "lifeBattary")
    private String lifeBattary;
    @Column(name = "wifi")
    private String wifi;
    @Column(name = "bluetooth")
    private String bluetooth;
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
    @Column(name = "matrix")
    private String matrix;
    @Column(name = "diagonal")
    private String diagonal;
    @Column(name = "screenResol")
    private String screenResol;
    @Column(name = "qualitiDispl")
    private String qualitiDispl;
    @Column(name = "coatedScreen")
    private String coatedScreen;
    @Column(name = "webCam")
    private String webCam;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "pn")
    private String pn;
    @Column(name = "rotationSpped")
    private String rotationSpped;
    @Column(name = "memoryDisk")
    private String memoryDisk;
    @Column(name = "interfaceOf")
    private String interfaceOf;
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
    @Column(name = "operetingSystem")
    private String operetingSystem;
    @Column(name = "typeDriver")
    private String typeDriver;
    @Column(name = "builtIn")
    private String builtIn;
    @Column(name = "weightB")
    private String weightB;
    @Column(name = "sizeOf")
    private String sizeOf;
    @Column(name = "weightOf")
    private String weightOf;
    @Column(name = "memory")
    private String memory;
    @Column(name = "typeMemory")
    private String typeMemory;
    @Column(name = "frequencyShiny")
    private String frequencyShiny;
    @Column(name = "manufacturerVideo")
    private String manufacturerVideo;
    @Column(name = "graphChip")
    private String graphChip;
    @Column(name = "memoryVideo")
    private String memoryVideo;
    @Column(name = "external")
    private String external;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotebook_name() {
        return notebook_name;
    }

    public void setNotebook_name(String notebook_name) {
        this.notebook_name = notebook_name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDesrp() {
        return desrp;
    }

    public void setDesrp(String desrp) {
        this.desrp = desrp;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public String getSmallImg1() {
        return smallImg1;
    }

    public void setSmallImg1(String smallImg1) {
        this.smallImg1 = smallImg1;
    }

    public String getSmallImg2() {
        return smallImg2;
    }

    public void setSmallImg2(String smallImg2) {
        this.smallImg2 = smallImg2;
    }

    public String getSmallImg3() {
        return smallImg3;
    }

    public void setSmallImg3(String smallImg3) {
        this.smallImg3 = smallImg3;
    }

    public String getMemoryHDD() {
        return memoryHDD;
    }

    public void setMemoryHDD(String memoryHDD) {
        this.memoryHDD = memoryHDD;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColorOf() {
        return colorOf;
    }

    public void setColorOf(String colorOf) {
        this.colorOf = colorOf;
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

    public String getMatrix() {
        return matrix;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public String getScreenResol() {
        return screenResol;
    }

    public void setScreenResol(String screenResol) {
        this.screenResol = screenResol;
    }

    public String getQualitiDispl() {
        return qualitiDispl;
    }

    public void setQualitiDispl(String qualitiDispl) {
        this.qualitiDispl = qualitiDispl;
    }

    public String getCoatedScreen() {
        return coatedScreen;
    }

    public void setCoatedScreen(String coatedScreen) {
        this.coatedScreen = coatedScreen;
    }

    public String getWebCam() {
        return webCam;
    }

    public void setWebCam(String webCam) {
        this.webCam = webCam;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
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

    public String getOperetingSystem() {
        return operetingSystem;
    }

    public void setOperetingSystem(String operetingSystem) {
        this.operetingSystem = operetingSystem;
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

    public String getWeightB() {
        return weightB;
    }

    public void setWeightB(String weightB) {
        this.weightB = weightB;
    }

    public String getSizeOf() {
        return sizeOf;
    }

    public void setSizeOf(String sizeOf) {
        this.sizeOf = sizeOf;
    }

    public String getWeightOf() {
        return weightOf;
    }

    public void setWeightOf(String weightOf) {
        this.weightOf = weightOf;
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

    public String getManufacturerVideo() {
        return manufacturerVideo;
    }

    public void setManufacturerVideo(String manufacturerVideo) {
        this.manufacturerVideo = manufacturerVideo;
    }

    public String getGraphChip() {
        return graphChip;
    }

    public void setGraphChip(String graphChip) {
        this.graphChip = graphChip;
    }

    public String getMemoryVideo() {
        return memoryVideo;
    }

    public void setMemoryVideo(String memoryVideo) {
        this.memoryVideo = memoryVideo;
    }

    public String getExternal() {
        return external;
    }

    public void setExternal(String external) {
        this.external = external;
    }


}
