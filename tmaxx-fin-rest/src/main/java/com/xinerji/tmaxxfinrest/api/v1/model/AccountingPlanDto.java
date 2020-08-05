package com.xinerji.tmaxxfinrest.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
public class AccountingPlanDto {

    @ApiModelProperty(value="This is the id of accounting plan", required = false)
    private Long id;

    private String code;

    private String accountName;

    private String description;

    private Long accountingYear;

    private Boolean canReceiptIn;

    private String currencyCode;

    private Boolean isParentAccount;

    private Long accountLevel;

    private String parentAccount;

    private Boolean isBlocked;

    private Long firmId;

    private String opr;

    private Boolean tmpBlocked;

    private String accountType;

    private String referenceCode;

    private String groupCode;

    private Boolean isVip;
}
