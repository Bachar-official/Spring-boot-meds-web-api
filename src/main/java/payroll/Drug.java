package payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Drug {

    private @Id @GeneratedValue Long drugid;
    private String name;
    private String action;
    private String location;
    private String expired;

    Drug() {}

    Drug(String name, String action, String location, String expired) {
        this.name = name;
        this.action = action;
        this.location = location;
        this.expired = expired;
    }

    public Long getId() {
        return this.drugid;
    }

    public String getName() {
        return this.name;
    }

    public String getAction() {
        return this.action;
    }

    public String getLocation() {
        return this.location;
    }

    public String getExpired() {
        return this.expired;
    }

    public void setId(Long id) {
        this.drugid = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drug)) return false;
        Drug drug = (Drug) o;
        return drug.equals(o);
    }

    @Override
    public String toString() {
        return "{drugid=" + this.drugid + ", name=" + this.name + ", action=" + this.action
        + ", location=" + this.location + " ,expired=" + this.expired + '}';
    }
}