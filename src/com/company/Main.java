package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nPassphrase for encryption:\n");//"You become responsible, forever, for what you have tamed."
        String input = in.nextLine();//"Логіка може привести вас від пункту А до пункту Б, а уява куди завгодно."
        System.out.print(input);
        System.out.print("\nLanguage of passphrase(eng/ukr):\n");
        String lang = in.nextLine();
        System.out.print(lang);
        System.out.print("\n");
        System.out.print("\nPolybian square encryption:\n");
        String output_1 = Func.coding_polibian_square(input, lang);
        System.out.println(output_1);
        System.out.print("\nPolybian square decryption:\n");
        String output_11 = Func.decoding_polibian_square(output_1, lang);
        System.out.println(output_11);
        System.out.print("\nCaesar encryption:\n");
        String output_2 = Func.coding_Caesar(input, 3, lang);
        System.out.println(output_2);
        System.out.print("\nCaesar decryption:\n");
        String output_22 = Func.decoding_Caesar(output_2, 3, lang);
        System.out.println(output_22);
        System.out.print("\nPassphrase for encryption:\n");
        String keyword = in.nextLine();//"мяснікова"
        System.out.print("\nCaesar encryption with a key:\n");
        String output_3 = Func.coding_Caesar_with_keyword(input, 3, keyword, lang);
        System.out.println(output_3);
        System.out.print("\nCaesar decryption with a key:\n");
        String output_33 = Func.decoding_Caesar_with_keyword(output_3, 3, keyword, lang);
        System.out.println(output_33);
        System.out.print("\nTrisemous table encryption:\n");
        String output_4 = Func.coding_trisemus_table(input, keyword, lang);
        System.out.println(output_4);
        System.out.print("\nTrisemous table decryption:\n");
        String output_44 = Func.decoding_trisemus_table(output_4, keyword, lang);
        System.out.println(output_44);
    }
}