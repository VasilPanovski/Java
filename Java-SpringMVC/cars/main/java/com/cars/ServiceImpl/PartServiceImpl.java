package com.cars.ServiceImpl;

import com.cars.entities.Part;
import com.cars.models.bindingModels.AddPartModel;
import com.cars.models.viewModels.PartViewModel;
import com.cars.repositories.PartRepository;
import com.cars.servicies.PartService;
import com.cars.utils.modelParser.interfaces.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PartServiceImpl implements PartService {
    @Autowired
    private PartRepository partRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public List<PartViewModel> getAllParts() {
        List<Part> parts = this.partRepository.findAll();
        List<PartViewModel> partViewModels = new ArrayList<>(parts.size());

        PartViewModel partViewModel = null;
        for (Part part : parts) {
            partViewModel = this.modelParser.convert(part, PartViewModel.class);
            partViewModels.add(partViewModel);
        }

        return partViewModels;
    }

    @Override
    public void savePart(AddPartModel addPartModel) {
        Part part = this.modelParser.convert(addPartModel, Part.class);
        this.partRepository.saveAndFlush(part);
    }

    @Override
    public PartViewModel getPartById(long id) {
        Part part = this.partRepository.findOne(id);
        PartViewModel partViewModel = this.modelParser.convert(part, PartViewModel.class);

        return partViewModel;
    }

    @Override
    public void deletePart(PartViewModel partViewModel) {
        Part part = this.modelParser.convert(partViewModel, Part.class);
        this.partRepository.delete(part);
    }

    @Transactional
    @Override
    public void update(PartViewModel partViewModel) {
        this.partRepository.update(partViewModel.getPrice(), partViewModel.getQuantity(), partViewModel.getId());
    }
}
