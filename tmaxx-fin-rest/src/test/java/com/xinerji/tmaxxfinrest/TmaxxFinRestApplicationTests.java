package com.xinerji.tmaxxfinrest;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.data.repositories.AccountingPlanRepository;
import com.xinerji.tmaxxfinrest.services.interfaces.AccountingPlanService;
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
    private AccountingPlanService accountingPlanService;

    @Test
    void contextLoads() {
    }

    @Test
    void findByFirmId() throws Exception{
       List<AccountingPlan> accountingPlanList= accountingPlanService.findByFirmId(1,2020, 1, "");

        assertNotEquals(accountingPlanList.size(),0);
    }

}
