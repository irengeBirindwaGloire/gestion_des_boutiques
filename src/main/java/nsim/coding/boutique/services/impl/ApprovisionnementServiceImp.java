package nsim.coding.boutique.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import nsim.coding.boutique.dtos.ApprovisionnementDto;
import nsim.coding.boutique.dtos.BoutiqueDto;
import nsim.coding.boutique.exceptions.EntityNotFoundException;
import nsim.coding.boutique.exceptions.InvalidEntityException;
import nsim.coding.boutique.models.Boutique;
import nsim.coding.boutique.repository.ApprovisionnementRepository;
import nsim.coding.boutique.services.ApprovisionnementService;
import nsim.coding.boutique.services.BoutiqueService;

@Service
public class ApprovisionnementServiceImp implements ApprovisionnementService {

    private final ApprovisionnementRepository approvisionnementRepository;
    private final BoutiqueService boutiqueService;

    public ApprovisionnementServiceImp(ApprovisionnementRepository approvisionnementRepository,
            BoutiqueService boutiqueService) {
        this.approvisionnementRepository = approvisionnementRepository;
        this.boutiqueService = boutiqueService;
    }

    @Override
    public ApprovisionnementDto createApprovisionnement(ApprovisionnementDto app) {
        if (app == null) {
            throw new InvalidEntityException("L'approvisionnement n'est pas valide.");
        }
        return ApprovisionnementDto.fromEntity(
                approvisionnementRepository.save(ApprovisionnementDto.toEntity(app))
        );
    }

    @Override
    public void deleteApprovisionnement(Long id) {
        if (id == null) {
            throw new InvalidEntityException("L'approvisionnement n'est pas valide.");
        }

        ApprovisionnementDto approv = approvisionnementRepository.findById(id)
                .map(ApprovisionnementDto::fromEntity)
                .orElseThrow();
        if (approv == null) {
            throw new InvalidEntityException("L'approvisionnement n'est pas valide.");
        }
        approvisionnementRepository.delete(ApprovisionnementDto.toEntity(approv));
    }

    @Override
    public Page<ApprovisionnementDto> getAllApprovByBoutique(Long id, BoutiqueDto boutiqueDto, int page, int size) {

        Boutique btq = BoutiqueDto.toEntity(boutiqueService.getBoutiqueById(boutiqueDto.getId()));
        if (btq == null) {
            throw new EntityNotFoundException("Aucune boutique n'a été trouver.");
        }

        Page<ApprovisionnementDto> approv = approvisionnementRepository.findByBoutique(btq, PageRequest.of(page, size))
                .map(ApprovisionnementDto::fromEntity);
        return approv;
    }

    @Override
    public Page<ApprovisionnementDto> getAllApprovisionnements(int page, int size) {

        return approvisionnementRepository.findAll(PageRequest.of(page, size))
                .map(ApprovisionnementDto::fromEntity);
    }

    @Override
    public ApprovisionnementDto updateApprovisionnement(ApprovisionnementDto app) {
        if (app == null) {
            throw new InvalidEntityException("null");
        }
        approvisionnementRepository.findById(app.getIdApp())
                .map(ApprovisionnementDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune approvisionnement n'a été trouve."));

        return ApprovisionnementDto.fromEntity(
                approvisionnementRepository.save(ApprovisionnementDto.toEntity(app))
        );
    }

}
