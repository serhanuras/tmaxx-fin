package com.xinerji.tmaxxfinrest.bootstrap;

import com.xinerji.tmaxxfinrest.services.interfaces.IAccountingPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

  private final IAccountingPlanService accountingPlanService;

  @Autowired
  public DataLoader(IAccountingPlanService accountingPlanService) {
    this.accountingPlanService = accountingPlanService;
  }

  @Override
  public void run(String... args) throws Exception {}
}
