package cloud.autotests.models;

public enum City {
    KAZAN("КАЗАНЬ"),
    CHEBOKSARY("ЧЕБОКСАРЫ"),
    MOSCOW("МОСКВА"),
    RYAZAN("РЯЗАНЬ"),
    SEVASTOPOL("СЕВАСТОПОЛЬ"),
    OMSK("ОМСК");

    private final String description;

    City(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
