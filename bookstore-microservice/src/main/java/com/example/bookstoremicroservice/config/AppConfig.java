package com.example.bookstoremicroservice.config;

import com.example.sale.application.SaleApplication;
import com.example.sale.application.business.StandardSaleApplication;
import com.example.sale.infrastructure.EventPublisher;
import com.example.sale.repository.SaleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

	@Bean
	public SaleApplication hrApp(SaleRepository saleRepository,
								 EventPublisher eventPublisher) {
		return new StandardSaleApplication(saleRepository, eventPublisher);
	}
}
