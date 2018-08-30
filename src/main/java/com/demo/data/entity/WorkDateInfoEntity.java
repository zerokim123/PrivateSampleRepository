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
@Table(name = "WORK_DATE_INFO")
@Getter
@Setter
@ToString
public class WorkDateInfoEntity implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -5265757698280787360L;

    @Id
    @Column
    private String employeeId;

    @Column
    private String workYear;

    @Column
    private String workMonth;

    @Column
    private String constCode;

    @Column
    private String constName;

    @Column
    private Double workDate;

}
