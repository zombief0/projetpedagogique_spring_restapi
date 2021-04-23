package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Cycle;

import java.util.List;

public interface CycleService {

    Cycle findCycleById(Long id);

    Cycle saveCycle(Cycle cycle);

    List<Cycle> listCycle();

    void deleteCycle(Long id);

    Cycle updateCycle(Long scxIdCycle, Cycle cycle);
}
