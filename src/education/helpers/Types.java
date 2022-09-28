package education.helpers;

public enum Types {
    FORMATEUR("FORMATEUR"),
    ADMINISTRATEUR("ADMINISTRATEUR"),
    APPRENANAT("APPRENANAT");

    private final String value;
    Types(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return this.value;
    }
}
