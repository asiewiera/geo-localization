package dtos;


import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

public class LocalizationDto {

    @Min(0)
    private Long id;

    @Min(0)
    private Long deviceId;

    @Pattern(regexp = "^-?([1-8]?[0-9]\\.{1}\\d{1,6}$|90\\.{1}0{1,6}$)")
    private String latitude;

    @Pattern(regexp = "^-?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[1-7][0-9])(?:(?:\\.[0-9]{1,6})?))$")
    private String longitude;
    private Timestamp dateCreated;

    public LocalizationDto() {
    }


    public LocalizationDto(Long id, Long deviceId, String latitude, String longitude) {
        this.id = id;
        this.deviceId = deviceId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }


    public LocalizationDto(Long id, Long deviceId, String latitude, String longitude, Timestamp dateCreated) {
        this.id = id;
        this.deviceId = deviceId;
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

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "LocalizationDto{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
