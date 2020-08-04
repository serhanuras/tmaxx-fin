package com.xinerji.tmaxxfindata.repositories;

import com.xinerji.tmaxxfindata.model.AccountingPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AccountingPlanRepository extends CrudRepository<AccountingPlan, Long> {

    public List<AccountingPlan> findByFirmId(long id);
}
