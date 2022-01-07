package com.banking.bankingapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.banking.bankingapi.model.Transaction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private double balance;

  @OneToMany(mappedBy = "account", orphanRemoval = true)
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Transaction> transactionList;

  // USER TABLE
  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  public Account(Long id, String name, double balance) {
    this.id = id;
    this.name = name;
    this.balance = balance;
  }

  public Account() {}

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get balance
   * @return
   */
  public double getBalance() {
    return balance;
  }
  public void setBalance(double balance) {
    this.balance = balance;
  }

  /********** transactionList getters and setters **********/
  public List<Transaction> getTransactionList() {
    return transactionList;
  }
  public void setTransactionList(List<Transaction> transactionList) {
    this.transactionList = transactionList;
  }

  /********** user getters and setters **********/
  public User getUser() { return user; }

  /**
   *
   * @param user
   */
  public void setUser(User user) { this.user = user; }

  /**
   *
   * @return
   */
  @Override
  public String toString() {
    return "Account{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", balance='" + balance + '\'' +
        '}';
  }
}
