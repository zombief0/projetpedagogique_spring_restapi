package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.CycleRepository;
import com.scx.scoma.entities.entities_projet_ped.Cycle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CycleServiceImpl implements CycleService{

    private CycleRepository cycleRepository;

    public CycleServiceImpl(CycleRepository cycleRepository) {
        this.cycleRepository = cycleRepository;
    }


    @Override
    public Cycle findCycleById(Long id) {
        return cycleRepository.findByScxIdCycle(id);
    }

    @Override
    public Cycle saveCycle(Cycle cycle) {
        return cycleRepository.save(cycle);
    }

    @Override
    public List<Cycle> listCycle() {
        return cycleRepository.findAll();
    }

    @Override
    public void deleteCycle(Long id) {
        cycleRepository.deleteById(id);
    }

    @Override
    public Cycle updateCycle(Long scxIdCycle, Cycle cycle) {
        cycle.setScxIdCycle(scxIdCycle);
        return cycleRepository.save(cycle);
    }
}
