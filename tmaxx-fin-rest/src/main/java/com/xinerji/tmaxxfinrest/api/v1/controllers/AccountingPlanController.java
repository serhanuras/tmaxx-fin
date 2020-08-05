package com.xinerji.tmaxxfinrest.api.v1.controllers;

import com.xinerji.tmaxxfinrest.api.v1.mapper.AccountingPlanMapper;
import com.xinerji.tmaxxfinrest.api.v1.model.AccountingPlanDto;
import com.xinerji.tmaxxfinservices.interfaces.AccountingPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(description = "Account Planing Restful APIs")
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

    @ApiOperation(
            value="This will get list of accounting plans by firm id",
            notes = "This will get list of accounting plans by firm id...")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    response = AccountingPlanDto.class,
                    responseContainer = "List",
                    message = "The list of accounting plans by firm id"),
            @ApiResponse(
                    code = 404,
                    response = String.class,
                    responseContainer = "",
                    message = "Resource Not Found")
    }
    )
    @GetMapping("/by-firm-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountingPlanDto> getAccountingPlanByFirmId(@PathVariable Long id){

        return accountingPlanService.findByFirmId(id)
                .stream().map(accountingPlanMapper::fromAccountingPlan)
                .collect(Collectors.toList());
    }
}
