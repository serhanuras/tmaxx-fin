package com.xinerji.tmaxxfinrest.services.implementations;

import com.xinerji.tmaxxfinrest.data.model.Firm;
import com.xinerji.tmaxxfinrest.data.repositories.FirmRepository;
import com.xinerji.tmaxxfinrest.services.interfaces.IFirmService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FirmService implements IFirmService {

    private final FirmRepository firmRepository;

    public FirmService(FirmRepository firmRepository) {
        this.firmRepository = firmRepository;
    }

    @Override
    public Set<Firm> findAll() {
        Set<Firm> firms = new HashSet<>();
        this.firmRepository.findAll().forEach(firms::add);
        return firms;
    }

    @Override
    public Firm findById(Long aLong) {
        Optional<Firm> optional = this.firmRepository.findById(aLong);

        if(optional.isPresent()){
            return optional.get();
        }
        else{
            return null;
        }
    }

    @Override
    public Firm save(Firm firm) {
        return firmRepository.save(firm);
    }

    @Override
    public void delete(Firm firm) {
        firmRepository.delete(firm);
    }

    @Override
    public void deleteById(Long id) {
        firmRepository.deleteById(id);
    }
}
