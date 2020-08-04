package com.xinerji.tmaxxfinrest.api.v1.controllers;

import com.xinerji.tmaxxfinrest.api.v1.mapper.AccountingPlanMapper;
import com.xinerji.tmaxxfinrest.api.v1.model.AccountingPlanDto;
import com.xinerji.tmaxxfinservices.interfaces.AccountingPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(AccountingPlanController.BASE_URL)
public class AccountingPlanController {
    public static final String BASE_URL = "/api/v1/account-plan";

    private final AccountingPlanMapper accountingPlanMapper;
    private final AccountingPlanService accountingPlanService;

    public AccountingPlanController(AccountingPlanMapper accountingPlanMapper, AccountingPlanService accountingPlanService) {
        this.accountingPlanMapper = accountingPlanMapper;
        this.accountingPlanService = accountingPlanService;
    }

    @GetMapping("/by-firm-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountingPlanDto> getAccountingPlanByFirmId(@PathVariable Long id){
        return accountingPlanService.findByFirmId(id)
                .stream().map(accountingPlanMapper::fromAccountingPlan)
                .collect(Collectors.toList());
    }
}
