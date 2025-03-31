package models.enums;

public enum Rating {
    NJE(1),
    DY(2),
    TRE(3),
    KATER(4),
    PESE(5);

    private final int vlera;

    Rating (int vlera) {
        this.vlera = vlera;
    }

    public int getVlera() {
        return vlera;
    }

    public static Rating fromValue(int vlera) {
        for(Rating r : Rating.values()) {
            if(r.vlera == vlera) {
                return r;
            }
        }
        throw new IllegalArgumentException("Invalid rating value: " + vlera);
    }

    @Override
    public String toString() {
        return String.valueOf(vlera);
    }
}
