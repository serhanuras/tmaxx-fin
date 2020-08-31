package com.xinerji.tmaxxfinrest.data.repositories;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AccountingPlanRepository extends JpaRepository<AccountingPlan, Long> {

    @Query("SELECT a FROM AccountingPlan a  WHERE (a.firmId is null or a.firmId= :firmId) and a.accountingYear= :accountingYear and a.accountLevel= :accountLevel and (:parentAccount is null or a.parentAccount = :parentAccount) order by a.code")
    List<AccountingPlan> findByFirmId(@Param("firmId") long firmId, @Param("accountingYear") long accountingYear, @Param("accountLevel") long accountLevel, @Param("parentAccount") String parentAccount);

    @Query(value = "SELECT max(a.accountLevel) FROM AccountingPlan a WHERE (a.firmId is null or a.firmId= :firmId) and a.accountingYear= :accountingYear")
    int getMaxAccountingLevel(long firmId, long accountingYear);

}
