package appproject.lib;

public record ClassesData(int code, String class_title, String class_name, Programs program, double units, String description) {
    public enum Programs {
        BSCS,
        BSIT,
        BSCpE
    }
}
