package com.tk.datastructure.array;

public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


    public static void main(String[] args) {

        Array<Student> array = new Array<>();
        array.addLast(new Student("Tom", 66));
        array.addLast(new Student("HeiQiu", 75));
        array.addLast(new Student("TK", 100));
        System.out.println(array);
    }
}
