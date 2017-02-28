package Pricelist;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PricelistTest {
    @Test
    public void addProduct() throws Exception {
        ArrayList <Product> products = new ArrayList<>();
        products.add(new Product("meat", 123, 250.6));
        products.add(new Product("cheese", 124, 239.1));
        products.add(new Product("water", 28, 9.6));
        assertEquals(true, products.add(new Product("chocolate", 23, 11.8)));
    }

    @Test
    public void removeProduct() throws Exception {
        ArrayList <Product> products = new ArrayList<>();
        products.add(new Product("meat", 123, 250.6));
        products.add(new Product("cheese", 124, 239.1));
        products.add(new Product("water", 21, 9.6));
        products.add(new Product("chocolate", 23, 11.8));
        assertEquals(true, new Pricelist(products).removeProduct(21));
        assertEquals(false, new Pricelist(products).removeProduct(17));
    }

    @Test
    public void setPrice() throws Exception {
        ArrayList <Product> products = new ArrayList<>();
        products.add(new Product("meat", 123, 250.6));
        products.add(new Product("cheese", 124, 239.1));
        products.add(new Product("water", 21, 9.6));
        products.add(new Product("chocolate", 23, 11.8));
        assertEquals(11.5 , new Pricelist(products).setPrice(21, 11.5),1.0e-5);
        assertEquals(-1.0 , new Pricelist(products).setPrice(22, 11.5),1.0e-5);


    }

    @Test
    public void setName() throws Exception {
        ArrayList <Product> products = new ArrayList<>();
        products.add(new Product("meat", 123, 250.6));
        products.add(new Product("cheese", 124, 239.1));
        products.add(new Product("water", 21, 9.6));
        products.add(new Product("chocolate", 23, 11.8));
        assertEquals("juice", new Pricelist(products).setName(21, "juice"));
        assertEquals("Impossible" , new Pricelist(products).setName(22, "candies"));
    }

    @Test
    public void purchase() throws Exception {
        ArrayList <Product> products = new ArrayList<>();
        products.add(new Product("meat", 123, 250.6));
        products.add(new Product("cheese", 124, 239.1));
        products.add(new Product("water", 28, 9.6));
        assertEquals(501.2, new Pricelist(products).purchase(123, 2),1.0e-5);
        assertEquals(-1.0, new Pricelist(products).purchase(125, 2),1.0e-5);
    }

}