package com.xinerji.tmaxxfinrest.services.implementations;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.data.repositories.AccountingPlanRepository;
import com.xinerji.tmaxxfinrest.services.interfaces.AccountingPlanService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountingPlanServiceImp  implements AccountingPlanService {

    private final AccountingPlanRepository accountingPlanRepository;

    public AccountingPlanServiceImp(AccountingPlanRepository accountingPlanRepository) {
        this.accountingPlanRepository = accountingPlanRepository;
    }

    @Override
    public Set<AccountingPlan> findAll() {
        Set<AccountingPlan> owners = new HashSet<>();
        this.accountingPlanRepository.findAll().forEach(owners::add);
        return owners;
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
    public AccountingPlan save(AccountingPlan object) {
        return this.accountingPlanRepository.save(object);
    }

    @Override
    public void delete(AccountingPlan object) {

        this.accountingPlanRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        this.accountingPlanRepository.deleteById(aLong);

    }



    @Override
    public List<AccountingPlan> findByFirmId(long id, long accountingYear, long accountingLevel, String parentAccount) {
        //TODO check if company exists. not exists than throw not found exception.

        if(parentAccount!=null && parentAccount.equals("root")){
            parentAccount = null;
        }

        List<AccountingPlan> accountingPlans = this.accountingPlanRepository.findByFirmId(id, accountingYear, accountingLevel, parentAccount);

        return accountingPlans;
    }

    /*
    public List<AccountingPlan> findByFirmId(long id, long accountingYear) {
        //TODO check if company exists. not exists than throw not found exception.

        int maxLevelIndex = this.accountingPlanRepository.getMaxAccountingLevel(id, accountingYear);
        ArrayList<AccountingPlan>[] accountingPlanArrayList = new  ArrayList[maxLevelIndex];

        List<AccountingPlan> accountingPlanServices = this.accountingPlanRepository.findByFirmId(id, accountingYear);

        accountingPlanServices.forEach(accountingPlan->{
            if(accountingPlanArrayList[accountingPlan.getAccountLevel().intValue()-1]==null)
                accountingPlanArrayList[accountingPlan.getAccountLevel().intValue()-1] = new ArrayList<AccountingPlan>();

            accountingPlanArrayList[accountingPlan.getAccountLevel().intValue()-1].add(accountingPlan);
        });

        for(int i=maxLevelIndex-1;i>0;i--) {
            accountingPlanArrayList[i].forEach(accountingPlan -> {
                int parentIndex = accountingPlan.getAccountLevel().intValue() - 2;
                accountingPlanArrayList[parentIndex].forEach(parentAccountPlan -> {
                    if (parentAccountPlan.getCode().equals(accountingPlan.getParentAccount())) {
                        parentAccountPlan.setSubAccountingPlan(accountingPlan);
                        return;
                    }
                });
            });
            accountingPlanArrayList[i].clear();
        }

        return accountingPlanArrayList[0];
    }
     */


}
