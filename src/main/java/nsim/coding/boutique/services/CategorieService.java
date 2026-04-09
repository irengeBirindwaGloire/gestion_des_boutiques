package nsim.coding.boutique.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import nsim.coding.boutique.dtos.CategorieDto;

@Service
public interface CategorieService {

    public CategorieDto createCategorie(CategorieDto categorieDto);

    public CategorieDto getCategorieById(Long id);

    public CategorieDto updateCategorie(Long id, CategorieDto categorieDto);

    public void deleteCategorie(Long id);

    public Page<CategorieDto> getAllCategories(int page, int size);
}