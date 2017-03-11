package net.parser.entities;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 25.02.2017.
 */
@Entity
@Table (name = "notebook")
public class Notebook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notebook")
    private int id;
    @Column(name = "notebook_name")
    private  String notebook_name;
    @Column (name = "price")
    private String price;

//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private HDD hdd;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private AdditionalChar additionalChar;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private AudioSound audioSound;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Battary battary;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Communications communications;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private CPU cpu;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Display display;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private GeneralInfo generalInfo;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Interfacess interfacess;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private OperatingSystem operatingSystem;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private OpticalDriver opticalDriver;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private PhysParamB physParamB;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private PhysParamN physParamN;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private RAM ram;
//    @OneToOne(mappedBy = "notebook",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private VideoAdapter videoAdapter;
//
//
//    public HDD getHdd() {
//        return hdd;
//    }
//
//    public void setHdd(HDD hdd) {
//        this.hdd = hdd;
//    }
//
//    public AdditionalChar getAdditionalChar() {
//        return additionalChar;
//    }
//
//    public void setAdditionalChar(AdditionalChar additionalChar) {
//        this.additionalChar = additionalChar;
//    }
//
//    public AudioSound getAudioSound() {
//        return audioSound;
//    }
//
//    public void setAudioSound(AudioSound audioSound) {
//        this.audioSound = audioSound;
//    }
//
//    public Battary getBattary() {
//        return battary;
//    }
//
//    public void setBattary(Battary battary) {
//        this.battary = battary;
//    }
//
//    public Communications getCommunications() {
//        return communications;
//    }
//
//    public void setCommunications(Communications communications) {
//        this.communications = communications;
//    }
//
//    public CPU getCpu() {
//        return cpu;
//    }
//
//    public void setCpu(CPU cpu) {
//        this.cpu = cpu;
//    }
//
//    public Display getDisplay() {
//        return display;
//    }
//
//    public void setDisplay(Display display) {
//        this.display = display;
//    }
//
//    public GeneralInfo getGeneralInfo() {
//        return generalInfo;
//    }
//
//    public void setGeneralInfo(GeneralInfo generalInfo) {
//        this.generalInfo = generalInfo;
//    }
//
//    public Interfacess getInterfacess() {
//        return interfacess;
//    }
//
//    public void setInterfacess(Interfacess interfacess) {
//        this.interfacess = interfacess;
//    }
//
//    public OperatingSystem getOperatingSystem() {
//        return operatingSystem;
//    }
//
//    public void setOperatingSystem(OperatingSystem operatingSystem) {
//        this.operatingSystem = operatingSystem;
//    }
//
//    public OpticalDriver getOpticalDriver() {
//        return opticalDriver;
//    }
//
//    public void setOpticalDriver(OpticalDriver opticalDriver) {
//        this.opticalDriver = opticalDriver;
//    }
//
//    public PhysParamB getPhysParamB() {
//        return physParamB;
//    }
//
//    public void setPhysParamB(PhysParamB physParamB) {
//        this.physParamB = physParamB;
//    }
//
//    public PhysParamN getPhysParamN() {
//        return physParamN;
//    }
//
//    public void setPhysParamN(PhysParamN physParamN) {
//        this.physParamN = physParamN;
//    }
//
//    public RAM getRam() {
//        return ram;
//    }
//
//    public void setRam(RAM ram) {
//        this.ram = ram;
//    }
//
//    public VideoAdapter getVideoAdapter() {
//        return videoAdapter;
//    }
//
//    public void setVideoAdapter(VideoAdapter videoAdapter) {
//        this.videoAdapter = videoAdapter;
//    }

    public Notebook() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Notebook(String notebook_name) {
        this.notebook_name = notebook_name;
    }

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
}

