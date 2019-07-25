package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class TypeIntervention extends ResourceSupport {
    private Link id;
    private String label;

    @Override
    public Link getId() {
        return id;
    }

    public void setId(Link id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "TypeIntervention{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
