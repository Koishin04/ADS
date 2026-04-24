import src.HashTable_BST.BST;
import src.HashTable_BST.MyHashTable;
import src.HashTable_BST.MyTestingClass;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(11);
        Random rnd = new Random();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(
                    rnd.nextInt(1000000),
                    "FirstName" + rnd.nextInt(1000),
                    "LastName" + rnd.nextInt(1000)
            );
            table.put(key, "Student" + i);
        }

        table.printBucketSizes();




        BST<Integer, String> tree = new BST<>();
        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(8, "Eight");
        tree.put(1, "One");
        tree.put(4, "Four");

        System.out.println("Tree size: " + tree.size());
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}