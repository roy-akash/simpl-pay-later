
package com.simpl.paylater.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

  @Id
  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "credit_limit")
  private double creditLimit;

  @Column(name = "dues")
  private double dues;

  @Column(name = "created_on",insertable = false)
  private Timestamp createdOn;

  @Column(name = "updated_on",insertable = false)
  private Timestamp updatedOn;

  public User(String name, String email, double creditLimit) {
    this.name = name;
    this.email = email;
    this.creditLimit = creditLimit;
  }

  public User() {
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public double getCreditLimit()
  {
    return creditLimit;
  }

  public void setCreditLimit(double creditLimit)
  {
    this.creditLimit = creditLimit;
  }

  public double getDues()
  {
    return dues;
  }

  public void setDues(double dues)
  {
    this.dues = dues;
  }

  public Timestamp getCreatedOn()
  {
    return createdOn;
  }

  public void setCreatedOn(Timestamp createdOn)
  {
    this.createdOn = createdOn;
  }

  public Timestamp getUpdatedOn()
  {
    return updatedOn;
  }

  public void setUpdatedOn(Timestamp updatedOn)
  {
    this.updatedOn = updatedOn;
  }

  @Override
  public String toString()
  {
    return "User{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", creditLimit=" + creditLimit +
            ", dues=" + dues +
            ", createdOn=" + createdOn +
            ", updatedOn=" + updatedOn +
            '}';
  }
}
