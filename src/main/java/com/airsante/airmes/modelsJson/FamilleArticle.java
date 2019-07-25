package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class FamilleArticle extends ResourceSupport {
    private Link id;
    private Long dataId;
    private String label;

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

    @Override
    public String toString() {
        return "FamilleArticle{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", label='" + label + '\'' +
                '}';
    }
}
