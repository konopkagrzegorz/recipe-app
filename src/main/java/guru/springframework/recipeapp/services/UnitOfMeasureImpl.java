package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.model.UnitOfMeasure;
import guru.springframework.recipeapp.repository.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UnitOfMeasureImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public UnitOfMeasureImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public List<UnitOfMeasure> findAll() {

        //Set<UnitOfMeasure> uoms = new HashSet<>();
        //unitOfMeasureRepository.findAll().iterator().forEachRemaining(uoms::add);

        return (List<UnitOfMeasure>) unitOfMeasureRepository.findAll();
    }

    @Override
    public Optional<UnitOfMeasure> findByUom(String uom) {
        return unitOfMeasureRepository.findByUom(uom);
    }

    @Override
    public void save(UnitOfMeasure uom) {
        unitOfMeasureRepository.save(uom);
    }

    @Override
    public void deleteById(Long id) {
        unitOfMeasureRepository.deleteById(id);
    }
}
