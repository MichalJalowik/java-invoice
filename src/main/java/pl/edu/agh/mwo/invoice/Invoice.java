package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
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
        
//        int sum = 0;
//
//        for (Product test: products.keySet()) {
//            if(test.getName().equals(product.getName())){
//                sum ++;
//            }
//        }
//
//        if(sum == 0) {
//            products.put(product, quantity);
//
//            for (Product product1 : products.keySet() ) {
//                if(product1.getName().equals(product.getName())){
//                   // products.replace(product,products.get(product) + quantity);
//                }
//            }
//        } else if(sum > 0){
//            System.out.println(product.getName() + " xxx" + product.getPrice() + " haschcode " +product.hashCode());
//
//        }
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

//            if(product.getName().e){
//
//            }


            System.out.println(product.getName() + " " + product.getPrice() + " PLN"
                    + "     ilość: " + (products.get(product)));
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

    public boolean checkIfDoubbled(String productName) {

        for (Product checkIfDoubled : products.keySet()) {
            if (checkIfDoubled.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
