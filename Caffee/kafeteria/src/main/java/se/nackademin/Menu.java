package se.nackademin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<String> menu = new ArrayList<>(); //kaffelista
    List<String> topingmenu = new ArrayList<>();//tillbehörlista


public void createMenu() {
    // menu.add("Americano, 30");
    // menu.add("Espresso, 30");
    // menu.add("Lungo, 37");
    // menu.add("Cortado, 40");
    // menu.add("Ristretto, 40");
    // menu.add("Caffe Latte, 40");
    // menu.add("Cappuccino, 45");
    // menu.add("Macchiato, 45");
    // menu.add("Au Lait, 45");
    // menu.add("Decaffeinato, 45");
    topingmenu.add("Milk");
    topingmenu.add("Sugar");
    topingmenu.add("Milk and Sugar");



}

public List<String> returnMenu() {
    return menu;
    
}
//visar kaffemenyn
public void showMenu() {
    int x = 1;
    for(int i = 0; i<=menu.size()-1; i++){
        System.out.println(x + ". " + menu.get(i));
        x++;
    }
    
}
//visar tillbehörsmenyn
public void showTopings() {
    int x = 1;
    for(int i = 0; i<=topingmenu.size()-1; i++){
        System.out.println(x + ". " + topingmenu.get(i));
        x++;
    }
    }
    
//läser in menyn från en fil
public void readFile()  {

    Path path = Paths.get("src/main/java/se/nackademin/Menu.csv");
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(line -> menu.add(line));
        } catch (IOException e) {
            e.printStackTrace();
        }

}
//sparar menyn till en fil
public void saveFile() throws IOException {
    Path path2 = Paths.get("src/main/java/se/nackademin/Receipt.csv");
    Files.write(path2, this.menu, StandardOpenOption.CREATE_NEW);
}

}
