package ru.gb.patterns.structural.composite;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Item root = new Dir(
                List.of(
                        new ImageFile("1"),
                        new ImageFile("2"),
                        new ImageFile("3"),
                        new ImageFile("4"),
                        new Dir(
                                List.of(
                                        new ImageFile("5"),
                                        new ImageFile("6"),
                                        new ImageFile("7"),
                                        new ImageFile("8"),
                                        new Dir(
                                                List.of(
                                                        new ImageFile("9"),
                                                        new ImageFile("10"),
                                                        new ImageFile("11"),
                                                        new ImageFile("12")
                                                )
                                        )
                                )
                        )
                )
        );

        System.out.println(root);

    }
}
