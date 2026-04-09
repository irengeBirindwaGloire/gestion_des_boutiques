package nsim.coding.boutique.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import nsim.coding.boutique.dtos.ApprovisionnementDto;
import nsim.coding.boutique.dtos.BoutiqueDto;

@Service
public interface ApprovisionnementService {

    public ApprovisionnementDto createApprovisionnement(ApprovisionnementDto app);

    public ApprovisionnementDto updateApprovisionnement(ApprovisionnementDto app);

    public void deleteApprovisionnement(Long id);

    public Page<ApprovisionnementDto> getAllApprovisionnements(int page, int size);

    public Page<ApprovisionnementDto> getAllApprovByBoutique(Long id, BoutiqueDto boutiqueDto, int page, int size);

    // public ApprovisionnementDto changeSeuilApprovByBoutique(Long id, BoutiqueDto boutiqueDto, int seuil);
}
