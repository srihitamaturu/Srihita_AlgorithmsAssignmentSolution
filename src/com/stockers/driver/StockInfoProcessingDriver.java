package com.stockers.driver;

import com.stockers.domain.Stock;
import com.stockers.processing.input.StockInfoInputProcessor;
import com.stockers.processing.output.StockInfoOutputProcessor;

public class StockInfoProcessingDriver {
    public static void main(String[] args) {
        Stock[] stocksInfo;
        StockInfoInputProcessor stockInfoInputProcessor = new StockInfoInputProcessor();
        stocksInfo = stockInfoInputProcessor.processShareInfoInput();
        StockInfoOutputProcessor stockInfoOutputProcessor = new StockInfoOutputProcessor(stocksInfo);
        stockInfoOutputProcessor.processStockInfoOutput();
    }
}
