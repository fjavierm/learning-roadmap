package com.wordpress.binarycoders.learning.roadmap.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roadmap")
@AttributeOverride(name = "id", column = @Column(name = "roadmap_id"))
public class Roadmap extends AbstractPersistable<Long> {

	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(mappedBy = "roadmap", cascade = CascadeType.ALL)
	private Set<Certification> certifications;

	public String getName() {
		return name;
	}

	public Roadmap setName(final String name) {
		this.name = name;
		return this;
	}

	public User getUser() {
		return user;
	}

	public Roadmap setUser(final User user) {
		this.user = user;
		return this;
	}

	public Set<Certification> getCertifications() {
		return certifications;
	}

	public Roadmap setCertifications(final Set<Certification> certifications) {
		this.certifications = certifications;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final Roadmap roadmap = (Roadmap) o;

		return new EqualsBuilder()
				.appendSuper(super.equals(o))
				.append(name, roadmap.name)
				.append(user, roadmap.user)
				.append(certifications, roadmap.certifications)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.appendSuper(super.hashCode())
				.append(name)
				.append(user)
				.append(certifications)
				.toHashCode();
	}
}
