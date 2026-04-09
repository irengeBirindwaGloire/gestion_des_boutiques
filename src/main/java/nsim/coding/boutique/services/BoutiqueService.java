package nsim.coding.boutique.services;

import nsim.coding.boutique.dtos.BoutiqueDto;
import nsim.coding.boutique.enums.EtatBoutique;

import org.springframework.data.domain.Page;


public interface BoutiqueService {

    public BoutiqueDto createBoutique(BoutiqueDto boutiqueDto);

    public BoutiqueDto getBoutiqueById(Long id);

    public BoutiqueDto updateBoutique(Long id, BoutiqueDto boutiqueDto);

    public void deleteBoutique(Long id);

    public BoutiqueDto changeEtatBoutique(Long id, EtatBoutique etat);

    public Page<BoutiqueDto> getAllBoutiques(int page, int size);
}
