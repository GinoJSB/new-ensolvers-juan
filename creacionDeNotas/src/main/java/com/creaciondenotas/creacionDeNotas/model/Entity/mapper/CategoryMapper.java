package com.creaciondenotas.creacionDeNotas.model.Entity.mapper;

import com.creaciondenotas.creacionDeNotas.model.DTO.CategoryResponseDTO;
import com.creaciondenotas.creacionDeNotas.model.Entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDTO categoryToCategoryResponseDTO(Category category);
    List<CategoryResponseDTO> categoryListToCategoryResponseDTOList(List<Category> categories);
}
