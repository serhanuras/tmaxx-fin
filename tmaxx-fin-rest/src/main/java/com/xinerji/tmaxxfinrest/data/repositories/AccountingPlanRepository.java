package com.xinerji.tmaxxfinrest.data.repositories;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AccountingPlanRepository extends JpaRepository<AccountingPlan, Long> {

    public List<AccountingPlan> findByFirmId(long id);




}
