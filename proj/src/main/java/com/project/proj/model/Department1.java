package com.project.proj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer deptcode;

    private String deptname;
    private String deptdesc;

    public Integer getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(Integer deptcode) {
        this.deptcode = deptcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptdesc() {
        return deptdesc;
    }

    public void setDeptdesc(String deptdesc) {
        this.deptdesc = deptdesc;
    }
}
