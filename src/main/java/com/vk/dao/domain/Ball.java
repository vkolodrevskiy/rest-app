package com.vk.dao.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Represents ball.
 *
 * @author vkolodrevskiy
 */
@Entity
public class Ball {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=1, max=14)
    private String color;
    private Double radius;

	// user should not be able to see id
    @JsonIgnore
    public Long getId() {
        return id;
    }

	// user should not be able to setup id
	@JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
