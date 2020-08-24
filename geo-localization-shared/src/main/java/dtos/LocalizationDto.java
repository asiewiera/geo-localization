package dtos;


import java.sql.Timestamp;

public class LocalizationDto {

    private Long id;
    private String latitude;
    private String longitude;
    private Timestamp dateCreated;

    public LocalizationDto() {
    }


    public LocalizationDto(Long id, String latitude, String longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }


    public LocalizationDto(Long id, String latitude, String longitude, Timestamp dateCreated) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "LocalizationDto{" +
                "id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
