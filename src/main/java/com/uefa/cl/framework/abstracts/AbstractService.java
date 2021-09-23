package com.uefa.cl.framework.abstracts;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.uefa.cl.framework.generic.GenericDao;
import com.uefa.cl.framework.generic.GenericEntity;
import com.uefa.cl.framework.generic.GenericService;

@Transactional(rollbackFor = Throwable.class)
public abstract class AbstractService<E extends GenericEntity> implements GenericService<E> {


    @PersistenceContext
    protected EntityManager em;
    @Autowired protected GenericDao<E> dao;



    private Class<E> entityClass;


    public AbstractService() {
        entityClass = getEntityType();
    }

    @SuppressWarnings("unchecked")
    private Class<E> getEntityType() {
        Class<E> entityClassType = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractService.class);
        return entityClassType;
    }

    @Override
    public E actNew() throws Exception {
        E entity = entityClass.newInstance();
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E copy(Long id) throws Exception {
        E entity = (E) dao.getOne(id).clone();
        entity.setId(null);
        return entity;
    }

    @Override
    public E save(E entity) throws Exception {
        return dao.saveAndFlush(entity);
    }

    @Override
    public void delete(E entity) throws Exception {
        dao.delete(entity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        dao.deleteById(id);
        em.flush();
    }

    @Override
    public E getById(Long id) throws Exception {
        return (E) dao.getOne(id);
    }

    @Override
    public E upload(Long id, MultipartFile file) throws Exception {
        return (E) dao.getOne(id);
    }

    public static boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }
}
