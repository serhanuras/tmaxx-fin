package com.xinerji.tmaxxfinrest.services.implementations;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.data.repositories.AccountingPlanRepository;
import com.xinerji.tmaxxfinrest.expections.BadRequestException;
import com.xinerji.tmaxxfinrest.resourcebundles.AccountingPlanResourceBundles;
import com.xinerji.tmaxxfinrest.resourcebundles.Resource;
import com.xinerji.tmaxxfinrest.services.interfaces.IAccountingPlanService;
import com.xinerji.tmaxxfinrest.services.interfaces.IFirmService;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class AccountingPlanService implements IAccountingPlanService {

    private final AccountingPlanRepository accountingPlanRepository;
    private final IFirmService firmService;

    public AccountingPlanService(
            AccountingPlanRepository accountingPlanRepository,
            IFirmService firmService
    ) {
        this.accountingPlanRepository = accountingPlanRepository;
        this.firmService = firmService;
    }

    @Override
    public Set<AccountingPlan> findAll() {
        Set<AccountingPlan> accountingPlans = new HashSet<>();
        this.accountingPlanRepository.findAll().forEach(accountingPlans::add);
        return accountingPlans;
    }

    @Override
    public AccountingPlan findById(Long aLong) {
        Optional<AccountingPlan> optional = this.accountingPlanRepository.findById(aLong);

        if(optional.isPresent()){
            return optional.get();
        }
        else{
            return null;
        }
    }


    @Override
    public AccountingPlan save(AccountingPlan accountingPlan) {

        if(accountingPlan.getParentAccount()!= null){
            AccountingPlan parentAccountPlan =
                    this.accountingPlanRepository.findParentAccountingPlan(
                            accountingPlan.getFirmId(),
                            accountingPlan.getAccountingYear(),
                            accountingPlan.getParentAccount());

            if(parentAccountPlan.getCanReceiptIn()){
                throw new BadRequestException(Resource.getInstance()
                        .getString(AccountingPlanResourceBundles.CAN_CREATE_ACCOUNT_FOR_RECEIPT_ACCOUNT));
            }

            if(accountingPlan.getFirmId()==null){
                throw new BadRequestException(Resource.getInstance()
                        .getString(AccountingPlanResourceBundles.FIRM_NOT_FOUND));
            }

            if(accountingPlan.getId()==null){
                if(accountingPlanRepository.existsAccountingPlan(accountingPlan.getFirmId(),
                        accountingPlan.getAccountingYear(),
                        accountingPlan.getCode())){
                    throw new BadRequestException(Resource.getInstance()
                            .getString(AccountingPlanResourceBundles.RESOURCE_PLAN_EXITS));
                }
            }

            accountingPlan.setAccountLevel(parentAccountPlan.getAccountLevel()+1);
        }
        else{
            throw new BadRequestException(Resource.getInstance()
                    .getString(AccountingPlanResourceBundles.CAN_NOT_CREATE_PARENT_ACCOUNT));
        }

        return this.accountingPlanRepository.save(accountingPlan);
    }

    @Override
    public AccountingPlan insertAccountingPlan(AccountingPlan accountingPlan) {
        accountingPlan.setId(null);
        return this.save(accountingPlan);
    }

    @Override
    public AccountingPlan updateAccountingPlan(AccountingPlan accountingPlan) {

        if(this.accountingPlanRepository.findById(accountingPlan.getId())==null)
            throw new BadRequestException(Resource.getInstance()
                    .getString(AccountingPlanResourceBundles.ACCOUNTING_PLAN_NOT_FOUND));

        return this.save(accountingPlan);
    }

    private void delete(Long id){
        Optional<AccountingPlan> optional = this.accountingPlanRepository.findById(id);
        if(!optional.isPresent()){
            throw new BadRequestException(Resource.getInstance()
                    .getString(AccountingPlanResourceBundles.FIRM_NOT_FOUND));
        }

       AccountingPlan accountingPlan= optional.get();

        if(this.accountingPlanRepository.hasSubAccountingPlan(
                accountingPlan.getFirmId(),
                accountingPlan.getAccountingYear(),
                accountingPlan.getCode())){
            throw new BadRequestException(Resource.getInstance()
                    .getString(AccountingPlanResourceBundles.HAS_SUB_ACCOUNT));
        }

        accountingPlanRepository.deleteById(id);
    }


    @Override
    public void delete(AccountingPlan firm) {
        delete(firm.getId());
    }

    @Override
    public void deleteById(Long id) {
        delete(id);
    }



    @Override
    public List<AccountingPlan> findByFirmId(long id, long accountingYear, long accountingLevel, String parentAccount) {

        if(firmService.findById(id)==null){
            throw new BadRequestException(Resource.getInstance()
                    .getString(AccountingPlanResourceBundles.FIRM_NOT_FOUND));
        }

        if(parentAccount!=null && parentAccount.equals("root")){
            parentAccount = null;
        }

        List<AccountingPlan> accountingPlans = this.accountingPlanRepository.findByFirmId(id, accountingYear, accountingLevel, parentAccount);

        return accountingPlans;
    }



}
