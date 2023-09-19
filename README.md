## Проект frequency_character_encounters
О проекте
Проект счётчик символов - это приложение с помощью которого можно вычислить частоту встречи
символов по заданной строке. Пользователь может с помощью сервиса тестирования отправлять 
символы в виде строки например - “aaaaabcccc”, через POST запрос в формате JSON, в ответ
получая данные о количестве символов в виде строки в формате - " “a”: 5, “c”: 4, “b”: 1 ", 
отсортированных по убыванию количества вхождений символа в заданную строку. 
Запуск приложения можно осуществлять через среду разработки IntelliJ IDEA класс Main или через файл
frequency_character_encounters.exe или через командную строку.
Через командную строку запускать нужно следующим образом:
- открываем командную строку, переходим в папку где расположен jar файл через cd C:\Users....
- запускаем приложение через - java -jar frequency_character_encounters.jar

## Технологический стек
- Spring boot 2.7.10
- JUnit 5
- Lombok

## Требования по окружению
- Java 17
- Java 3.6.3