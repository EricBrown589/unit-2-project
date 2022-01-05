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
  private Double balance;

  @OneToMany(mappedBy = "account", orphanRemoval = true)
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Transaction> transactionList;

  // USER TABLE
  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  public Account(Long id, String name, Double balance) {
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

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "Account{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", balance='" + balance + '\'' +
        '}';
  }

  public List<Transaction> getTransactionList() {
    return transactionList;
  }

  public void setTransactionList(List<Transaction> transactionList) {
    this.transactionList = transactionList;
  }

  /********** user getters and setters **********/
  public User getUser() { return user; }

  public void setUser(User user) { this.user = user; }
  /********** end of user getters and setters **********/

}
