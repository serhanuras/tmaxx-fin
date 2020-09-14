package com.xinerji.tmaxxfinrest.api.v1.controllers;

import com.xinerji.tmaxxfindto.v1.AccountingPlanDto;
import com.xinerji.tmaxxfindto.v1.FirmDto;
import com.xinerji.tmaxxfinrest.api.v1.mapper.AccountingPlanMapper;
import com.xinerji.tmaxxfinrest.api.v1.mapper.FirmMapper;
import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.data.model.Firm;
import com.xinerji.tmaxxfinrest.services.interfaces.IAccountingPlanService;
import com.xinerji.tmaxxfinrest.services.interfaces.IFirmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Api(description = "Account Planing Restful APIs")
@RestController
@RequestMapping(FirmController.BASE_URL)
@Slf4j
public class FirmController {
  public static final String BASE_URL = "/api/v1/firm";

  private final IFirmService firmService;

  public FirmController(IFirmService firmService) {
    this.firmService = firmService;
  }

  @ApiOperation(value = "This will get list of firm", notes = "This will get list of firm...")
  @ApiResponses({
    @ApiResponse(
        code = 200,
        response = FirmDto.class,
        responseContainer = "List",
        message = "The list of firm"),
    @ApiResponse(
        code = 404,
        response = String.class,
        responseContainer = "",
        message = "Resource Not Found")
  })
  @GetMapping("/list")
  @ResponseStatus(HttpStatus.OK)
  public List<FirmDto> getFirms() {

    List<Firm> firms = firmService.findAll();
    return FirmMapper.INSTANCE.fromFirmList(firms);
  }

  @ApiOperation(value = "This service upset firm", notes = "This service upset firm")
  @ApiResponses({
    @ApiResponse(
        code = 200,
        response = FirmDto.class,
        responseContainer = "",
        message = "The firm that is upset."),
    @ApiResponse(
        code = 400,
        response = String.class,
        responseContainer = "",
        message = "Bad Request")
  })
  @PostMapping()
  @ResponseStatus(HttpStatus.OK)
  public FirmDto upset(@Valid @RequestBody Firm firm) {

    return FirmMapper.INSTANCE.fromFirm(firmService.save(firm));
  }

  @ApiOperation(
      value = "This service delete existing firm",
      notes = "This service delete existing firm")
  @ApiResponses({
    @ApiResponse(code = 200, response = void.class, responseContainer = "", message = ""),
    @ApiResponse(
        code = 400,
        response = String.class,
        responseContainer = "",
        message = "Bad Request"),
    @ApiResponse(code = 404, response = String.class, responseContainer = "", message = "Not Found")
  })
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteAccountingPlan(@PathVariable Long id) {
    firmService.deleteById(id);
  }
}
