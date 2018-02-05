package com.wordpress.binarycoders.learning.roadmap.entity;

import com.wordpress.binarycoders.learning.roadmap.dto.UserDto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "user")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends AbstractPersistable<Long> {

	private String username;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Roadmap roadmap;

	public UserDto toDto() {
		return new UserDto()
				.setId(this.getId())
				.setUsername(this.username);
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(final String username) {
		this.username = username;
		return this;
	}

	public Roadmap getRoadmap() {
		return roadmap;
	}

	public User setRoadmap(final Roadmap roadmap) {
		this.roadmap = roadmap;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final User user = (User) o;

		return new EqualsBuilder()
				.appendSuper(super.equals(o))
				.append(username, user.username)
				.append(roadmap, user.roadmap)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.appendSuper(super.hashCode())
				.append(username)
				.append(roadmap)
				.toHashCode();
	}
}
