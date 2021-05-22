package se.nackademin;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hamcrest.collection.IsIterableContainingInOrder;
public class MenuTest {
    Menu menu = new Menu();

    @Test
    public void testMenuList()  {
        menu.readFile();
        assertEquals(menu.menu.get(0), "Americano, 30");
        assertNotEquals(menu.menu.get(0), "Espresso, 30");
        
    }

    // @Test
    // public void exceptionTest() {
    //     menu.readFile();
    //     try {
    //         assertEquals(menu.menu.get(15), "Oboy");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }


    @Test
    public void testToppingList() {
        menu.createMenu();
        assertEquals(menu.topingmenu.get(0), "Milk");
    }

    @Test
    public void testReturnMenu() {
        List<String> ArrayList = new ArrayList<>();
        assertEquals(menu.returnMenu(), ArrayList);
    }

    @Test
    public void testIterableList() {
        menu.createMenu();
        assertThat(menu.topingmenu, IsIterableContainingInOrder.<String>contains("Milk", "Sugar", "Milk and Sugar"));
    }
}
