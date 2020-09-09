package com.xinerji.tmaxxfinrest;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.services.interfaces.IAccountingPlanService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TmaxxFinRestApplicationTests {

    @Autowired
    private IAccountingPlanService accountingPlanService;

    @Test
    void contextLoads() {
    }

    @Test
    void findByFirmId() throws Exception{
       List<AccountingPlan> accountingPlanList =
               accountingPlanService.findByFirmId(1,2020, 1, "");


        assertNotEquals(accountingPlanList.size(),0);
    }

    @Test
    void insertAccountingPlan() throws  Exception{
        AccountingPlan accountingPlan = new AccountingPlan();
        accountingPlan.setParentAccount("86");
        accountingPlan.setCode("86 03");
        accountingPlan.setAccountName("serhans account");

        AccountingPlan insertAccountingPlan =accountingPlanService.insertAccountingPlan(accountingPlan);

        assertNotEquals(insertAccountingPlan.getId(),0);
        assertNotEquals(insertAccountingPlan.getId(), null);

    }

}
