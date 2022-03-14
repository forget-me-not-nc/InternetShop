package com.example.internetshop.services;

import org.springframework.data.domain.Page;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.IGenericService
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 14.03.2022|21:47
 * @Version IGenericService: 1.0
 */

public interface IGenericService<TEntity>
{
	Page<TEntity> getAll(Integer page, Integer size);

	TEntity get(Integer id);

	TEntity update(TEntity entity);

	TEntity create(TEntity entity);

	void delete(Integer id);
}
