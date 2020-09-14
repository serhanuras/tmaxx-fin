package com.xinerji.tmaxxfinrest.services.implementations;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.data.model.BaseEntity;
import com.xinerji.tmaxxfinrest.data.repositories.AccountingPlanRepository;
import com.xinerji.tmaxxfinrest.expections.BadRequestException;
import com.xinerji.tmaxxfinrest.resourcebundles.AccountingPlanResourceBundles;
import com.xinerji.tmaxxfinrest.resourcebundles.GeneralResourceBundles;
import com.xinerji.tmaxxfinrest.resourcebundles.Resource;
import com.xinerji.tmaxxfinrest.services.interfaces.ICrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public abstract class ServiceBase<TEntity extends BaseEntity>
    implements ICrudService<TEntity, Long> {

  private JpaRepository<TEntity, Long> repository;

  public ServiceBase(JpaRepository<TEntity, Long> repository) {
    this.repository = repository;
  }

  @Override
  public List<TEntity> findAll() {
    List<TEntity> entities = new ArrayList<>();
    repository.findAll().forEach(entities::add);
    return entities;
  }

  @Override
  public TEntity findById(Long aLong) {
    Optional<TEntity> optional = repository.findById(aLong);

    if (optional.isPresent()) {
      return optional.get();
    } else {
      return null;
    }
  }

  @Override
  public TEntity save(TEntity entity) {
    return repository.save(entity);
  }

  @Override
  public void deleteById(Long id) {
    Optional<TEntity> optional = repository.findById(id);
    if (!optional.isPresent()) {
      throw new BadRequestException(
          Resource.getInstance().getString(GeneralResourceBundles.NOT_FOUND));
    }

    repository.deleteById(id);
  }

  @Override
  public void delete(TEntity entity) {
    this.deleteById(entity.getId());
  }
}
