package nsim.coding.boutique.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import nsim.coding.boutique.dtos.CategorieDto;
import nsim.coding.boutique.exceptions.EntityNotFoundException;
import nsim.coding.boutique.exceptions.InvalidEntityException;
import nsim.coding.boutique.repository.CategorieRepository;
import nsim.coding.boutique.services.CategorieService;

@Service
public class CategorieServiceImp implements CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImp(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public CategorieDto createCategorie(CategorieDto categorieDto) {
        if (categorieDto == null) {
            throw new InvalidEntityException("L'invalid, la catégorie ne dpoit pas être nulle");
        }
        return CategorieDto.fromEntity(
                categorieRepository.save(
                        CategorieDto.toEntity(categorieDto))
        );
    }

    @Override
    public void deleteCategorie(Long id) {
        if (id == null) {
            throw new InvalidEntityException("L'invalid, l'ID ne dpoit pas être nulle");
        }
        categorieRepository.deleteById(id);
    }

    @Override
    public Page<CategorieDto> getAllCategories(int page, int size) {

        return categorieRepository.findAll(PageRequest.of(page, size))
                .map(CategorieDto::fromEntity);
    }

    @Override
    public CategorieDto getCategorieById(Long id) {

        if (id == null) {
            throw new InvalidEntityException("L'invalid, l'ID ne dpoit pas être nulle");
        }

        return categorieRepository.findById(id).map(CategorieDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune catégorie correspondant avec l'ID: " + id));
    }

    @Override
    public CategorieDto updateCategorie(Long id, CategorieDto categorieDto) {
        if (id == null) {
            throw new InvalidEntityException("L'invalid, l'ID ne dpoit pas être nulle");
        }

        if (categorieDto == null) {
            throw new InvalidEntityException("L'invalid, la catégorie ne dpoit pas être nulle");
        }

        return CategorieDto.fromEntity(categorieRepository.save(
                CategorieDto.toEntity(categorieDto)
        ));
    }

}
