package touristrestservice.model.entities.enums;

import java.util.Locale;

public enum SkillCategory {
    BEGINNER, INTERMEDIATE, ADVANCED;

    public static SkillCategory fromString(String s) {
        return switch (s.toLowerCase(Locale.ROOT)) {
            case "advanced" -> SkillCategory.ADVANCED;
            case "intermediate" -> SkillCategory.INTERMEDIATE;
            case "beginner" -> SkillCategory.BEGINNER;
            default -> throw new IllegalArgumentException(s + " is not a valid string name");
        };
    }
}
