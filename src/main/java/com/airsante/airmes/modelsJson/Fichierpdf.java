package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.Arrays;

public class Fichierpdf extends ResourceSupport {

    private Link id;
    private Long dataId;
    private String nom;
    private String url;
    private Byte extranet;
    private byte[] fichier;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte getExtranet() {
        return extranet;
    }

    public void setExtranet(Byte extranet) {
        this.extranet = extranet;
    }

    public byte[] getFichier() {
        return fichier;
    }

    public void setFichier(byte[] fichier) {
        this.fichier = fichier;
    }

    @Override
    public String toString() {
        return "Fichierpdf{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", nom='" + nom + '\'' +
                ", url='" + url + '\'' +
                ", extranet=" + extranet +
                ", fichier=" + Arrays.toString(fichier) +
                '}';
    }
}
