package com.codewithamit.blog.services.impl;

import com.codewithamit.blog.entities.Category;
import com.codewithamit.blog.exceptions.ResourceNotFoundException;
import com.codewithamit.blog.payloads.CategoryDto;
import com.codewithamit.blog.repositories.CategoryRepository;
import com.codewithamit.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto,Category.class);
        Category addedCategory = this.categoryRepository.save(category);
        return this.modelMapper.map(addedCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category categoryPresent = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","Category Id", categoryId));
        categoryPresent.setCategoryTitle(categoryDto.getCategoryTitle());
        categoryPresent.setCategoryDescription(categoryDto.getCategoryDescription());

        Category categoryUpdated = this.categoryRepository.save(categoryPresent);

        return this.modelMapper.map(categoryUpdated,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","Category Id",categoryId));
        this.categoryRepository.delete(category);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category categoryPresent = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","Category Id",categoryId));
        return this.modelMapper.map(categoryPresent,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtosList =  categories.stream().map((category -> this.modelMapper.map(category,CategoryDto.class))).collect(Collectors.toList());
        return categoryDtosList;
    }
}
