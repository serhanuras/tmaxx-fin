package com.xinerji.tmaxxfinrest.data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="muh_hesap_plani")
public class AccountingPlan extends BaseEntity {

    @Column(name="code")
    private String code;

    @Column(name="hesapadi")
    private String accountName;

    @Column(name="aciklama")
    private String description;

    @Column(name="maliyil")
    private Long accountingYear;

    @Column(name="fisgirilir")
    private Boolean canReceiptIn;

    @Column(name="curr")
    private String currencyCode;

    @Column(name="isparent")
    private Boolean isParentAccount;

    @Column(name="level")
    private Long accountLevel;

    @Column(name="ust_hkod")
    private String parentAccount;

    @Column(name="blocked")
    private Boolean isBlocked;

    @Column(name="opr")
    private String opr;

    @Column(name="tmp_blocked")
    private Boolean tmpBlocked;

    @Column(name="acctype")
    private String accountType;

    @Column(name="refcode")
    private String referenceCode;

    @Column(name="groupcode")
    private String groupCode;

    @Column(name="is_vip")
    private Boolean isVip;

}
