package com.xinerji.tmaxxfinrest.data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "firms")
public class Firm extends BaseEntity {

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "port")
  private int port;

  @Column(name = "title")
  private String title;

  @Column(name = "isgl")
  private boolean isGl;

  @Column(name = "address")
  private String address;

  @Column(name = "postalCode")
  private String postalCode;

  @Column(name = "district")
  private String district;

  @Column(name = "city")
  private String city;

  @Column(name = "coun")
  private String countryCode;
}
