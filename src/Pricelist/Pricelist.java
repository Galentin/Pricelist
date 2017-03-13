package Pricelist;

import java.util.List;
import java.util.Map;

public class Pricelist {

    private final Map<Integer,Product> products;

    public Pricelist (final Map<Integer,Product> products){
        this.products = products;
    }

    public void addProduct(final int code, final Product product) {
        products.put(code, product);
    }

    public void removeProduct(final int code){
        products.remove(code);
    }

   public void setPrice (final int code, final double priceNew) {
       Product product = products.get(code);
       products.remove(code);
       products.put(code, new Product(product.getName(), priceNew));
    }

    public void setName (final int code, final String nameNew){
        Product product = products.get(code);
        products.remove(code);
        products.put(code, new Product(nameNew, product.getPrice()));
    }

    public double purchase (final List<Purchase> purchas) {
        double sum = 0.0;
            for (Purchase purchase: purchas)
                if (products.containsKey(purchase.getCode()))
                    sum = sum + products.get(purchase.getCode()).getPrice() * purchase.getNumber();
        return sum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pricelist pricelist = (Pricelist) o;

        return products != null ? products.equals(pricelist.products) : pricelist.products == null;

    }

    @Override
    public int hashCode() {
        return products != null ? products.hashCode() : 0;
    }

}
