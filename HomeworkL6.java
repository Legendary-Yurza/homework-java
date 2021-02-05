public class Animal {
    String name;
    Integer drun;
    Integer dswim;

    public Animal() {
    }

    public Animal(String name, Integer drun, Integer dswim) {
        this.name = name;
        this.drun = drun;
        this.dswim = dswim;
    }

}

public class Cat extends Animal {

    public static int catCount;

    public Cat(String name, Integer drun, Integer dswim) {
        this.name = name;
        this.drun = drun;
        this.dswim = dswim;

        catCount++;

    }
    int GetDrun () {
        return drun;
    }
    int GetDswim () {
        return dswim;
    }
    public void CantRun () {
        System.out.println(name + " не может пробежать больше 200 метров!");
    }
    public void catRun () {
        if (GetDrun() > 200) {
            CantRun();
        } else {
            System.out.println( name + " пробежал " + drun + " метров" );
        }
    }
    public void catSwim () {
        if (GetDswim() > 0) {
            System.out.println("Кот не умеет плавать! Помогите ему!!");
        } else if (GetDswim() == 0) {
            System.out.println("Кот коснулся воды и в панике убежал! Он не умеет плавать!!");
        } else {
            this.dswim = dswim;
        }

    }
    public void totalCats () {
        System.out.println("Всего котов прошло тест: " + catCount);
    }


}

public class Dog extends Animal {

    public static int dogCount;
    public Dog(String name, int drun, int dswim) {
        this.dswim = dswim;
        this.drun = drun;
        this.name = name;
        dogCount++;

    }
    int GetDswim () {

        return dswim;
    }
    public void CantSwim () {
        System.out.println(name + " не может проплыть больше 10 метров!");
    }
    public void CantRun () {
        System.out.println(name + " не может пробежать больше 500 метров!");
    }

    int GetDrun () {

        return drun;
    }

    public void dogSwim() {
        if (GetDswim() > 10) {
            CantSwim();
        } else {
            System.out.println(name + " проплыл " + dswim + " метров");

        }


    }

    public void dogRun() {
        if (GetDrun() > 500) {
            CantRun();
        } else {
            System.out.println(name + " пробежал " + drun + " метров");
        }

    }
    public void totalDogs () {
        System.out.println("Всего собак прошло тест: " + dogCount);
    }


}


public class Main {


    public static void main (String [ ]  args) {

        Cat cat = new Cat("Мурзик", 20, 5);
        Dog dog = new Dog ("Боб", 600, 10);
        Dog dog1 = new Dog ("Жуль-Верн", 400, 11);
        Cat cat1 = new Cat ("Пушок",201,0);
        dog.dogRun();
        dog.dogSwim();
        cat.catRun();
        cat.catSwim();

        dog1.dogRun();
        dog1.dogSwim();
        cat1.catRun();
        cat1.catSwim();


        cat.totalCats();
        dog.totalDogs();


        }



    }