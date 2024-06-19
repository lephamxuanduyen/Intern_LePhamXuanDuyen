package enums;

public enum Station {
    SAIGON("Sài Gòn"),
    NHATRANG("Nha Trang"),
    PHANTHIET("Phan Thiết"),
    QUANGNGAI("Quảng Ngãi"),
    DANANG("Đà Nẵng"),
    HUE("Huế");

    private String value;

    Station(String value) {
        this.value = value;
    }

    public String getStationValue() {
        return value;
    }
}

