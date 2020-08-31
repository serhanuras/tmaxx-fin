package com.xinerji.tmaxxfinrest.api.v1.mapper;

import com.xinerji.tmaxxfindto.v1.*;
import com.xinerji.tmaxxfinrest.data.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountingPlanMapper {

    AccountingPlanMapper INSTANCE = Mappers.getMapper(AccountingPlanMapper.class);

    AccountingPlanDto fromAccountingPlan(AccountingPlan accountingPlan);

}
