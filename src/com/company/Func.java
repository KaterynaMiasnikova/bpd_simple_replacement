package com.company;

public class Func {
    static char[][] square_ukr = {
            {'ґ', 'в', 'і', '_', ',', 'ш'},
            {'г', '.', 'а', 'и', 'е', 'ї'},
            {'м', 'б', 'с', 'ч', 'п', 'ж'},
            {'у', 'к', 'т', 'д', 'р', 'є'},
            {'л', 'х', 'з', 'ю', 'о', 'щ'},
            {'й', 'н', 'ь', 'ф', 'ц', 'я'}};

    static char[] key_ukr = {'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л',
            'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я', '.', ',', '_'};

    static char[][] square_eng = {
            {'a', 'd', 'f', '_', 'o', 'g'},
            {'u', '.', 'p', 'r', 'b', 'h'},
            {'n', 'y', 'l', 'k', 'e', 'j'},
            {'m', 's', 't', '?', 'w', 'v'},
            {'i', 'z', 'x', ',', 'c', 'q'}};

    static char[] key_eng = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '?', '.', ',', '_'};
    public static String coding_polibian_square(String input) {
        StringBuilder code = new StringBuilder(replace(input, 6, 6));
        StringBuilder output = new StringBuilder();
        return getEncodedString(code, output, square_ukr);
    }

    private static String getEncodedString(StringBuilder code, StringBuilder output, char[][] square_ukr) {
        for (char c : code.toString().toCharArray()) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (square_ukr[i][j] == Character.toLowerCase(c)) {
                        if (Character.isUpperCase(c)) {
                            if (i == 5) {
                                output.append(Character.toUpperCase(square_ukr[0][j]));
                            } else {
                                output.append(Character.toUpperCase(square_ukr[i + 1][j]));
                            }
                        } else {
                            if (i == 5) {
                                output.append(square_ukr[0][j]);
                            } else {
                                output.append(square_ukr[i + 1][j]);
                            }
                        }
                    }
                }
            }
        }
        return output.toString();
    }

    public static String decoding_polibian_square(String input) {
        StringBuilder code = new StringBuilder(input);
        StringBuilder output = new StringBuilder();
        return getDecodedString(code, output, square_ukr);
    }

    private static String getDecodedString(StringBuilder code, StringBuilder output, char[][] square_ukr) {
        for (char c : code.toString().toCharArray()) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (square_ukr[i][j] == Character.toLowerCase(c)) {
                        if (Character.isUpperCase(c)) {
                            if (i == 0) {
                                output.append(Character.toUpperCase(square_ukr[5][j]));
                            } else {
                                output.append(Character.toUpperCase(square_ukr[i - 1][j]));
                            }
                        } else {
                            if (i == 0) {
                                output.append(square_ukr[5][j]);
                            } else {
                                output.append(square_ukr[i - 1][j]);
                            }
                        }
                    }
                }
            }
        }
        return re_replace(output.toString());
    }

    public static String coding_Caesar(String input, int key) {
        StringBuilder code = new StringBuilder(replace(input, 6, 6));
        StringBuilder output = new StringBuilder();
        return getEncodedCeString(key, code, output, key_ukr);
    }

    private static String getEncodedCeString(int key, StringBuilder code, StringBuilder output, char[] key_ukr) {
        for (char c : code.toString().toCharArray()) {
            for (int i = 0; i < 36; i++) {
                if (key_ukr[i] == Character.toLowerCase(c)) {
                    if (Character.isUpperCase(c)) {
                        if (i > (key_ukr.length - key)) {
                            output.append(Character.toUpperCase(key_ukr[(i + key) % key_ukr.length]));
                        } else {
                            output.append(Character.toUpperCase(key_ukr[i + key]));
                        }
                    } else {
                        if (i >= (key_ukr.length - key)) {
                            output.append(key_ukr[(i + key) % key_ukr.length]);
                        } else {
                            output.append(key_ukr[i + key]);
                        }
                    }
                }
            }
        }
        return output.toString();
    }

    public static String decoding_Caesar(String input, int key) {
        StringBuilder code = new StringBuilder(input);
        StringBuilder output = new StringBuilder();
        return getDecodedCeString(key, code, output, key_ukr);
    }

    private static String getDecodedCeString(int key, StringBuilder code, StringBuilder output, char[] key_ukr) {
        for (char c : code.toString().toCharArray()) {
            for (int i = 0; i < 36; i++) {
                if (key_ukr[i] == Character.toLowerCase(c)) {
                    if (Character.isUpperCase(c)) {
                        if (i < (key)) {
                            output.append(Character.toUpperCase(key_ukr[i + key_ukr.length - key]));
                        } else {
                            output.append(Character.toUpperCase(key_ukr[i - key]));
                        }
                    } else {
                        if (i < (key)) {
                            output.append(key_ukr[i + key_ukr.length - key]);
                        } else {
                            output.append(key_ukr[i - key]);
                        }
                    }
                }
            }
        }
        return re_replace(output.toString());
    }

    public static String coding_Caesar_with_keyword(String input, int key, String keyword) {
        StringBuilder code = new StringBuilder(replace(input, 6, 6));
        StringBuilder output = new StringBuilder();
        char[] key2 = keys_Caesar(key, keyword);
        return getEncodedCeString(key, code, output, key2);
    }

    public static String decoding_Caesar_with_keyword(String input, int key, String keyword) {
        StringBuilder code = new StringBuilder(input);
        StringBuilder output = new StringBuilder();
        char[] key2 = keys_Caesar(key, keyword);
        return getDecodedCeString(key, code, output, key2);
    }

    public static String coding_trisemus_table(String input, String keyword) {
        StringBuilder code = new StringBuilder(replace(input, 6, 6));
        StringBuilder output = new StringBuilder();
        char[][] square2 = key_trisemus(keyword);
        return getEncodedString(code, output, square2);
    }

    public static String decoding_trisemus_table(String input, String keyword) {
        StringBuilder code = new StringBuilder(input);
        StringBuilder output = new StringBuilder();
        char[][] square2 = key_trisemus(keyword);
        return getDecodedString(code, output, square2);
    }

    private static char[] keys_Caesar(int key, String keyword) {
        StringBuilder code1 = new StringBuilder(keyword);
        StringBuilder cc;
        for (char c : Func.key_ukr) {
            if (code1.indexOf(String.valueOf(c)) == -1) {
                code1.append(c);
            }
        }
        String head = code1.substring(0, Func.key_ukr.length - key);
        cc = new StringBuilder(code1.substring(Func.key_ukr.length - key));
        cc.append(head);
        return cc.toString().toCharArray();
    }

    private static char[][] key_trisemus(String keyword) {
        char[][] square2 = new char[6][6];
        StringBuilder code1 = new StringBuilder(keyword);
        for (char c : Func.key_ukr) {
            if (code1.indexOf(String.valueOf(c)) == -1) {
                code1.append(c);
            }
        }
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                square2[i][j] = code1.toString().toCharArray()[count++];
            }
        }
        return square2;
    }

    private static StringBuilder replace(String input, int rows, int columns) {
        int cells = (int) Math.ceil((double) input.length() / (rows * columns));
        StringBuilder code = new StringBuilder(input.replace(" ", "_"));
        while (code.length() < rows * columns * cells) {
            code.append('_');
        }
        return code;
    }

    private static String re_replace(String input) {
        return input.replace("\n", "").replace(" ", "").replace("_", " ");
    }
}