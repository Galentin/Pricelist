package Pricelist;

import java.util.ArrayList;

public class Pricelist {

    private final ArrayList <Product> products;

    public Pricelist (ArrayList<Product> products){
        this.products = products;
    }

    public void addProduct(final Product product) {
        products.add(product);
    }

    public void removeProduct(final int codeOf){
        for (Product product : products)
            if (product.code == codeOf)
                products.remove(product);
    }

    public String setPrice (final int codeOf, final double priceNew) {
        for (Product product : products)
            if (product.code == codeOf) {
                product.price = priceNew;
                return "New price: ".concat(Double.toString(product.price));
            }
        return "Impossible";
    }

    public String setName (final int codeOf, final String nameNew){
        for (Product product : products)
            if (product.code == codeOf){
                product.name = nameNew;
                return "New name: ".concat(product.name);
            }
        return "Impossible" ;
    }

    public double purchase (final int mas[][]) {
        double sum = 0.0;
        for (Product product : products){
            for (int i = 0; i < mas.length; i ++ )
                if (mas[i][0] == product.code)
                    for (int j = 0; j < mas[i][1]; j++)
                        sum = sum + product.price;
        }
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
