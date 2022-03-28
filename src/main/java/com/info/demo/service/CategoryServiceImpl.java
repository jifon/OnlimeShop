package com.info.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.demo.dao.CategoryRepository;
import com.info.demo.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public List<Category> listCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public void deleteCategory(long categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Optional<Category> getCategory(long categoryId) {
		return categoryRepository.findById(categoryId);
	}

}
