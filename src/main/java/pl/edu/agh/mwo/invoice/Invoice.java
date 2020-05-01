package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.*;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {

    private Map<Product, Integer> products = new HashMap<>();
    private static int nextNumber = 0;
    private final int number = ++nextNumber;

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        products.put(product, quantity);
    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }

    public int getNumber() {
        return number;
    }

    public void getProducts() {
        for (Product product : products.keySet()) {
            System.out.println(product.getName() + " " + product.getPrice() + " PLN" + "     ilość: " + (products.get(product)));
        }
        System.out.println("");
    }

    public int getSumOfProducts(String productName) {
        int sum = 0;
        for (Product product : products.keySet()) {
            if (product.getName().equals(productName)) {
                sum = sum + products.get(product);
            }
        }
        return sum;
    }

    public boolean checkIfDoubbled(String productName){

        for (Product checkIfDoubled : products.keySet()) {
            if (checkIfDoubled.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
