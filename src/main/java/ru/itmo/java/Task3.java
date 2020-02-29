package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null) {
            return new int[0];
        }
        if (inputArray.length == 0) {
            return inputArray;
        }
        int next = inputArray[0];
        int tmp;
        for (int i = 0; i < inputArray.length; i++) {
            if (i == inputArray.length - 1) {
                inputArray[0] = next;
            } else {
                tmp = next;
                next = inputArray[i + 1];
                inputArray[i + 1] = tmp;
            }
        }
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }
        int max = -1;
        int index1 = 0, index2 = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max) {
                index1 = i;
                max = inputArray[i];
            }
        }
        max = -1;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max && i != index1) {
                index2 = i;
                max = inputArray[i];
            }
        }
        return inputArray[index1] * inputArray[index2];
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        char[] array = input.toCharArray();
        int k = 0;
        for (int i = 0; i < input.length(); i++) {
            if (array[i] == 'a' || array[i] == 'b' || array[i] == 'B' || array[i] == 'A') {
                k++;
            }
        }
        return k * 100 / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        char[] array = input.toCharArray();
        for (int i = 0; i < input.length() / 2; i++) {
            if (array[i] != array[input.length() - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null) {
            return "";
        }
        char[] array = input.toCharArray();
        String result = "";
        char let;
        int i = 0, count;
        while (i < input.length()) {
            let = array[i];
            result += let;
            count = 1;
            while (i + 1 < input.length() && array[i + 1] == let) {
                i++;
                count++;
            }
            i++;
            result += count;
        }
        return result;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one == "" || two == "") {
            return false;
        }
        char[] array1 = one.toCharArray();
        char[] array2 = two.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        String string1 = new String(array1);
        String string2 = new String(array2);
        return string1.equals(string2);
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] array = s.toCharArray();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length && array[i + 1] == array[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        int tmp;
        if (m == null) {
            return new int[][]{{}, {}};
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[i].length; j++) {
                tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        char sep;
        if (separator == null) {
            sep = ' ';
        } else {
            sep = separator.charValue();
        }
        if (inputStrings == null) {
            return new String("");
        }
        String result = new String("");
        for (int i = 0; i < inputStrings.length; i++) {
            if (i != inputStrings.length - 1) {
                result += inputStrings[i] + sep;
            } else {
                result += inputStrings[i];
            }
        }
        return result;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }
        int k = 0;
        for (int i = 0; i < inputStrings.length; i++) {
            if (inputStrings[i].indexOf(prefix) == 0) {
                k++;
            }
        }
        return k;
    }
}
