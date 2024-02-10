import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
* by @heiphin7
*/

public class Main{
    public static void main(String[] args) throws IOException {
        // Инициализируем поток входных данных(из консоля) для считывания пути к файлу.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите путь к файлу:");
        String fileName = bufferedReader.readLine();

        // Используем scanner и FileInputStream для считывания данных из указанного файла
        try{
            Scanner scanner = new Scanner(new FileInputStream(fileName));

            /* Это наши счётчики
             *   charsCounter - Это количество символов, без учета пробелов
             *  wordCounter - Это количество слов.
             *  symboleCounter - Общее количество символов в строке, с учётом пробелов.
             */
            int charsCounter = 0;
            int wordCounter = 0;
            int symboleCounter = 0;

            // Запускаем цикл, работающий до тех пор, пока в файле есть данные
            while(scanner.hasNext()){
                String s = scanner.nextLine();
                // Количество символо считается легко, стоит просто использовать готовый метод length()
                symboleCounter += s.length();

                // Цикл, предназначенный для подсчёта количества символов, без учета пробела
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i) != ' '){
                        charsCounter++;
                    }
                }
                /*
                 * Тут алгоритм для подсчёта количества слов, он может показаться сложным, но нет
                 * Сначала, мы разбиваем нашу строку в массив строк, разделяя их по пробелу.
                 * Для разделения строки мы используем регулярное выражение(\\s+)
                 */
                String[] wordsInStr = s.split("\\s+");
                // В конце мы просто добавляем количество элементов в массиве к нашему счётчику
                wordCounter += wordsInStr.length;
            }

            // Вывод исходных данных
            System.out.println("Количество общих символов с учетом пробелов: " + symboleCounter);
            System.out.println("Количество символов без учета пробелов: " + charsCounter);
            System.out.println("Количество слов в файле: "  + wordCounter);

            // Не забываем закрывать наши потоки:)
            scanner.close();
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("Не удалось найти файл:(");
        }
    }
}