package com.xinerji.tmaxxfinrest.bootstrap;


import com.xinerji.tmaxxfindata.model.AccountingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.xinerji.tmaxxfinservices.interfaces.*;

import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final AccountingPlanService accountingPlanService;

    @Autowired
    public DataLoader(AccountingPlanService accountingPlanService) {
        this.accountingPlanService = accountingPlanService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<AccountingPlan> accountingPlans =this.accountingPlanService.findByFirmId(1);

        System.out.println(accountingPlans.size());

    }
}
