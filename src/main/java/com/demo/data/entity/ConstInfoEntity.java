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
@Table(name = "CONST_INFO")
@Getter
@Setter
@ToString
public class ConstInfoEntity implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 2320032714562509055L;

    @Id
    @Column(name = "CONST_CODE")
    private String constCode;

    @Column(name = "CONST_NAME")
    private String constName;

}
