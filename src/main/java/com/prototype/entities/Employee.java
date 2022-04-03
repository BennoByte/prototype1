package com.prototype.entities;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Audited
@Table(name = "tab_employees")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee extends AbstractMasterData {

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String empNr1;

    @Column(nullable = false)
    private String empNr2;

    @Column(nullable = true)
    private Date birthday;

    @Column(nullable = true)
    private Integer card;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmpNr1() {
        return empNr1;
    }

    public void setEmpNr1(String empNr1) {
        this.empNr1 = empNr1;
    }

    public String getEmpNr2() {
        return empNr2;
    }

    public void setEmpNr2(String empNr2) {
        this.empNr2 = empNr2;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public boolean isCard() {
        return this.card != null;
    }
}
