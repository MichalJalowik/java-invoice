package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }
    }

    public BigDecimal getNetTotal() {
        MathContext m = new MathContext(4);
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet.round(m);
    }

    public BigDecimal getTaxTotal() {
        MathContext m = new MathContext(4);
        return (getGrossTotal().subtract(getNetTotal()).round(m));
    }

    public BigDecimal getGrossTotal() {
        MathContext m = new MathContext(4);
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross.round(m);
    }

    public int getNumber() {
        return number;
    }

    public void getProducts() {
        for (Product product : products.keySet()) {
            System.out.println(product.getName() + " " + product.getPrice() + " PLN"
                    + "     ilość: " + (products.get(product)));
        }
    }
}
