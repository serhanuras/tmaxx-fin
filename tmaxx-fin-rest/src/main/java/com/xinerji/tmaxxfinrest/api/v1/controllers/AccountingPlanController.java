package com.xinerji.tmaxxfinrest.api.v1.controllers;

import com.xinerji.tmaxxfindto.v1.AccountingPlanDto;
import com.xinerji.tmaxxfinrest.api.v1.mapper.AccountingPlanMapper;
import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.services.interfaces.IAccountingPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description = "Account Planing Restful APIs")
@RestController
@RequestMapping(AccountingPlanController.BASE_URL)
@Slf4j
public class AccountingPlanController  {
    public static final String BASE_URL = "/api/v1/account-plan";

    private final AccountingPlanMapper accountingPlanMapper;
    private final IAccountingPlanService accountingPlanService;

    public AccountingPlanController(AccountingPlanMapper accountingPlanMapper,
                                    IAccountingPlanService accountingPlanService) {
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
    @GetMapping("/by-firm-id/{id}/{accountingYear}/{accountLevel}/{parentAccount}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountingPlanDto> getAccountingPlanByFirmId(@PathVariable Long id,
                                                          @PathVariable long accountingYear,
                                                          @PathVariable long accountLevel,
                                                          @PathVariable String parentAccount){

        List<AccountingPlan> accountingPlans =
                accountingPlanService.findByFirmId(id,accountingYear,accountLevel,parentAccount);
        return AccountingPlanMapper.INSTANCE.fromAccountingPlanList(accountingPlans);
    }


    @ApiOperation(
            value = "This service inserts new accounting plan for the company",
            notes = "This service inserts new accounting plan for the company")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    response = AccountingPlanDto.class,
                    responseContainer = "",
                    message = "The new accounting plan."),
            @ApiResponse(
                    code = 400,
                    response = String.class,
                    responseContainer = "",
                    message = "Bad Request")
    }
    )
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public AccountingPlan insertAccountingPlan(@Valid @RequestBody AccountingPlanDto accountingPlanDto){

        return accountingPlanService
                .insertAccountingPlan(
                        AccountingPlanMapper.INSTANCE.toAccountingPlan(accountingPlanDto));
    }


    @ApiOperation(
            value = "This service update existing accounting plan for the company",
            notes = "This service update existing accounting plan for the company")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    response = AccountingPlanDto.class,
                    responseContainer = "",
                    message = "The updated accounting plan."),
            @ApiResponse(
                    code = 400,
                    response = String.class,
                    responseContainer = "",
                    message = "Bad Request")
    }
    )
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public AccountingPlan updateAccountingPlan(@RequestBody @Valid AccountingPlanDto accountingPlanDto){

        return accountingPlanService
                .updateAccountingPlan(
                        AccountingPlanMapper.INSTANCE.toAccountingPlan(accountingPlanDto));
    }

    @ApiOperation(
            value = "This service delete existing accounting plan for the company",
            notes = "This service delete existing accounting plan for the company")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    response = AccountingPlanDto.class,
                    responseContainer = "",
                    message = "The updated accounting plan."),
            @ApiResponse(
                    code = 400,
                    response = String.class,
                    responseContainer = "",
                    message = "Bad Request"),
            @ApiResponse(
                    code = 404,
                    response = String.class,
                    responseContainer = "",
                    message = "Not Found")
    }
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountingPlan(@PathVariable Long id){
        accountingPlanService.deleteById(id);
    }
}
