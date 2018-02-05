package com.wordpress.binarycoders.learning.roadmap.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class UserDto implements Serializable {

	private Long id;
	private String username;

	public Long getId() {
		return id;
	}

	public UserDto setId(final Long id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public UserDto setUsername(final String username) {
		this.username = username;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final UserDto userDto = (UserDto) o;

		return new EqualsBuilder()
				.append(id, userDto.id)
				.append(username, userDto.username)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(username)
				.toHashCode();
	}
}
