package com.example.bookstoremicroservice.config;

import com.example.application.CatalogApplication;
import com.example.application.business.StandardCatalogApplication;
import com.example.application.business.events.BookEvent;
import com.example.infrastructure.CatalogEventPublisher;
import com.example.repository.CatalogRepository;
import com.example.repository.CategoryRepository;
import com.example.requisition.application.RequisitionApplication;
import com.example.requisition.application.business.StandardRequisitionApplication;
import com.example.requisition.application.business.event.StockUnderCriticalLevelEvent;
import com.example.requisition.infra.RequisitionEventPublisher;
import com.example.requisition.repository.RequisitionRepository;
import com.example.sale.application.SaleApplication;
import com.example.sale.application.business.StandardSaleApplication;
import com.example.sale.application.business.events.SaleEvent;
import com.example.sale.infrastructure.SaleEventPublisher;
import com.example.sale.repository.SaleRepository;
import com.example.stock.application.StockApplication;
import com.example.stock.application.business.StandardStockApplication;
import com.example.stock.repository.StockRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

	@Bean
	public SaleApplication saleApp(SaleRepository saleRepository, SaleEventPublisher<SaleEvent> saleEventPublisher) {
		return new StandardSaleApplication(saleRepository, saleEventPublisher);
	}
	@Bean
	public CatalogApplication catalogApp(CatalogRepository catalogRepository, CategoryRepository categoryRepository, CatalogEventPublisher<BookEvent> catalogEventPublisher){
		return new StandardCatalogApplication(catalogEventPublisher,catalogRepository,categoryRepository);
	}

	@Bean
	public StockApplication stockApp(StockRepository stockRepository){
		return new StandardStockApplication(stockRepository);
	}

	@Bean
	public RequisitionApplication requisitionApp(RequisitionRepository requisitionRepository,
												 SaleApplication saleService,
												 StockApplication stockApplication,
							RequisitionEventPublisher<StockUnderCriticalLevelEvent> requisitionEventPublisher){
		return new StandardRequisitionApplication(requisitionRepository,
													saleService, stockApplication,
				 									requisitionEventPublisher);
	}


}
