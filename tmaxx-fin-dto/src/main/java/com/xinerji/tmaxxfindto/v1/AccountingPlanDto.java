package com.xinerji.tmaxxfindto.v1;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AccountingPlanDto {

  @ApiModelProperty(value = "This is the id of accounting plan", required = false)
  private Long id;

  @NotBlank
  @Size(max = 24, message = "Code should have max 24 characters")
  private String code;

  @NotBlank
  @Size(max = 100, message = "AccountName should have max 100 characters")
  private String accountName;

  @Size(max = 150, message = "Description should have max 150 characters")
  private String description;

  @DecimalMin(value = "2000", message = "Accounting Year should be bigger than 2000 characters")
  private Long accountingYear;

  private Boolean canReceiptIn = false;

  private String currencyCode;

  private Boolean isParentAccount = false;

  private Long accountLevel;

  @NotEmpty
  @Size(max = 25)
  private String parentAccount;

  private Boolean isBlocked = false;

  private Long firmId;

  private String opr;

  private Boolean tmpBlocked = false;

  private String accountType;

  @Size(max = 25, message = "AccountName should have max 25 characters")
  private String referenceCode;

  @Size(max = 5, message = "AccountName should have max 5 characters")
  private String groupCode;

  private Boolean isVip = false;
}
