import src.HashTable_BST.MyHashTable;
import src.HashTable_BST.MyTestingClass;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Создаем таблицу
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(11);
        Random rnd = new Random();

        // Добавляем 10 000 элементов
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(
                    rnd.nextInt(1000000),
                    "FirstName" + rnd.nextInt(1000),
                    "LastName" + rnd.nextInt(1000)
            );
            table.put(key, "Student" + i);
        }

        // Проверяем распределение
        table.printBucketSizes();
    }
}