//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
//        3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
//

public class MyArraySizeException extends Exception {


}


public class MyArrayDataException extends Exception{
    public int i;
    public int j;

    MyArrayDataException(int i, int j ) {
        this.i = i;
        this.j = j;
    }
}


public class Main {

    public static void main(String[] args) {

        String[][] arrow = new String[][]{{"1", "2", "3", "4","5"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try {
            try {
                int result = method( arrow );
                System.out.println( result );
            } catch (MyArraySizeException e) {
                System.out.println( "размер массива превышен" );
            }
        } catch (MyArrayDataException e) {
            System.out.println( "неправильное щзначение массива" );
        }
    }



    public static int method (String[][] arrow) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arrow.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arrow.length; i++) {
            if (arrow[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arrow[i].length; j++) {
                try {
                    count = count + Integer.parseInt( arrow[i][j] );
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }

            }

        }
        return count;
    }
}
