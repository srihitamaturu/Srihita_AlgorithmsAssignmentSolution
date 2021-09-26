package com.stockers.processing.output;

import com.stockers.domain.Stock;
import com.stockers.processing.sort.StockInfoSortProcessor;

import java.util.Scanner;

public class StockInfoOutputProcessor {
    private Stock[] stockInfo;
    private double[] sortedStockPrices;
    private int increasedStockCount = 0;
    private int decreasedStockCount = 0;

    private void getStockPrices() {
        sortedStockPrices = new double[stockInfo.length];
        for (int i = 0; i < stockInfo.length; i++) {
            sortedStockPrices[i] = stockInfo[i].getSharePrice();
        }
    }

    public StockInfoOutputProcessor(Stock[] stockInfo) {
        this.stockInfo = stockInfo;
        getStockPrices();
        StockInfoSortProcessor sortProcessor = new StockInfoSortProcessor();
        sortProcessor.sortStockPrices(sortedStockPrices);
    }

    public void processStockInfoOutput() {
        System.out.println("Welcome to Stockers Financial Services: Stock Analysis Services!");
        System.out.println("-----------------------------------------------");
        int input = -1;
        Scanner sc = new Scanner(System.in);
        while (input != 0) {
            System.out.println("Enter the operation that you want to perform" + "\n" +
                    "1. Display the companies stock prices in ascending order" + "\n" +
                    "2. Display the companies stock prices in descending order" + "\n" +
                    "3. Display the total no of companies for which stock prices rose today" + "\n" +
                    "4. Display the total no of companies for which stock prices declined today" + "\n" +
                    "5. Search a specific stock price" + "\n" +
                    "6. press 0 to exit" + "\n" +
                    "-----------------------------------------------");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Stock prices in ascending order are :");
                    System.out.println(getSortedStockPrices(false));
                    break;
                case 2:
                    System.out.println("Stock prices in descending order are :");
                    System.out.println(getSortedStockPrices(true));
                    break;
                case 3:
                    System.out.println("Total no of companies whose stock price rose today : " + getIncreasedStockCount());
                    break;
                case 4:
                    System.out.println("Total no of companies whose stock price declined today : " + getDecreasedStockCount());
                    break;
                case 5:
                    System.out.println("Enter the key value : ");
                    double key = sc.nextDouble();
                    if (searchStockKey(key)) {
                        System.out.println("Stock of value " + key + " is present");
                    } else {
                        System.out.println("Stock of value " + key + " is NOT present");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input, Please enter a value between 0 and 5");
            }
            System.out.println("-----------------------------------------------");
        }
        System.out.println("Thank you for using Stockers Financial Services!");
    }

    private String getSortedStockPrices(boolean isDescendingSort) {
        String result = "";
        if (isDescendingSort) {
            for (int i = 0; i < sortedStockPrices.length; i++) {
                result = result + " " + sortedStockPrices[i];
            }
        } else {
            for (int i = sortedStockPrices.length - 1; i >= 0; i--) {
                result = result + " " + sortedStockPrices[i];
            }
        }
        return result.trim();
    }

    private int getIncreasedStockCount() {
        if (stockInfo.length > 0 && increasedStockCount == 0 && decreasedStockCount == 0) {
            countIncreasedStocks();
        }
        return increasedStockCount;
    }

    private int getDecreasedStockCount() {
        if (stockInfo.length > 0 && increasedStockCount == 0 && decreasedStockCount == 0) {
            countIncreasedStocks();
        }
        return decreasedStockCount;
    }

    private void countIncreasedStocks() {
        increasedStockCount = 0;
        for (Stock stock : stockInfo) {
            if (stock.isStockIncreasedToday()) {
                increasedStockCount++;
            }
        }
        decreasedStockCount = stockInfo.length - increasedStockCount;
    }

    private boolean searchStockKey(double key) {
        int start = 0;
        int end = sortedStockPrices.length - 1;
        while (start <= end) {
            int mid = start
                    + (end - start) / 2;
            if (key == sortedStockPrices[mid]) {
                return true;
            } else if (key < sortedStockPrices[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
