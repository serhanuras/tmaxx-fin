package com.xinerji.tmaxxfinservices.interfaces;

import com.xinerji.tmaxxfindata.model.AccountingPlan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import  com.xinerji.tmaxxfinservices.interfaces.CrudService;

@Service
public interface AccountingPlanService extends CrudService<AccountingPlan,Long>{

    List<AccountingPlan> findByFirmId(long id);

}
