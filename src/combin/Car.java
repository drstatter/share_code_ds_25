package combin;

import java.util.*;

/**
 * Car management system:
 * - Fast lookup by id: HashMap
 * - Range query by price: TreeMap (balanced BST)
 */


// Car entity
public class Car {
    public final int id;
    public int price;
    public final String type;
    public Car(int id, int price, String type) {
        this.id = id;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{id=" + id + ", price=" + price + ", type='" + type + "'}";
    }
}
