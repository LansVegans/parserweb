package net.parser.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LansVegans on 22.02.2017.
 */
@Entity
@Table(name = "display")
public class Display implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notebook")
    private Notebook notebook;


    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Display() {
    }

    public Display(int id, String matrix, String diagonal, String screenResol, String qualitiDispl, String coatedScreen, String webCam) {
        this.id = id;
        this.matrix = matrix;
        this.diagonal = diagonal;
        this.screenResol = screenResol;
        this.qualitiDispl = qualitiDispl;
        this.coatedScreen = coatedScreen;
        this.webCam = webCam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
