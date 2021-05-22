package se.nackademin;

public class Coffee implements Itopping {
    String name;
    private Integer price;
    private String topping;
    private boolean decaf;
    private boolean lactose;
    private boolean sugar;

    public Coffee(String bname) {
        coffees(bname);
    }

    //separerar kaffenamnet från priset från kaffemenyn
    public void coffees(String cname) {
        String[] parts = cname.split(", ", 2);
        String part2 = parts[1];
        price = Integer.parseInt(part2);
        name = parts[0];
    }

    //ger valmöjlighet för tillbehör till kaffet
    @Override
    public void setTopping(int top) {
        switch (top) {
            case 1:
                topping = "Extra milk";
                break;
            case 2:
                topping = "Extra sugar";
                break;
            case 3:
                topping = "Extra sugar and milk";
                break;
            default:
                topping = "No topping";
        }

    }
    //låter mig hämta och använda funktionerna
    @Override
    public void setDecaf(boolean x) {
        decaf = x;

    }

    @Override
    public void setLactose(boolean y) {
        lactose = y;

    }

    @Override
    public void setSugar(boolean z) {
        sugar = z;

    }

    public String getTopping() {
        return topping;

    }

    public String getName() {
        return name;
    }

    public Boolean getDecaf() {
        return decaf;
    }

    public Boolean getLactose() {
        return lactose;
    }

    public Boolean getSugar() {
        return sugar;
    }

    public Integer getPrice() {
        return price;
    }
}