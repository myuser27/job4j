package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово: " + eng;
    }

    public static void main(String[] args) {
        String word = "word";
        DummyDic dic = new DummyDic();
        System.out.println(dic.engToRus(word));
    }
}
