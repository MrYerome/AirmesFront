package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

public class ListeId
		extends ResourceSupport
{
	private Link id;
	private Long dataId;


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

}
