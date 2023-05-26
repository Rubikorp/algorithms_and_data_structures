import java.util.Arrays;

/**
 * Реализовать сортировку подсчетом
 * [1 2 3 3 2 3 4 2 1 1 2 3 4 4 2 3 1 4 2 3 4 2 1 2 3 4 2 1 3 4 2 1 2 3 4 4 2 3 3 2 4]
 * Подсчитываем, сколько раз встречается конкретный элемент
 * 1 -> 5 (количество единиц в массиве: число взято с потолка!)
 * 2 -> 7 (количество двоек в массиве)
 * 3 -> 3
 * 4 -> 4
 *        * Вставляем единицу 5 раз
 * Вставляем двойку 7 раз
 * Вставялем тройку 3 раза
 * Вставляем четверку 4 раза
 * */

public class seminar2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 2, 3, 4, 2, 1, 1, 2, 3, 4, 4, 2, 3, 1, 4, 2, 3, 4, 2,
         1, 2, 3, 4, 2, 1, 3, 4, 2, 1, 2, 3, 4, 4, 2, 3, 3, 2, 4};

         System.out.println(Arrays.toString(scountingSort(arr))); 
    }

    static int[] scountingSort(int[] array) {
        int min, max;
        max = min = array[0];
        for (int i = 1; i < array.length; i++) {
          if (array[i] < min) {
            min = array[i];
          }
          if (array[i] > max) {
            max = array[i];
          }
        }
        // создаем массив счетчиков
        int[] count = new int[max - min + 1];
        // считаем сколько раз встречается каждое число,
        for (int i = 0; i < array.length; i++) {
          // берем нужный счетчик и добавляем к нему +1
          count[array[i] - min]++;
        }
        int idx = 0;
        // пробегаем по всем счетчикам
        // count[i] - показывает сколько раз встречается то или иное число
        for (int i = 0; i < count.length; i++) {
          for (int j = 0; j < count[i]; j++) {
            array[idx++] = i + min;
          }
        }
        // печатает сколько раз встречается число
        for (int i = 0; i < count.length; i++) {
            int indexCount = i + 1;
            System.out.println(indexCount + " = " + count[i]);
        }
        
        return array;
      }
}

