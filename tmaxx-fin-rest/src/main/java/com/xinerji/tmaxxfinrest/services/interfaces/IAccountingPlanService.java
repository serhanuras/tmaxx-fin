package com.xinerji.tmaxxfinrest.services.interfaces;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAccountingPlanService extends ICrudService<AccountingPlan,Long> {

    List<AccountingPlan> findByFirmId(long id, long accountingYear, long accountingLevel, String parentAccount);

    AccountingPlan insertAccountingPlan(AccountingPlan accountingPlan);

    AccountingPlan updateAccountingPlan(AccountingPlan accountingPlan);





}
