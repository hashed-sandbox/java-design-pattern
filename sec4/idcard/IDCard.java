package idcard;

import framework.Product;

public class IDCard extends Product {
  private String owner;
  IDCard(String owner) {
    System.out.println("Creating " + owner + "'s card...");
    this.owner = owner;
  }
  public void use() {
    System.out.println("Using " + owner + "'s card...");
  }
  public String getOwner() {
    return owner;
  }
}
