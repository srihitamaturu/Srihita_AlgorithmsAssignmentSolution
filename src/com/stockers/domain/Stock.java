package com.stockers.domain;

public class Stock {
    double sharePrice;
    boolean isStockIncreasedToday;

    public Stock(double sharePrice, boolean isStockIncreasedToday) {
        this.sharePrice = sharePrice;
        this.isStockIncreasedToday = isStockIncreasedToday;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }

    public boolean isStockIncreasedToday() {
        return isStockIncreasedToday;
    }

    public void setStockIncreasedToday(boolean stockIncreasedToday) {
        isStockIncreasedToday = stockIncreasedToday;
    }
}
