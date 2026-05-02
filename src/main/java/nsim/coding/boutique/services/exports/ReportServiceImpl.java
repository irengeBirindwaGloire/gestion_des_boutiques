package nsim.coding.boutique.services.exports;

import java.util.List;

import org.springframework.stereotype.Service;

import nsim.coding.boutique.dtos.BoutiqueDto;
import nsim.coding.boutique.repository.BoutiqueRepository;

@Service
public class ReportServiceImpl implements ReportService {

    private final BoutiqueRepository boutiqueRepository;
    public ReportServiceImpl(BoutiqueRepository boutiqueRepository) {
        this.boutiqueRepository = boutiqueRepository;
    }

    @Override
    public List<BoutiqueDto> getStudentsReport() {
        
        return boutiqueRepository.findAll().stream().map(boutique -> {
            BoutiqueDto boutiqueDto = new BoutiqueDto();
            boutiqueDto.setId(boutique.getId());
            boutiqueDto.setDesignation(boutique.getDesignation());
            boutiqueDto.setNomProprietaire(boutique.getNomProprietaire());
            boutiqueDto.setConfigTva(boutique.getConfigTva());
            boutiqueDto.setEtatBoutique(boutique.getEtatBoutique());
            return boutiqueDto;
        }).toList();
    }

}
