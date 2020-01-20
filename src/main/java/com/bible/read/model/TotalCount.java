package com.bible.read.model;

public class TotalCount {

  private String name;
  private int count;

  public TotalCount(String name, int count) {
    this.name = name;
    this.count = count;
  }

  public TotalCount() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
