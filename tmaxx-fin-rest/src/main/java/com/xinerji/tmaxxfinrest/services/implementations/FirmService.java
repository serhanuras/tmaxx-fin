package com.xinerji.tmaxxfinrest.services.implementations;

import com.xinerji.tmaxxfinrest.data.model.AccountingPlan;
import com.xinerji.tmaxxfinrest.data.model.Firm;
import com.xinerji.tmaxxfinrest.data.repositories.FirmRepository;
import com.xinerji.tmaxxfinrest.services.interfaces.IFirmService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FirmService extends ServiceBase<Firm> implements IFirmService {

  private final FirmRepository firmRepository;

  public FirmService(FirmRepository firmRepository) {
    super(firmRepository);
    this.firmRepository = firmRepository;
  }
}
