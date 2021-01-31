public class Worker {
    private String name;
    private String post;
    private String email;
    private String tel;
    private int salary;
    private int age;

    Worker(String name, String post, String email, String tel, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;

        if (age >= 18) {
            this.age = age;
        } else {
            System.out.println( "работник несовершеннолетний!" );
        }
    }

    int GetAge () {
        return age;
    }
    int GetSalary () {
        return salary;
    }

    void Show() {
        System.out.println("Имя работяги: " + name);
        System.out.println("Должность работяги: " + post);
        System.out.println("Почта работяги: " + email);
        System.out.println("Телефон работяги: " + tel);
        System.out.println("Зарплата работяги: " + salary);
        System.out.println("Возраст работяги: " + age);
    }
}



public class Main {

    public static void main(String[] args) {

        Worker[] workAr = new Worker[6];
        workAr[0] = new Worker( "Чеплаков Глеб", "Разведчик", "corpsefly@mail.ru", "89124509829", 30000, 22 );
        workAr[1] = new Worker( "Андрей Муравьёв", "Адванс", "muravand@mail.ru", "89058556721", 5000, 22 );
        workAr[2] = new Worker( "Даниил Белокобыльский", "Адванс-монтажер", "98oruvep@gmail.com", "89128509518", 25000, 21 );
        workAr[3] = new Worker( "Рустам Нуриев", "Пилот Ah-13h", "rustamnur@mail.ru", "89127555654", 60000, 26 );
        workAr[4] = new Worker( "Lukas Miernik", "Администратор-скриптер", "lukasmier2002@gmail.com", "+48 2343 655", 28000, 18 );
        workAr[5] = new Worker( "Dominique Tesch", "Terminator", "schnippka@gmail.com", "+49 5488 228", 100000, 41 );

        for (Worker foo : workAr) {
            if (foo.GetAge() > 40) {
                foo.Show();
            };
            if (foo.GetSalary() > 50000) {
                foo.Show();
            }


        }
    }
}
