package logic;

public enum Days {

    SUNDAY(1),

    MONDAY(2),

    TUESDAY(3),

    WEDNESDAY(4),

    THURSDAY(5),

    FRIDAY(6),

    SATURDAY(7);

    private final int value;

    private Days(int value) {
        this.value = value;
    }

    public static Days getEnum(int i) {
        return Days.values()[i];
    }

    public int getValue() {
        return value -1;
    }
}
