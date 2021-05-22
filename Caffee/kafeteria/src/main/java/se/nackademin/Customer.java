package se.nackademin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class Customer extends Menu {
    Random rndm = new Random();
    List<Coffee> order = new ArrayList<>(); //lista för beställning
    List<String> receipt = new ArrayList<>(); //lista för kvitto
    List<String> readReceipt = new ArrayList<>(); //lista för sumering i terminalen
    int total = 0;  //räknar totalsumman av ordern
    String orderstatus = "";
    private String name; //varje beställnig ska ha namn
    
    public Customer(String nameOrder) {
        name = nameOrder;
    }

    //slumpar kaffe i listan
    public String randomCoffee() {
        int randInt = rndm.nextInt(9);
        return menu.get(randInt);

    }

    public void addToOrder(Coffee name) {
        order.add(name);

    }


    public void finishedOrder() {
        orderstatus = "Order Served";
        Map<String, Long> counterMap = order.stream()
                .collect(Collectors.groupingBy(e -> e.toString(), Collectors.counting()));
        System.out.println(counterMap.entrySet());
    }
    //varje order ska ha ett namn
    public String orderID() {
        return name;
    }

    //loopar på namnen i beställningarn
    public void printOrder(List<Customer> orderlist) {
        for (int i = 0; i <= orderlist.size() - 1; i++) {

            System.out.println(orderlist.get(i).orderID() + " Order summary:");
            //loopar på beställningarna i namnet(ordern)
            for (int x = 0; x <= orderlist.get(i).order.size() - 1; x++) {
                System.out.println(orderlist.get(i).order.get(x).getName() + " "
                        + orderlist.get(i).order.get(x).getTopping() + " " + orderlist.get(i).order.get(x).getPrice());

            }
            System.out.println("\n" + "Order state: " + orderlist.get(i).orderstatus + "\n");
            System.out.println("Total: " + orderlist.get(i).totPrice() + "\n");
        }
    }
        //summerar pris
    public Integer totPrice() {
        int total = 0;
        for (int i = 0; i <= order.size() - 1; i++) {
            total += order.get(i).getPrice();
        }

        return total;
    }

    //samma som "printorder" men skriver ut ett kvitto
    public void receipt(List<Customer> orderlist) {
        for (int i = 0; i <= orderlist.size() - 1; i++) {

            receipt.add(orderlist.get(i).orderID() + "´s Order:");
            for (int x = 0; x <= orderlist.get(i).order.size() - 1; x++) {
                receipt.add(orderlist.get(i).order.get(x).getName() + " " + orderlist.get(i).order.get(x).getTopping()
                        + " " + orderlist.get(i).order.get(x).getPrice());

            }
            receipt.add("Total Price: " + orderlist.get(i).totPrice() + "\n");
        }
    }

    //sparar kvitto till en fil
    public void saveReceipt() throws IOException {
        Path path2 = Paths.get("src/main/java/se/nackademin/Receipt.csv");
        Files.write(path2, receipt, StandardOpenOption.CREATE_NEW);
    }
    //laddar upp kvitto från en fil
    public void readReceipt() {
        Path path = Paths.get("src/main/java/se/nackademin/Receipt.csv");
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(line -> readReceipt.add(line));
            System.out.println(readReceipt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStatus(String status) {
        orderstatus = status;
    }
}