import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /* Создание массива случайных чисел*/
        List<Integer> randArrayInt = new ArrayList<>();
        Random rand = new Random();
        for (int i=0; i<10; i++){
            int temp = rand.nextInt(10);
            randArrayInt.add(temp);
        }
        System.out.println("Массив случайных чисел: " + randArrayInt);

        /* Создание массива для добавления объектов класса MyThread */
        List<MyThread> arrayMyThread = new ArrayList<>();

        /* Инстанцирование объектов класса MyThread со значениями из массива случайных чисел */
        for (int i = 0; i<randArrayInt.size(); i++){
            arrayMyThread.add(new MyThread(randArrayInt.get(i)));
        }

        /* Создание массива для добавления объектов класса Thread */
        List<Thread> arrayThread = new ArrayList<>();
        for (int i = 0; i<randArrayInt.size(); i++){
            arrayThread.add(new Thread(arrayMyThread.get(i)));
        }

        /* Запуск потоков на исполнение */
        for (int i = 0; i<randArrayInt.size(); i++){
            arrayThread.get(i).start();
        }

        /* Завершение потоков исполнения */
        for (int i = 0; i<randArrayInt.size(); i++){
            try {
                arrayThread.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /* Создание массива для хранения объектов типа BigInteger и записи вычисленных факториалов */
        List<BigInteger> randArrayBigInt = new ArrayList<>();

        /* Добавление вычисленных факториалов в массив */
        for (int i = 0; i<randArrayInt.size(); i++){
            randArrayBigInt.add(BigInteger.valueOf(arrayMyThread.get(i).getIterable()));
        }

        /* Выведение результатов вычисления факториалов */
        System.out.println("Вычисленные факториалы: ");
        for (int i = 0; i<randArrayInt.size(); i++){
            System.out.print(randArrayBigInt.get(i)+ ", ");
        }
    }
}
