package Pricelist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PricelistTest {

    private Map<Integer, Product> products = new HashMap<>();

    @Before
    public void product(){
        products.clear();
        products.put(123, new Product("meat", 250.6));
        products.put(124, new Product("cheese",239.1));
        products.put(28, new Product("water", 9.6));
        products.put(23, new Product("chocolate", 11.8));
    }

    @Test
    public void addProduct() throws Exception {
        products.put(24,new Product("fruit", 13.6));
        assertTrue(products.containsKey(24));
    }

    @Test
   public void removeProduct() throws Exception {
        products.remove(23);
        assertFalse(products.containsKey(23));
    }

    @Test
    public void setPrice() throws Exception {
        products.remove(28);
        products.put(28, new Product("water", 11.5));
        assertTrue(products.containsKey(28));
    }

    @Test
    public void setName() throws Exception {
        products.remove(28);
        products.put(28, new Product("juice", 9.6));
        assertTrue(products.containsKey(28));
    }

    @Test
    public void purchase() throws Exception {
        List<Purchase> purchas = new ArrayList<Purchase>();
        purchas.add(new Purchase( 28, 1));
        purchas.add(new Purchase( 23, 1));
        purchas.add(new Purchase( 1, 45));

        assertEquals(21.4, new Pricelist(products).purchase(purchas),1.0e-5);
    }

}