package Pricelist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PricelistTest {

    private ArrayList <Product> products = new ArrayList<>();

    @Before
    public void product(){
        products.add(new Product("meat", 123, 250.6));
        products.add(new Product("cheese", 124, 239.1));
        products.add(new Product("water", 28, 9.6));
        products.add(new Product("chocolate", 23, 11.8));
    }

    @Test
    public void addProduct() throws Exception {
        products.add(new Product("fruit", 24, 13.6));
        assertTrue(products.contains(new Product("fruit", 24, 13.6)));
    }

    @Test
    public void removeProduct() throws Exception {
        products.remove(new Product("chocolate", 23, 11.8));
        assertFalse(products.contains(new Product("chocolate", 23, 11.8)));
    }

    @Test
    public void setPrice() throws Exception {
        assertEquals("New price: 11.5", new Pricelist(products).setPrice(28, 11.5));
        assertEquals("Impossible" , new Pricelist(products).setPrice(22, 11.5));
    }

    @Test
    public void setName() throws Exception {
        assertEquals("New name: juice", new Pricelist(products).setName(28, "juice"));
        assertEquals("Impossible" , new Pricelist(products).setName(22, "candies"));
    }

    @Test
    public void purchase() throws Exception {
        int[][] mas = { {123, 2},
                        {121, 3},
                        {28, 4} };
        assertEquals(539.6, new Pricelist(products).purchase(mas),1.0e-5);
    }

}