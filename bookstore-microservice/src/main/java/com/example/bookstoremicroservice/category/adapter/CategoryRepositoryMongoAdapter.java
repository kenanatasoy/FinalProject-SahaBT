package com.example.bookstoremicroservice.category.adapter;

import com.example.bookstoremicroservice.category.document.CategoryDocument;
import com.example.bookstoremicroservice.category.repository.CategoryDocumentMongoRepository;
import com.example.bookstoremicroservice.sale.document.SaleDocument;
import com.example.domain.category.Category;
import com.example.domain.category.CategoryId;
import com.example.repository.CategoryRepository;
import com.example.sale.domain.Sale;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryMongoAdapter implements CategoryRepository {

    private CategoryDocumentMongoRepository categoryDocumentMongoRepository;
    private ModelMapper modelMapper;

    public CategoryRepositoryMongoAdapter(CategoryDocumentMongoRepository categoryDocumentMongoRepository, ModelMapper modelMapper) {
        this.categoryDocumentMongoRepository = categoryDocumentMongoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean existCategoryByCategoryId(CategoryId categoryId) {
        return categoryDocumentMongoRepository.existsById(categoryId.getCategoryId());
    }

    @Override
    public Category saveCategory(Category category) {
        var document = modelMapper.map(category, CategoryDocument.class);
        return modelMapper.map(categoryDocumentMongoRepository.save(document), Category.class);

    }

    @Override
    public Optional<Category> findCategoryById(CategoryId categoryId) {
        return categoryDocumentMongoRepository.findById(categoryId.getCategoryId())
                .map(doc -> modelMapper.map(doc, Category.class));
    }

    @Override
    public List<Category> listCategories() {
        var categoryDocuments = categoryDocumentMongoRepository.findAll();

        return categoryDocuments.stream()
                .map((sd) -> modelMapper.map(sd,Category.class))
                .toList();
    }
}
