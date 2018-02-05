package com.wordpress.binarycoders.learning.roadmap.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "roadmap")
@AttributeOverride(name = "id", column = @Column(name = "certification_id"))
public class Certification extends AbstractPersistable<Long> {

	private String name;

	@ManyToOne
	@JoinColumn(name = "roadmap_id")
	private Roadmap roadmap;

	public String getName() {
		return name;
	}

	public Certification setName(final String name) {
		this.name = name;
		return this;
	}

	public Roadmap getRoadmap() {
		return roadmap;
	}

	public Certification setRoadmap(final Roadmap roadmap) {
		this.roadmap = roadmap;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final Certification that = (Certification) o;

		return new EqualsBuilder()
				.append(name, that.name)
				.append(roadmap, that.roadmap)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.append(roadmap)
				.toHashCode();
	}
}
