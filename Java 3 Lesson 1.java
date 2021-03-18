public class Apple extends Fruit {

    Apple() {
        super(1.0f);
    }

    @Override
    public String toString(){
        return "яблоки";
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Box<T extends Fruit> {
    public List<T> getList() {
        return list;
    }

    private List<T> list;

    public Box(T... obj) {
        list = Arrays.asList(obj);
    }

    public Box() {
        list = new ArrayList<T>();
    }

    void add(T obj) {
        list.add(obj);
    }

    void moveAt(Box<T> box) {
//        for (T obj : list) {
//            box.add(obj);
//        }
        box.getList().addAll(list);
        list.clear();
    }

    void info() {
        if (list.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {
            System.out.println("В коробке находятся " + list.get(0).toString() + " в количестве: " + list.size());
        }
    }

    float getWeight() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.size() * list.get(0).getWeight();
        }
    }

    boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }


}


abstract class Fruit {
    private float weight;

    Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}

public class Orange extends Fruit {

    Orange() {
        super(1.5f);
    }

    @Override
    public String toString(){
        return "апельсины";
    }

}




import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        //1 ex
//        String[] arr = {"asd", "ds", "ret", "123"};
//
//        System.out.println("Task 1\n" + Arrays.toString(arr));
//        swapElements(arr, 2, 3);
//        System.out.println(Arrays.toString(arr));


//        //2 ex
//        List<String> list = convertToList(arr);
//        System.out.println("Task 2\n" + list.getClass() + " : " + list);


        //3 ex
        System.out.println("Task 3");
        Orange orange = new Orange();
        Apple apple = new Apple();
        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();
        Box<Apple> appleBox = new Box();
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());

        for (int i = 0; i < 4; i++) {
            orangeBox2.add(new Orange());
        }
        for (int i = 0; i < 6; i++) {
            appleBox.add(new Apple());
        }


        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();

        Float orange1Weigth = orangeBox1.getWeight();
        Float orange2Weigth = orangeBox2.getWeight();
        Float appleWeigth = appleBox.getWeight();
        System.out.println("Вес коробки 1 с апельсинами: " + orange1Weigth);
        System.out.println("Вес коробки 2 с апельсинами: " + orange2Weigth);
        System.out.println("Вес коробки с яблоками: " + appleWeigth);

        System.out.println("Сравнить вес orangeBox1 и appleBox: " + orangeBox1.compare(appleBox));
        System.out.println("Сравнить вес orangeBox2 и appleBox: " + orangeBox2.compare(appleBox));

        orangeBox1.moveAt(orangeBox2);
//            orangeBox1.moveAt(appleBox);   Error

        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();
    }

    private static <T> void swapElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static <E> List<E> convertToList(E[] array) {
        return Arrays.asList(array);
    }
}





