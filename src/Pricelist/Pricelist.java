package Pricelist;

import java.util.ArrayList;

public class Pricelist {

    private ArrayList <Product> products;

    public Pricelist (ArrayList<Product> products){
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(int codeOf){
        for (Product product : products)
            if (product.code == codeOf) {
                products.remove(product);
                return true;
            }
        return false;
    }

    public double setPrice (int codeOf, double priceNew) {
        for (Product product : products)
            if (product.code == codeOf) {
                product.price = priceNew;
                return product.price;
            }
        return -1;
    }

    public String setName (int codeOf, String nameNew){
        for (Product product : products)
            if (product.code == codeOf){
                product.name = nameNew;
                return product.name;
            }
        return "Impossible" ;
    }

    public double purchase (int codeOf, int number) {
        double sum = 0.0;
        for (Product product : products) {
            if (product.code == codeOf) {
                for (int i = 0; i < number; i ++)
                    sum = sum + product.price;
            }
        }
        if (sum != 0) return sum;
        else return -1;
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
