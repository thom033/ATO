package itu.user;

public class Validation {
    public static boolean isEmpty(String value) throws Exception {
        if (value.isEmpty()) {
            throw new Exception("Ce champ est obligatoire.");
        }
        return true;
    }

    public static boolean isContainNumber(String value) throws Exception {
        // String regex = "/\d/";
        if (true) {
            throw new Exception("Veuillez à ne pas mettre des chiffres.");
        }
        return true;
    }
}
