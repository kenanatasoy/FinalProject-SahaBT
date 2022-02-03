package com.example.service.business;

import com.example.dto.response.GetCategoryResponse;
import com.example.service.CategoryService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StandartCategoryService implements CategoryService {
    @Override
    @Scheduled(cron = "")
    public GetCategoryResponse addCategory(int categoryId) {
        return null;
    }
}
