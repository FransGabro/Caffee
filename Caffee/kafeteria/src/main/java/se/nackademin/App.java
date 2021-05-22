package se.nackademin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Customer showMenu = new Customer("menu");
        showMenu.readFile();    //Läser in Kaffemenyn.
        showMenu.createMenu();  //Läser in Kaffetillbehör menyn.
        List<Customer> orderlist = new ArrayList<>();
        boolean run = true;     
        //Startar programmet med en Whileloop
        try (Scanner scan = new Scanner(System.in)) {
            while (run) {
                int counter = 0;   //håller koll på beställningarna i ordern.

                System.out.println("\nWelcome to Starbucks!\n\nEnter customer name :");
                String customerN = scan.nextLine();
                Customer c = new Customer(customerN);
                showMenu.showMenu();

                //ny loop som låter dig beställa flera kaffen och tillbehör i din order.
                while(true) {

                    System.out.print("Choose something from menu or type 'done' to finish your order: ");
                    String orderC = scan.nextLine().toLowerCase();  //Ser till att svaret alltid returneras i gemener.
                    //Skriver man "done" så hoppar den ur loopen och skriverut kvitto
                    if (orderC.equals("done")) {
                        orderlist.add(c);
                        c.printOrder(orderlist);
                        break;
                    }

                    //Väljer man "11" i kaffemenyn så kommer en kaffe slumpas fram
                    else if (orderC.equals("11")) {
                        String rndmCoffee = showMenu.randomCoffee();
                        System.out.println("Would you like any complement in you coffee?");
                        showMenu.showTopings();
                        String extraC = scan.nextLine();
                        int n2 = Integer.parseInt(extraC);  //konverterar scannerns input till int
                        c.addToOrder(new Coffee(rndmCoffee));

                        c.order.get(counter).setTopping(n2); //parar ihop kaffe och tillbehör
                        //loopar igenom ordern och skriver ut beställningen + pris
                        c.order.forEach(v -> System.out.println(v.getName() + " " + v.getTopping()));
                        c.order.forEach(v -> System.out.println(v.getPrice()));
                        System.out.println(c.totPrice());
                        
                        counter++;
                    }
                    //samma som ovan men man får välja sin kaffe istället för att slumpa
                    else {
                        int n = Integer.parseInt(orderC);

                        n -= 1;
                        String selectedC = showMenu.menu.get(n);
                        System.out.println("Would you like any complement in you coffee? If not, proceed with '0'");
                        showMenu.showTopings();

                        String extraC = scan.nextLine();
                        int n2 = Integer.parseInt(extraC);
                        c.addToOrder(new Coffee(selectedC));
                        c.order.get(counter).setTopping(n2);
                        c.order.forEach(v -> System.out.println(v.getName() + " " + v.getTopping()));
                        c.order.forEach(v -> System.out.println(v.getPrice()));
                        System.out.println(c.totPrice());
                        c.finishedOrder();
                    
                        counter++;
                    }
                
                }
                //ber dig skriva "yes" för att göra klart beställningen och få ett kvitto
                System.out.println("Finnish order?");
                String exitC = scan.nextLine().toLowerCase();
                if (exitC.equals("yes")) {
                    c.receipt(orderlist);
                    c.saveReceipt();
                    c.readReceipt();
                    run = false;
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
