package com.xinerji.tmaxxfinrest.api.v1.mapper;

import com.xinerji.tmaxxfindata.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.api.v1.model.AccountingPlanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountingPlanMapper {

    AccountingPlanMapper INSTANCE = Mappers.getMapper(AccountingPlanMapper.class);

    AccountingPlanDto fromAccountingPlan(AccountingPlan accountingPlan);

}
