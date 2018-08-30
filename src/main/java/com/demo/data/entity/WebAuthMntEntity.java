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
@Table(name = "WEB_AUTH_MNT")
@Getter
@Setter
@ToString
public class WebAuthMntEntity implements Serializable {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = -7889989712650971038L;

  @Id
  @Column
  private String employeeId;

  @Column
  private String loginId;

  @Column
  private String authority;

}
