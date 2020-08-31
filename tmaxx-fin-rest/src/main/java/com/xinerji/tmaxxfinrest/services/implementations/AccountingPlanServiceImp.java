package com.xinerji.tmaxxfinrest.services.implementations;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.data.repositories.AccountingPlanRepository;
import com.xinerji.tmaxxfinrest.services.interfaces.AccountingPlanService;
import org.springframework.stereotype.Service;

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
        //TODO check if company exists. not exists than throw not found exception.

        /*if(!isFirmExists){
            throw new ResourceNotFoundException();
        }*/

        return this.accountingPlanRepository.findByFirmId(id);
    }
}
