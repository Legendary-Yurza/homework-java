//Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
//Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
//* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

public interface Member {

    String getName();

    Integer getDrun();

    Integer getDjump();

    Boolean getWin();

    void setWin(Boolean win);

    String run();

    String jump();
}

public interface Task {
    void check(Member member);
}

public class Human implements Member {

    String name;
    Integer drun;
    Integer djump;
    Boolean win = true;

    public Human(String name, Integer drun, Integer djump) {
        this.name = name;
        this.drun = drun;
        this.djump = djump;
    }

    public String getName() {
        return name;
    }

    public Integer getDrun() {
        return drun;
    }

    public Integer getDjump() {
        return djump;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public String run() {
        return "Human named " + name + " run over " + drun + " kilometers";
    }

    public String jump() {
        return  "Human named " + name + " jumped over " + djump + " meters";
    }
}


public class Cat implements Member {

    String name;
    Integer drun;
    Integer djump;
    Boolean win = true;

    public Cat(String name, Integer drun, Integer djump) {
        this.name = name;
        this.drun = drun;
        this.djump = djump;
    }



    public String getName() {
        return name;
    }

    public Integer getDrun() {
        return drun;
    }

    public Integer getDjump() {
        return djump;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public String run() {
        return "Cat named " + name + " run over " + drun + " kilometers";
    }

    public String jump() {
        return  "Cat named " + name + " jumped over " + djump + " meters";
    }


}


public class Robot implements Member{

    String name;
    Integer drun;
    Integer djump;
    Boolean win = true;

    public Robot(String name, Integer drun, Integer djump) {
        this.name = name;
        this.drun = drun;
        this.djump = djump;
    }

    public String getName() {
        return name;
    }

    public Integer getDrun() {
        return drun;
    }

    public Integer getDjump() {
        return djump;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public String run() {
        return "Robot named " + name + " run over " + drun + " kilometers";
    }

    public String jump() {
        return  "Robot named " + name + " jumped over " + djump + " meters";
    }
}

public class Runway implements Task {

    Integer distance;

    public Runway(Integer distance) {
        this.distance = distance;
    }

    public void check(Member member) {
        member.run();
        member.setWin( member.getDrun() >= distance );
        if (member.getWin()) {
            System.out.println( "Member named " + member.getName() + " ran over " + distance + "km" );
        } else {
            System.out.println( "Member named " + member.getName() + " failed the runway task" );
        }
    }
}


public class Wall implements Task {
    Integer height;

    public Wall(Integer height) {
        this.height = height;
    }

    public void check(Member member) {
        member.jump();
        member.setWin( member.getDjump() >= height );
        if (member.getWin()) {
            System.out.println("Member named " + member.getName() + " jumped over" + member.getDjump() + " m");
        } else {
            System.out.println("Member named " + member.getName() + " jumped over" + " failed the Wall task");
        }
    }
}


public class Main {


    public static void main(String[] args) {
        Member humanDan = new Human( "Yurza", 15, 5 );
        Member humanCmet = new Human( "CMETAHKA", 20, 3 );

        Member catFrik = new Cat( "Frik", 10, 3 );
        Member catBarki = new Cat( "Barki", 5, 10 );

        Member robotLuka = new Robot( "Luka", 30, 15 );
        Member robotCats = new Robot( "Cats", 0, 0 );

        Member[] membersArr = {humanDan, humanCmet, catFrik, catBarki, robotLuka, robotCats};

        Task walleasy = new Wall( 5 );
        Task wallhard = new Wall( 10 );

        Task runwayeasy = new Runway( 10 );
        Task runwayhard = new Runway( 20 );

        Task[] tasksArr = {walleasy, wallhard, runwayeasy, runwayhard};

        for (int i = 0; i < tasksArr.length; i++) {
            for (Member member : membersArr) {
                if (member.getWin()) {
                    tasksArr[i].check( member );
                }
            }
        }
    }
}

//RESULT:
//        Member named Yurza jumped over5 m
//        Member named CMETAHKA jumped over failed the Wall task
//        Member named Frik jumped over failed the Wall task
//        Member named Barki jumped over10 m
//        Member named Luka jumped over15 m
//        Member named Cats jumped over failed the Wall task
//        Member named Yurza jumped over failed the Wall task
//        Member named Barki jumped over10 m
//        Member named Luka jumped over15 m
//        Member named Barki failed the runway task
//        Member named Luka ran over 10km
//        Member named Luka ran over 20km
//
//        Process finished with exit code 0




