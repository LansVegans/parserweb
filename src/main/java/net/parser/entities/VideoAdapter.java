package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table (name = "videoAdpter")
public class VideoAdapter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "manufacturerVideo")
    private String manufacturerVideo;
    @Column(name = "graphChip")
    private String graphChip;
    @Column(name = "memoryVideo")
    private String memoryVideo;
    @Column(name = "external")
    private String external;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public VideoAdapter() {
    }

    public VideoAdapter(int id, String manufacturerVideo, String graphChip, String memoryVideo, String external) {
        this.id = id;
        this.manufacturerVideo = manufacturerVideo;
        this.graphChip = graphChip;
        this.memoryVideo = memoryVideo;
        this.external = external;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
