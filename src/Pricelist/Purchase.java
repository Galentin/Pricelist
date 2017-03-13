package Pricelist;

public class Purchase {
    private final int code;
    private final int number;

    public Purchase(final int code, final int number){
        this.code = code;
        this.number = number;
    }

    public int getCode(){
        return code;
    }

    public int getNumber(){
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (code != purchase.code) return false;
        return number == purchase.number;

    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + number;
        return result;
    }
}
