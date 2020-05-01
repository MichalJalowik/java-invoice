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

        oneInv.addProduct(oneProd);
        oneInv.addProduct(secondProd);

        printInv(oneInv);
        printInv(secondInv);

    }


    public static void printInv(Invoice invoice){

        System.out.println(invoice.getNumber());

    }

}
