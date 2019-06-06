package entity;

import jdk.net.SocketFlow;

public class Student {
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String address;
    private String role;
    private int status;

    public Student() {
        this.username = "";
        this.password = "";
        this.email = "";
        this.fullname = "";
        this.address = "";
    }

    public Student(String username, String password, String email, String fullname, String role, String address, int status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.role = role;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null){
            status = Status.DEACTIVE;
        }
        this.status = status.getValue();
    }

    public enum Status {
        ACTIVE(1), DEACTIVE(0), DELETED(-1);
        int value;
        Status(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

        public static Status findByValue(int value){
            for (Status status:
            Status.values()){
                if(status.getValue() == value){
                    return status;
                }
            }
            return null;
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
