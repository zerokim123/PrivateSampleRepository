package com.demo.data.entity.join;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "LOGIN_MNGMT")
@Getter
@Setter
@ToString
public class LoginEntity implements UserDetails {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  @Id
  @Column
  private String username;

  @Column
  private String password;

  @Column
  private Timestamp passExDate;

  @Column
  private Timestamp lastLoginDate;

  @Column
  private String loginIdStatus;

  @Column
  private String employeeId;

  @Column
  private String authority;

  @Column
  private String lastName;

  @Column
  private String firstName;

  private String role;

  private String roleName;

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getRoleName() {
    return this.roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(authority));

    return authorities;
  }

  @Override
  public String getPassword() {

    return this.password;
  }

  @Override
  public String getUsername() {

    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {

    return true;
  }

  @Override
  public boolean isAccountNonLocked() {

    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {

    return true;
  }

  @Override
  public boolean isEnabled() {

    return true;
  }

}
