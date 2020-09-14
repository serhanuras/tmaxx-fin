package com.xinerji.tmaxxfindto.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class FirmDto {

  @ApiModelProperty(value = "This is the id of firm", required = false)
  private Long id;

  @NotBlank
  @Size(max = 24, message = "Code should have max 24 characters")
  private String code;

  @NotBlank
  @Size(max = 100, message = "Firm Name should have max 100 characters")
  private String name;

  private int port;

  @NotBlank
  @Size(max = 100, message = "Title should have max 100 characters")
  private String title;

  private boolean isGl;

  private String address;

  private String postalCode;

  private String district;

  private String city;

  private String countryCode;
}
