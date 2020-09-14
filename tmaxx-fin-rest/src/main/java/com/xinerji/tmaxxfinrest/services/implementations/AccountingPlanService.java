package com.xinerji.tmaxxfinrest.services.implementations;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.data.model.BaseEntity;
import com.xinerji.tmaxxfinrest.data.repositories.AccountingPlanRepository;
import com.xinerji.tmaxxfinrest.expections.BadRequestException;
import com.xinerji.tmaxxfinrest.resourcebundles.AccountingPlanResourceBundles;
import com.xinerji.tmaxxfinrest.resourcebundles.Resource;
import com.xinerji.tmaxxfinrest.services.interfaces.IAccountingPlanService;
import com.xinerji.tmaxxfinrest.services.interfaces.IFirmService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountingPlanService extends ServiceBase<AccountingPlan>
    implements IAccountingPlanService {

  private final AccountingPlanRepository accountingPlanRepository;
  private final IFirmService firmService;

  public AccountingPlanService(
      AccountingPlanRepository accountingPlanRepository, IFirmService firmService) {
    super(accountingPlanRepository);
    this.accountingPlanRepository = accountingPlanRepository;
    this.firmService = firmService;
  }

  private void UpsetValidation(AccountingPlan accountingPlan) {
    if (accountingPlan.getParentAccount() != null) {
      AccountingPlan parentAccountPlan =
          this.accountingPlanRepository.findParentAccountingPlan(
              accountingPlan.getFirmId(),
              accountingPlan.getAccountingYear(),
              accountingPlan.getParentAccount());

      if (parentAccountPlan.getCanReceiptIn()) {
        throw new BadRequestException(
            Resource.getInstance()
                .getString(AccountingPlanResourceBundles.CAN_CREATE_ACCOUNT_FOR_RECEIPT_ACCOUNT));
      }

      if (accountingPlan.getFirmId() == null) {
        throw new BadRequestException(
            Resource.getInstance().getString(AccountingPlanResourceBundles.FIRM_NOT_FOUND));
      }

      if (accountingPlan.getId() == null) {
        if (accountingPlanRepository.existsAccountingPlan(
            accountingPlan.getFirmId(),
            accountingPlan.getAccountingYear(),
            accountingPlan.getCode())) {
          throw new BadRequestException(
              Resource.getInstance().getString(AccountingPlanResourceBundles.RESOURCE_PLAN_EXITS));
        }
      }

      accountingPlan.setAccountLevel(parentAccountPlan.getAccountLevel() + 1);
    } else {
      throw new BadRequestException(
          Resource.getInstance()
              .getString(AccountingPlanResourceBundles.CAN_NOT_CREATE_PARENT_ACCOUNT));
    }
  }

  @Override
  public AccountingPlan insertAccountingPlan(AccountingPlan accountingPlan) {
    accountingPlan.setId(null);
    UpsetValidation(accountingPlan);
    return super.save(accountingPlan);
  }

  @Override
  public AccountingPlan updateAccountingPlan(AccountingPlan accountingPlan) {
    UpsetValidation(accountingPlan);
    return super.save(accountingPlan);
  }

  @Override
  public void deleteById(Long id) {
    Optional<AccountingPlan> optional = this.accountingPlanRepository.findById(id);
    if (!optional.isPresent()) {
      throw new BadRequestException(
          Resource.getInstance().getString(AccountingPlanResourceBundles.FIRM_NOT_FOUND));
    }

    AccountingPlan accountingPlan = optional.get();

    if (this.accountingPlanRepository.hasSubAccountingPlan(
        accountingPlan.getFirmId(), accountingPlan.getAccountingYear(), accountingPlan.getCode())) {
      throw new BadRequestException(
          Resource.getInstance().getString(AccountingPlanResourceBundles.HAS_SUB_ACCOUNT));
    }

    super.deleteById(id);
  }

  @Override
  public List<AccountingPlan> findByFirmId(
      long id, long accountingYear, long accountingLevel, String parentAccount) {

    if (firmService.findById(id) == null) {
      throw new BadRequestException(
          Resource.getInstance().getString(AccountingPlanResourceBundles.FIRM_NOT_FOUND));
    }

    if (parentAccount != null && parentAccount.equals("root")) {
      parentAccount = null;
    }

    List<AccountingPlan> accountingPlans =
        this.accountingPlanRepository.findByFirmId(
            id, accountingYear, accountingLevel, parentAccount);

    return accountingPlans;
  }
}
