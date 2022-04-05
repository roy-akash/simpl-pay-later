
package com.simpl.paylater.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id")
  private long id;

  @Column(name = "amount")
  private double amount;

  @Column(name = "discount")
  private double discount;

  @Column(name = "user_name")
  private String user;

  @Column(name = "merchant")
  private String merchant;

  @Column(name = "created_on", insertable = false)
  private Timestamp createdOn;

  public Transaction(double amount, double discount, String user, String merchant) {
    this.amount = amount;
    this.discount = discount;
    this.user = user;
    this.merchant = merchant;
  }

  public Transaction() {
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public double getAmount()
  {
    return amount;
  }

  public void setAmount(double amount)
  {
    this.amount = amount;
  }

  public double getDiscount()
  {
    return discount;
  }

  public void setDiscount(double discount)
  {
    this.discount = discount;
  }

  public String getUser()
  {
    return user;
  }

  public void setUser(String user)
  {
    this.user = user;
  }

  public String getMerchant()
  {
    return merchant;
  }

  public void setMerchant(String merchant)
  {
    this.merchant = merchant;
  }

  public Timestamp getCreatedOn()
  {
    return createdOn;
  }

  public void setCreatedOn(Timestamp createdOn)
  {
    this.createdOn = createdOn;
  }

  @Override
  public String toString()
  {
    return "Transaction{" +
            "id=" + id +
            ", amount=" + amount +
            ", discount=" + discount +
            ", user='" + user + '\'' +
            ", merchant='" + merchant + '\'' +
            ", createdOn=" + createdOn +
            '}';
  }
}
