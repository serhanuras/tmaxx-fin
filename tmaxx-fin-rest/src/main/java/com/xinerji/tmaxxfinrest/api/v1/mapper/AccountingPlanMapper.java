package com.xinerji.tmaxxfinrest.api.v1.mapper;

import com.xinerji.tmaxxfindto.v1.*;
import com.xinerji.tmaxxfinrest.data.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountingPlanMapper {

  AccountingPlanMapper INSTANCE = Mappers.getMapper(AccountingPlanMapper.class);

  /*
  default AccountingPlanDto fromAccountingPlan(AccountingPlan accountingPlan) {
      AccountingPlanDto accountingPlanDto = new AccountingPlanDto();
      //Do some customization for mapping...

      return accountingPlanDto;
  }
   */

  AccountingPlanDto fromAccountingPlan(AccountingPlan accountingPlan);

  AccountingPlan toAccountingPlan(AccountingPlanDto accountingPlanDto);

  List<AccountingPlanDto> fromAccountingPlanList(List<AccountingPlan> accountingPlans);

  List<AccountingPlan> toAccountingPlanList(List<AccountingPlanDto> accountingPlanDtos);
}
