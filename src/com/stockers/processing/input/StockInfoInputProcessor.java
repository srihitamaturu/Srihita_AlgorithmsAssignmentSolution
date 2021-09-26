package com.stockers.processing.input;

import com.stockers.domain.Stock;

import java.util.Scanner;

public class StockInfoInputProcessor {
    public Stock[] processShareInfoInput() {
        System.out.println("Welcome to Stockers Financial Services: Stock Information Input Processing!");
        System.out.println("-----------------------------------------------");
        System.out.println("Enter the number of companies: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        Stock[] stocksInfo = new Stock[input];
        for (int i = 0; i < input; i++) {
            System.out.println("Enter current stock price of the company " + (i + 1));
            double sharePrice = sc.nextDouble();
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            boolean isStockIncreased = sc.nextBoolean();
            Stock stock = new Stock(sharePrice, isStockIncreased);
            stocksInfo[i] = stock;
        }
        System.out.println("Thank you for providing input for Stockers Financial Services!");
        System.out.println("-----------------------------------------------");
        return stocksInfo;
    }
}

