package com.example.bookstoremicroservice.config;

import com.example.application.CatalogApplication;
import com.example.application.business.events.BookEvent;
import com.example.repository.CatalogRepository;
import com.example.sale.application.SaleApplication;
import com.example.sale.application.business.StandardSaleApplication;
import com.example.sale.application.business.events.SaleEvent;
import com.example.sale.infrastructure.EventPublisher;
import com.example.sale.repository.SaleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

	@Bean
	public SaleApplication saleApp(SaleRepository saleRepository, EventPublisher<SaleEvent> eventPublisher) {
		return new StandardSaleApplication(saleRepository, eventPublisher);
	}

}
