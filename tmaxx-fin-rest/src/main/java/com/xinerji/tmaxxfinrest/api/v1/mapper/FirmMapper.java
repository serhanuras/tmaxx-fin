package com.xinerji.tmaxxfinrest.api.v1.mapper;

import com.xinerji.tmaxxfindto.v1.AccountingPlanDto;
import com.xinerji.tmaxxfindto.v1.FirmDto;
import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.data.model.Firm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FirmMapper {

  FirmMapper INSTANCE = Mappers.getMapper(FirmMapper.class);

  FirmDto fromFirm(Firm firm);

  Firm toFirm(FirmDto firm);

  List<FirmDto> fromFirmList(List<Firm> firms);

  List<FirmDto> toFirmList(List<FirmDto> firmDtos);
}
