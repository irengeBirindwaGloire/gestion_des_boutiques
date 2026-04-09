package nsim.coding.boutique.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import nsim.coding.boutique.dtos.BoutiqueDto;
import nsim.coding.boutique.enums.EtatBoutique;
import nsim.coding.boutique.exceptions.EntityNotFoundException;
import nsim.coding.boutique.repository.BoutiqueRepository;
import nsim.coding.boutique.services.BoutiqueService;
import org.springframework.data.domain.PageRequest;

@Service
public class BoutiqueServiceImp implements BoutiqueService {

    private final BoutiqueRepository boutiqueRepository;

    public BoutiqueServiceImp(BoutiqueRepository boutiqueRepository) {
        this.boutiqueRepository = boutiqueRepository;
    }
    
    @Override
    public BoutiqueDto createBoutique(BoutiqueDto boutiqueDto) {
        if(boutiqueDto == null) {
            return null;
        }  
        return BoutiqueDto.fromEntity(
                boutiqueRepository.save(
                        BoutiqueDto.toEntity(boutiqueDto) )
        );
    }

    @Override
    public BoutiqueDto getBoutiqueById(Long id) {
        if(id == null) {
            return null;
        }
        return boutiqueRepository.findById(id)
                .map(BoutiqueDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Boutique not found with id: " + id));
    }

    @Override
    public BoutiqueDto updateBoutique(Long id, BoutiqueDto boutiqueDto) {
        if (id == null) {
            throw new EntityNotFoundException("Boutique not found with id: " + id);
        }
        if (boutiqueDto == null) {
            throw new EntityNotFoundException("Boutique not found ");
        }
        if (!boutiqueRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("Boutique not found with id: " + id);
        }
        return BoutiqueDto.fromEntity(
                boutiqueRepository.save(
                        BoutiqueDto.toEntity(boutiqueDto) )
        );
    }

    @Override
    public void deleteBoutique(Long id) {
        if (id == null) {
            return;
        }
        boutiqueRepository.deleteById(id);
    }


    @Override
    public BoutiqueDto changeEtatBoutique(Long id, EtatBoutique etat) {
        if (id == null || etat == null) {
            throw new RuntimeException("Invalid input parameters");
        }
        BoutiqueDto boutiqueDto = getBoutiqueById(id);
        if (boutiqueDto == null) {
            throw new RuntimeException("Boutique not found with id: " + id);
        }
        boutiqueDto.setEtatBoutique(etat);
        return BoutiqueDto.fromEntity(
                boutiqueRepository.save(BoutiqueDto.toEntity(boutiqueDto))
        );
    }

    @Override
    public Page<BoutiqueDto> getAllBoutiques(int page, int size) {
        return boutiqueRepository.findAll(PageRequest.of(page, size))
                .map(BoutiqueDto::fromEntity);
    }

}
