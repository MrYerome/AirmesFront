package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.sql.Timestamp;

public class Mesure extends ResourceSupport {
    private Link id;
    private Long dataId;
    private String label;
    private String unite;
    private Integer position;
    private Integer typeMesure;
    private byte graphique;
    private Integer genre;
    private byte preRemplie;
    private Double minimum;
    private Double maximum;
    private byte obligatoire;
    private Timestamp dateSuppr;
    private Timestamp dateAjout;
    private Timestamp dateRetrait;

    @Override
    public Link getId() {
        return id;
    }

    public void setId(Link id) {
        this.id = id;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getTypeMesure() {
        return typeMesure;
    }

    public void setTypeMesure(Integer typeMesure) {
        this.typeMesure = typeMesure;
    }

    public byte getGraphique() {
        return graphique;
    }

    public void setGraphique(byte graphique) {
        this.graphique = graphique;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }

    public byte getPreRemplie() {
        return preRemplie;
    }

    public void setPreRemplie(byte preRemplie) {
        this.preRemplie = preRemplie;
    }

    public Double getMinimum() {
        return minimum;
    }

    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    public Double getMaximum() {
        return maximum;
    }

    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    public byte getObligatoire() {
        return obligatoire;
    }

    public void setObligatoire(byte obligatoire) {
        this.obligatoire = obligatoire;
    }

    public Timestamp getDateSuppr() {
        return dateSuppr;
    }

    public void setDateSuppr(Timestamp dateSuppr) {
        this.dateSuppr = dateSuppr;
    }

    public Timestamp getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Timestamp dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Timestamp getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Timestamp dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    @Override
    public String toString() {
        return "Mesure{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", label='" + label + '\'' +
                ", unite='" + unite + '\'' +
                ", position=" + position +
                ", typeMesure=" + typeMesure +
                ", graphique=" + graphique +
                ", genre=" + genre +
                ", preRemplie=" + preRemplie +
                ", minimum=" + minimum +
                ", maximum=" + maximum +
                ", obligatoire=" + obligatoire +
                ", dateSuppr=" + dateSuppr +
                ", dateAjout=" + dateAjout +
                ", dateRetrait=" + dateRetrait +
                '}';
    }
}
