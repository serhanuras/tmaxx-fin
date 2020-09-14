package com.xinerji.tmaxxfinrest.api.v1.controllers;

import com.xinerji.tmaxxfindto.v1.AccountingPlanDto;
import com.xinerji.tmaxxfinrest.api.v1.mapper.AccountingPlanMapper;
import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(DefaultController.BASE_URL)
public class DefaultController {
  public static final String BASE_URL = "/";

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Swagger UI redirection", hidden = true)
  public void root(HttpServletResponse httpResponse) throws Exception {
    httpResponse.sendRedirect("/swagger-ui.html");
  }

  @GetMapping("/swagger")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Swagger UI redirection", hidden = true)
  public void swagger(HttpServletResponse httpResponse) throws Exception {
    httpResponse.sendRedirect("/swagger-ui.html");
  }
}
