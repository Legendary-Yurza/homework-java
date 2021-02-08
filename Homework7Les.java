public class Cat {

    public String name;
    public int appetite;
    boolean hungrySatisfy; //3 пункт д.з.

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungrySatisfy = false; //3 пункт д.з.
    }
    public void eat (Plate p) {

        if (appetite > p.GetFood()) { //2 и 4 пункт д.з.
            System.out.println("В тарелке слишом мало корма! " + this.name + " остался голодным(((" );
            System.out.println("Сытость: " + hungrySatisfy);

        } else {

            this.hungrySatisfy = true;
            System.out.println(this.name + " поел! Сытость: " + hungrySatisfy);
            p.decreaseFood( appetite );

        }

    }

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
            }
    public void decreaseFood (int n) {
        food -= n;
    }
    public void info () {
        System.out.println("plate: " + food);
    }

    public int GetFood () {
        return food;
    }

    public void increaseFood() { // 6 пункт д.з.
        System.out.println("Добавим еду в тарелку!");
        this.food += 10;
    }
}

public class Main {

    public static void main (String [] args) {
        Cat[] catAr = new Cat[5];
        Plate plate = new Plate( 50 );

        catAr[0] = new Cat( "pushok", 10 ); // 5 пункт д.з.
        catAr[1] = new Cat( "barsik", 25 );
        catAr[2] = new Cat( "medvezhenok", 4 );
        catAr[3] = new Cat( "piskun", 5 );
        catAr[4] = new Cat( "baltazar", 15 );

        for (int i = 0; i < catAr.length; i++) {
                catAr[i].eat( plate );
                plate.info();

//      РЕАЛИЗАЦИЯ 6 ПУНКТА:
//            if (catAr[i].appetite < plate.GetFood()) {
//                catAr[i].eat(plate);
//                plate.info();
//            } else {
//                plate.increaseFood();
//                catAr[i].eat( plate );
//                plate.info();
//            }

        }




    }
}


