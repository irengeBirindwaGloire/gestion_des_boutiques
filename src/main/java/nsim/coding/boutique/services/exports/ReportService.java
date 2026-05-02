package nsim.coding.boutique.services.exports;

import java.util.List;

import nsim.coding.boutique.dtos.BoutiqueDto;

public interface  ReportService {
    List<BoutiqueDto> getStudentsReport();
}
