package com.xinerji.tmaxxfinservices.implementations;

import com.xinerji.tmaxxfindata.model.AccountingPlan;
import com.xinerji.tmaxxfinservices.interfaces.AccountingPlanService;
import org.springframework.stereotype.Service;
import com.xinerji.tmaxxfindata.repositories.AccountingPlanRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public List<AccountingPlan> findByFirmId(long id) {
        return this.accountingPlanRepository.findByFirmId(id);
    }
}