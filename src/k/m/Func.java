package k.m;

import java.util.Objects;

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

    static int rows = 0;
    static int columns = 0;

    public static String coding_polibian_square(String input, String lang) {
        rows = get_rows(lang);
        columns = get_columns(lang);
        char[][] square = get_square(lang);
        StringBuilder code = new StringBuilder(replace(input, rows, columns));
        StringBuilder output = new StringBuilder();
        return getEncodedString(code, output, square);
    }

    private static String getEncodedString(StringBuilder code, StringBuilder output, char[][] square) {
        for (char c : code.toString().toCharArray()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (square[i][j] == Character.toLowerCase(c)) {
                        if (Character.isUpperCase(c)) {
                            if (i == rows - 1) {
                                output.append(Character.toUpperCase(square[0][j]));
                            } else {
                                output.append(Character.toUpperCase(square[i + 1][j]));
                            }
                        } else {
                            if (i == rows - 1) {
                                output.append(square[0][j]);
                            } else {
                                output.append(square[i + 1][j]);
                            }
                        }
                    }
                }
            }
        }
        return output.toString();
    }

    public static String decoding_polibian_square(String input, String lang) {
        char[][] square = get_square(lang);
        StringBuilder code = new StringBuilder(input);
        StringBuilder output = new StringBuilder();
        return getDecodedString(code, output, square);
    }

    private static String getDecodedString(StringBuilder code, StringBuilder output, char[][] square) {
        for (char c : code.toString().toCharArray()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (square[i][j] == Character.toLowerCase(c)) {
                        if (Character.isUpperCase(c)) {
                            if (i == 0) {
                                output.append(Character.toUpperCase(square[rows - 1][j]));
                            } else {
                                output.append(Character.toUpperCase(square[i - 1][j]));
                            }
                        } else {
                            if (i == 0) {
                                output.append(square[rows - 1][j]);
                            } else {
                                output.append(square[i - 1][j]);
                            }
                        }
                    }
                }
            }
        }
        return re_replace(output.toString());
    }

    public static String coding_Caesar(String input, int key, String lang) {
        rows = get_rows(lang);
        columns = get_columns(lang);
        char[] key_lang = get_key(lang);
        StringBuilder code = new StringBuilder(replace(input, rows, columns));
        StringBuilder output = new StringBuilder();
        return getEncodedCeString(key, code, output, key_lang);
    }

    private static String getEncodedCeString(int key, StringBuilder code, StringBuilder output, char[] key_lang) {
        for (char c : code.toString().toCharArray()) {
            for (int i = 0; i < key_lang.length; i++) {
                if (key_lang[i] == Character.toLowerCase(c)) {
                    if (Character.isUpperCase(c)) {
                        if (i > (key_lang.length - key)) {
                            output.append(Character.toUpperCase(key_lang[(i + key) % key_lang.length]));
                        } else {
                            output.append(Character.toUpperCase(key_lang[i + key]));
                        }
                    } else {
                        if (i >= (key_lang.length - key)) {
                            output.append(key_lang[(i + key) % key_lang.length]);
                        } else {
                            output.append(key_lang[i + key]);
                        }
                    }
                }
            }
        }
        return output.toString();
    }

    public static String decoding_Caesar(String input, int key, String lang) {
        char[] key_lang = get_key(lang);
        StringBuilder code = new StringBuilder(input);
        StringBuilder output = new StringBuilder();
        return getDecodedCeString(key, code, output, key_lang);
    }

    private static String getDecodedCeString(int key, StringBuilder code, StringBuilder output, char[] key_lang) {
        for (char c : code.toString().toCharArray()) {
            for (int i = 0; i < key_lang.length; i++) {
                if (key_lang[i] == Character.toLowerCase(c)) {
                    if (Character.isUpperCase(c)) {
                        if (i < (key)) {
                            output.append(Character.toUpperCase(key_lang[i + key_lang.length - key]));
                        } else {
                            output.append(Character.toUpperCase(key_lang[i - key]));
                        }
                    } else {
                        if (i < (key)) {
                            output.append(key_lang[i + key_lang.length - key]);
                        } else {
                            output.append(key_lang[i - key]);
                        }
                    }
                }
            }
        }
        return re_replace(output.toString());
    }

    public static String coding_Caesar_with_keyword(String input, int key, String keyword, String lang) {
        rows = get_rows(lang);
        columns = get_columns(lang);
        char[] key_lang = get_key(lang);
        StringBuilder code = new StringBuilder(replace(input, rows, columns));
        StringBuilder output = new StringBuilder();
        char[] key2 = keys_Caesar(key, keyword, key_lang);
        return getEncodedCeString(key, code, output, key2);
    }

    public static String decoding_Caesar_with_keyword(String input, int key, String keyword, String lang) {
        char[] key_lang = get_key(lang);
        StringBuilder code = new StringBuilder(input);
        StringBuilder output = new StringBuilder();
        char[] key2 = keys_Caesar(key, keyword, key_lang);
        return getDecodedCeString(key, code, output, key2);
    }

    public static String coding_trisemus_table(String input, String keyword, String lang) {
        rows = get_rows(lang);
        columns = get_columns(lang);
        char[] key_lang = get_key(lang);
        StringBuilder code = new StringBuilder(replace(input, rows, columns));
        StringBuilder output = new StringBuilder();
        char[][] square2 = key_trisemus(keyword, key_lang);
        return getEncodedString(code, output, square2);
    }

    public static String decoding_trisemus_table(String input, String keyword, String lang) {
        char[] key_lang = get_key(lang);
        StringBuilder code = new StringBuilder(input);
        StringBuilder output = new StringBuilder();
        char[][] square2 = key_trisemus(keyword, key_lang);
        return getDecodedString(code, output, square2);
    }

    private static char[] keys_Caesar(int key, String keyword, char[] key_lang) {
        StringBuilder code1 = new StringBuilder(keyword);
        StringBuilder cc;
        for (char c : key_lang) {
            if (code1.indexOf(String.valueOf(c)) == -1) {
                code1.append(c);
            }
        }
        String head = code1.substring(0, key_lang.length - key);
        cc = new StringBuilder(code1.substring(key_lang.length - key));
        cc.append(head);
        return cc.toString().toCharArray();
    }

    private static char[][] key_trisemus(String keyword, char[] key_lang) {
        char[][] square2 = new char[rows][columns];
        StringBuilder code1 = new StringBuilder(keyword);
        for (char c : key_lang) {
            if (code1.indexOf(String.valueOf(c)) == -1) {
                code1.append(c);
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
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

    private static int get_rows(String lang) {
        if (Objects.equals(lang, "eng")) {
            return 5;
        }
        if (Objects.equals(lang, "ukr")) {
            return 6;
        }
        return 0;
    }

    private static int get_columns(String lang) {
        if (Objects.equals(lang, "eng")) {
            return 6;
        }
        if (Objects.equals(lang, "ukr")) {
            return 6;
        }
        return 0;
    }

    private static char[][] get_square(String lang) {
        if (Objects.equals(lang, "eng")) {
            return square_eng;
        }
        if (Objects.equals(lang, "ukr")) {
            return square_ukr;
        }
        return new char[0][];
    }

    private static char[] get_key(String lang) {
        if (Objects.equals(lang, "eng")) {
            return key_eng;
        }
        if (Objects.equals(lang, "ukr")) {
            return key_ukr;
        }
        return new char[0];
    }
}