/////////////////////////////////////////////////////////////////////////////////////////
// Лабораторная работа №1 по дисциплине ЛОИС
// Вариант А: Подсчитать количество подформул в формуле сокращенной логики высказываний
// Выполнена студентом грруппы 821701 БГУИР Холупко Александром Андреевичем
// Класс предназначен для проверки формулы и для проверки знаний пользователя

import config.Config;
import parser.Parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String expression = "";
        StringBuilder builder = new StringBuilder(expression);
        try (FileInputStream fin = new FileInputStream(Config.IN_FILE_PATH)) {
            while (fin.available() > 0) {
                int oneByte = fin.read();
                builder.append(((char) oneByte));
            }
            expression = builder.toString();
        } catch (FileNotFoundException ex) {
            System.out.println("File not find!");
        }
        if (expression.equals("")) {
            System.out.println("Formula len = 0");
            System.out.println("There is no sub formulas!");
            System.exit(0);
        }

        System.out.println("\nExpression : " + expression + "\n");
        Parser parser = new Parser(expression);
        System.out.println(parser.getMessage());
    }
}
