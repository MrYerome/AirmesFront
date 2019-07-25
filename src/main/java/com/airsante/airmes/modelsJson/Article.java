package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class Article extends ResourceSupport {
    private Link id;
    private Long dataId;
    private String code;
    private String nom;
    private String codeBarres;
    private String commentaire;
    private byte suspendu;
    private String photo;
    private String referenceFabricant;
    private FamilleArticle familleArticleByFamilleArticleId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodeBarres() {
        return codeBarres;
    }

    public void setCodeBarres(String codeBarres) {
        this.codeBarres = codeBarres;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public byte getSuspendu() {
        return suspendu;
    }

    public void setSuspendu(byte suspendu) {
        this.suspendu = suspendu;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getReferenceFabricant() {
        return referenceFabricant;
    }

    public void setReferenceFabricant(String referenceFabricant) {
        this.referenceFabricant = referenceFabricant;
    }

    public FamilleArticle getFamilleArticleByFamilleArticleId() {
        return familleArticleByFamilleArticleId;
    }

    public void setFamilleArticleByFamilleArticleId(FamilleArticle familleArticleByFamilleArticleId) {
        this.familleArticleByFamilleArticleId = familleArticleByFamilleArticleId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", codeBarres='" + codeBarres + '\'' +
                ", commentaire='" + commentaire + '\'' +
                ", suspendu=" + suspendu +
                ", photo='" + photo + '\'' +
                ", referenceFabricant='" + referenceFabricant + '\'' +
                ", familleArticleByFamilleArticleId=" + familleArticleByFamilleArticleId +
                '}';
    }
}
