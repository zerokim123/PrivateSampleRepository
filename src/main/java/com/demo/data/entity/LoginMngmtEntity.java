package com.demo.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "LOGIN_MNGMT")
@Getter
@Setter
@ToString
public class LoginMngmtEntity implements Serializable {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = 9017808521154060501L;

  @Id
  @Column
  private String loginId;

  @Column
  private String loginPass;

  @Column
  private Timestamp passExDate;

  @Column
  private Timestamp lastLoginDate;

  @Column
  private String loginIdStatus;

}
