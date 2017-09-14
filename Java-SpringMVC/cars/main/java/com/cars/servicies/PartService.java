package com.cars.servicies;

import com.cars.models.bindingModels.AddPartModel;
import com.cars.models.viewModels.PartViewModel;

import java.util.List;

public interface PartService {


    List<PartViewModel> getAllParts();

    void savePart(AddPartModel addPartModel);

    PartViewModel getPartById(long id);

    void deletePart(PartViewModel deletePartModel);

    void update(PartViewModel partViewModel);
}
