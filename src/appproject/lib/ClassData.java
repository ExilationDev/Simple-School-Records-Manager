package appproject.lib;

import java.util.ArrayList;

public record ClassData(
        int code,
        String class_title,
        String class_name,
        Programs program,
        double units,
        String description
) {}