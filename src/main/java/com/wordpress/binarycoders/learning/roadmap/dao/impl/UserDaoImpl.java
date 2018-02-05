package com.wordpress.binarycoders.learning.roadmap.dao.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wordpress.binarycoders.learning.roadmap.dao.custom.UserDaoCustom;
import com.wordpress.binarycoders.learning.roadmap.entity.QUser;
import com.wordpress.binarycoders.learning.roadmap.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDaoCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User toExemplifyQueryDsl(final Long id) {
		final JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		final QUser qUser = QUser.user;

		return queryFactory.selectFrom(qUser)
				.where(qUser.id.eq(id)).fetchOne();
	}
}
