package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book poem = new Book("poems", 10);
        Book story = new Book("story", 50);
        Book cc = new Book("Clean code", 20);
        Book novel = new Book("novel", 150);

        Book[] books = new Book[4];

        books[0] = poem;
        books[1] = story;
        books[2] = cc;
        books[3] = novel;

        for (int i = 0 ; i < books.length ; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getCount());
        }
        Book tmp = new Book("",0);
        tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for(Book b : books) {
            if(b.getName().equals("Clean code")) {
                System.out.println(b.getName() + " - " + b.getCount());
            }
        }
    }
}
