
package com.simpl.paylater.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant")
public class Merchant {

  @Id
  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "discount_percentage")
  private double discountPercentage;

  @Column(name = "total_discount_amount")
  private double totalDiscountAmount;

  @Column(name = "created_on", insertable = false)
  private Timestamp createdOn;

  @Column(name = "updated_on", insertable = false)
  private Timestamp updatedOn;

  public Merchant(String email, String name, double discountPercentage) {
    this.email = email;
    this.name = name;
    this.discountPercentage = discountPercentage;
  }

  public Merchant() {
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

  public double getDiscountPercentage()
  {
    return discountPercentage;
  }

  public void setDiscountPercentage(double discountPercentage)
  {
    this.discountPercentage = discountPercentage;
  }

  public double getTotalDiscountAmount()
  {
    return totalDiscountAmount;
  }

  public void setTotalDiscountAmount(double totalDiscountAmount)
  {
    this.totalDiscountAmount = totalDiscountAmount;
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
    return "Merchant{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", discountPercentage=" + discountPercentage +
            ", totalDiscountAmount=" + totalDiscountAmount +
            ", createdOn=" + createdOn +
            ", updatedOn=" + updatedOn +
            '}';
  }
}
