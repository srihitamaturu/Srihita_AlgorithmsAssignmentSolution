package com.stockers.processing.sort;

public class StockInfoSortProcessor {

    public void sortStockPrices(double[] stockPrices) {
        int left = 0;
        int right = stockPrices.length - 1;
        sort(stockPrices, left, right);
    }

    private void sort(double[] sharePrices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(sharePrices, left, mid);
            sort(sharePrices, mid + 1, right);
            merge(sharePrices, left, mid, right);
        }
    }

    private void merge(double[] sharePrices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];
        for (int i = 0; i < n1; i++)
            leftArray[i] = sharePrices[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = sharePrices[mid + 1 + j];
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] >= rightArray[j]) {
                sharePrices[k] = leftArray[i];
                i++;
            } else {
                sharePrices[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            sharePrices[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            sharePrices[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
