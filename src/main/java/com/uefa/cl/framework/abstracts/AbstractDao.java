package com.uefa.cl.framework.abstracts;

import com.uefa.cl.framework.generic.GenericDao;
import com.uefa.cl.framework.generic.GenericEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;


public class AbstractDao<E extends GenericEntity> extends SimpleJpaRepository<E, Long> implements GenericDao<E> {

    public AbstractDao(JpaEntityInformation<E, Long> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

}
