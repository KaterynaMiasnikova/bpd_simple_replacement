package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.print("\nВхідна фраза:\n");
        String input = "Логіка може привести вас від пункту А до пункту Б, а уява куди завгодно.";
        System.out.print(input);
        System.out.print("\n");
        System.out.print("\nШифрування способом полібіанського квадрата:\n");
        String output_1 = Func.coding_polibian_square(input);
        System.out.println(output_1);
        System.out.print("\nДешифрування способом полібіанського квадрата:\n");
        String output_11 = Func.decoding_polibian_square(output_1);
        System.out.println(output_11);
        System.out.print("\nШифрування способом Цезаря:\n");
        String output_2 = Func.coding_Caesar(input, 3);
        System.out.println(output_2);
        System.out.print("\nДешифрування способом Цезаря:\n");
        String output_22 = Func.decoding_Caesar(output_2, 3);
        System.out.println(output_22);
        String keyword = "мяснікова";
        System.out.print("\nШифрування способом Цезаря з ключем:\n");
        String output_3 = Func.coding_Caesar_with_keyword(input, 3, keyword);
        System.out.println(output_3);
        System.out.print("\nДешифрування способом Цезаря з ключем:\n");
        String output_33 = Func.decoding_Caesar_with_keyword(output_3, 3, keyword);
        System.out.println(output_33);
        System.out.print("\nШифрування способом таблиці Трисемуса:\n");
        String output_4 = Func.coding_trisemus_table(input, keyword);
        System.out.println(output_4);
        System.out.print("\nДешифрування способом таблиці Трисемуса:\n");
        String output_44 = Func.decoding_trisemus_table(output_4, keyword);
        System.out.println(output_44);
    }
}