package application;

public class Incident {
    private String ref;
    private String time;
    private String status;

    public Incident(String ref, String time, String status) {
        this.ref = ref;
        this.time = time;
        this.status = status;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}