package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainers")
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "tid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tid;
    
    @Column(name = "tname")
    private String tname;
    
    @Column(name = "tlname")
    private String tlname;
    
    @Column(name = "tsubject")
    private String tsubject;
    
    public Trainer() {
    }

    public Trainer(String tname, String tlname, String tsubject) {
        this.tname = tname;
        this.tlname = tlname;
        this.tsubject = tsubject;
    }

    public Trainer(Long tid, String tname, String tlname, String tsubject) {
        this.tid = tid;
        this.tname = tname;
        this.tlname = tlname;
        this.tsubject = tsubject;
    }
    
    

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tid + ":   Name=" + tname + ",  Surname=" + tlname + ",  Subject=" + tsubject;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTlname() {
        return tlname;
    }

    public void setTlname(String tlname) {
        this.tlname = tlname;
    }

    public String getTsubject() {
        return tsubject;
    }

    public void setTsubject(String tsubject) {
        this.tsubject = tsubject;
    }
    
    
}
