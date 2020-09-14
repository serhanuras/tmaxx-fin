package com.xinerji.tmaxxfindto.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserSummaryDto {
  private Long id;
  private String name;
  private String email;
}
