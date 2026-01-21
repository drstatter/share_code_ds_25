package combin;

import java.util.*;

public class CarStore {

    // 1) Fast search by id
    private final HashMap<Integer, Car> byId = new HashMap<>();

    // 2) Range queries by price
   // price -> set of ids with that price (handles multiple cars same price)
    private final TreeMap<Integer, HashSet<Integer>> idsByPrice = new TreeMap<>();

    /**
     * Insert(id, price, type) - add new car. No duplicate ids.
     * Complexity: O(log n)
     */
    public void insert(int id, int price, String type) {
        if (byId.containsKey(id)) {
            throw new IllegalArgumentException("Car with id " + id + " already exists");
        }

        Car car = new Car(id, price, type);
        byId.put(id, car);

        idsByPrice.computeIfAbsent(price, p -> new HashSet<>()).add(id);
    }

    /**
     * Find(id) - fast as possible.
     * Complexity: average O(1)
     */
    public Car find(int id) {
        return byId.get(id);
    }

    /**
     * Delete(id) - remove car by id.
     * Complexity: O(log n)
     */
    public boolean delete(int id) {
        Car car = byId.remove(id);
        if (car == null) return false;

        HashSet<Integer> set = idsByPrice.get(car.price);
        if (set != null) {
            set.remove(id);
            if (set.isEmpty()) {
                idsByPrice.remove(car.price);
            }
        }
        return true;
    }

    /**
     * Find_in_range(minPrice, maxPrice) - return all cars with price in [minPrice, maxPrice].
     * Complexity: O(log n + k) where k = number of cars returned
     */
    public List<Car> findInRange(int minPrice, int maxPrice) {
        List<Car> result = new ArrayList<>();
        if (minPrice > maxPrice) return result;

        NavigableMap<Integer, HashSet<Integer>> sub = idsByPrice.subMap(minPrice, true, maxPrice, true);

        for (Map.Entry<Integer, HashSet<Integer>> e : sub.entrySet()) {
            for (int id : e.getValue()) {
                Car car = byId.get(id);
                if (car != null) result.add(car);
            }
        }
        return result;
    }

    // Demo / quick test
    public static void main(String[] args) {
        CarStore store = new CarStore();

        store.insert(1, 120000, "SUV");
        store.insert(2, 150000, "Sedan");
        store.insert(3, 150000, "Hatchback");
        store.insert(4, 220000, "Electric");

        System.out.println("Find(2): " + store.find(2));

        System.out.println("Range [130000, 200000]:");
        for (Car car : store.findInRange(130000, 200000)) {
            System.out.println("  " + car);
        }

        System.out.println("Delete(3): " + store.delete(3));
        System.out.println("Range [130000, 200000] after delete:");
        for (Car c : store.findInRange(130000, 200000)) {
            System.out.println("  " + c);
        }
    }
}


