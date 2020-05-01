package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.OtherProduct;
import pl.edu.agh.mwo.invoice.product.Product;

public class Main {
    public static void main(String[] args) {
        Invoice oneInv = new Invoice();
        Invoice secondInv = new Invoice();
        oneInv.addProduct(new OtherProduct("piwo", new BigDecimal("3.10")), 4);
        oneInv.addProduct(new OtherProduct("wodeczka", new BigDecimal("30.20")), 1);
        secondInv.addProduct(new OtherProduct("ciasteczka", new BigDecimal("5.30")), 3);
        secondInv.addProduct(new OtherProduct("ciasteczka", new BigDecimal("5.40")), 3);
        secondInv.addProduct(new OtherProduct("pireniczkek", new BigDecimal("8.90")), 1);
        secondInv.addProduct(new OtherProduct("ciasteczka", new BigDecimal("5.50")), 3);
        printInv(oneInv);
        printInv(secondInv);
    }

    public static void printInv(Invoice invoice) {
        System.out.println("<<<< Invoice nr. " + invoice.getNumber() + ">>>>");
        System.out.println("     contents: ");
        invoice.getProducts();
    }
}
