package com.demo.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEE_INFO")
@Getter
@Setter
@ToString
public class EmployeeInfoEntity implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 7027069115497552022L;

    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column
    private String constCode;

    @Column
    private String loginId;

    @Column
    private String firstName;

    @Column
    private String lastName;


}
