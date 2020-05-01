package pl.edu.agh.mwo.invoice;

import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.OtherProduct;
import pl.edu.agh.mwo.invoice.product.Product;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args){

        Invoice oneInv = new Invoice();
        Invoice secondInv = new Invoice();
        Product oneProd = new OtherProduct("piwo", new BigDecimal("3.0"));
        Product secondProd = new OtherProduct("wodeczka", new BigDecimal("30.0"));

        oneInv.addProduct(oneProd,4);
        oneInv.addProduct(secondProd);

        secondInv.addProduct(new OtherProduct("ciasteczka", new BigDecimal("5.00")),2);
        secondInv.addProduct(new OtherProduct("pireniczkek", new BigDecimal("8.00")),1);


        printInv(oneInv);
        printInv(secondInv);

    }


    public static void printInv(Invoice invoice){

        System.out.println("<<<< Invoice nr. " + invoice.getNumber()+ ">>>>");
        System.out.println("     contents: ");
        invoice.getProducts();

    }

}
