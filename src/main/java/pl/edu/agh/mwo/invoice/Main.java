package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import pl.edu.agh.mwo.invoice.product.BottleOfWineProduct;
import pl.edu.agh.mwo.invoice.product.FuelCanisterProduct;
import pl.edu.agh.mwo.invoice.product.OtherProduct;

public class Main {
    public static void main(String[] args) {
        Invoice oneInv = new Invoice();
        Invoice secondInv = new Invoice();
        Invoice thirdInv = new Invoice();
        
        oneInv.addProduct(new OtherProduct("piwo", new BigDecimal("3.10")), 1);
        oneInv.addProduct(new OtherProduct("wodeczka", new BigDecimal("30.20")), 1);
        secondInv.addProduct(new OtherProduct("ciasteczka", new BigDecimal("5.30")), 1);
        secondInv.addProduct(new OtherProduct("ciasteczka", new BigDecimal("5.30")), 1);
        secondInv.addProduct(new OtherProduct("pireniczkek", new BigDecimal("8.90")), 1);
        secondInv.addProduct(new OtherProduct("ciasteczka", new BigDecimal("5.30")), 1);
        thirdInv.addProduct(new BottleOfWineProduct("michell", new BigDecimal("6.00")), 1);
        thirdInv.addProduct(new FuelCanisterProduct("disel", new BigDecimal("4.00")), 1);
        printInv(oneInv);
        printInv(secondInv);
        printInv(thirdInv);
    }

    public static void printInv(Invoice invoice) {
        System.out.println("**************************************************************"
                + "*********");
        System.out.println("<<<< Invoice nr. " + invoice.getNumber() + ">>>>");
        System.out.println("- Contents: ");
        invoice.getProducts();
        System.out.println("- Invoice summary: ");
        System.out.println("Gross total = " + invoice.getGrossTotal() + "PLN. Net total = "
                + invoice.getNetTotal() + "PLN. Tax total = " + invoice.getTaxTotal() + "PLN.");
        System.out.println("************************************************************"
                + "***********");
        System.out.println("");
    }
}
