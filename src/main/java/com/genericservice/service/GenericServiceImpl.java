package com.genericservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.genericservice.dao.GenericDao;

@Service
public abstract class GenericServiceImpl<E, K> implements GenericService<E, K> {

	private GenericDao<E, K> genericDao;

	public GenericServiceImpl(GenericDao<E, K> genericDao) {
		this.genericDao = genericDao;
	}

	public GenericServiceImpl() {
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(E entity) {
		genericDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> getAll() {
		return genericDao.getAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public E get(K id) {
		return genericDao.find(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(E entity) {
		genericDao.add(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(E entity) {
		genericDao.update(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(E entity) {
		genericDao.remove(entity);
	}
}
