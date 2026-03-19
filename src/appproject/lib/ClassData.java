package appproject.lib;

public record ClassData(
        int code,
        String class_title,
        String class_name,
        Programs program,
        double units,
        String description
) {}