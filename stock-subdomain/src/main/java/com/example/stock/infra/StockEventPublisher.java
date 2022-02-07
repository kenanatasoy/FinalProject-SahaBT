package com.example.stock.infra;

import com.example.stock.application.business.event.StockEvent;

public interface StockEventPublisher {
	void publishEvent(StockEvent event);
}
