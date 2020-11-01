/*Create table Doctordetails
(
postId integer,
doctorId integer,
realName varchar(30),
department varchar(40),
address varchar(60),
locationLat varchar(20),
locationLong varchar(20),
location  varchar(30),
OpenTime varchar(20),
closeTime varchar(20),
postTime date,
Primary key(postId)
);*/
import java.time.*;
public class DoctorDetail {
    private int id;
    private int doctorId;
    private String realName;
    private String department;
    private String password;
    private String usertype;
    private String lat;
    private String longt;
    private String address;
    private String location;
    private String openTime;
    private String closeTime;
    private LocalDate postTime;

    public DoctorDetail(int id, int doctorId,
                String realName, String department,
                String password, String usertype,
                String lat, String longt,
                String address, String location,
                String openTime, String closeTime,
                LocalDate postTime) {
        this.id = id;
        this.doctorId = doctorId;
        this.realName = realName;
        this.department = department;
        this.password = password;
        this.usertype = usertype;
        this.lat = lat;
        this.longt = longt;
        this.address = address;
        this.location = location;
        this.openTime = openTime;
        this.closeTime =closeTime;
        this.postTime = postTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongt() {
        return longt;
    }

    public void setLongt(String longt) {
        this.longt = longt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }
    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public LocalDate getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDate postTime) {
        this.postTime = postTime;
    }


}