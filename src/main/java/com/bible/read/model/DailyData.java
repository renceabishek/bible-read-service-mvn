package com.bible.read.model;

import com.google.firebase.database.Exclude;

public class DailyData {

  @Exclude
  private String uniqueId;
  private String date;
  private String name;
  private String portion;
  private String chapter;
  private int fromVerses;
  private int toVerses;

  public DailyData() {
  }

  public DailyData(String uniqueId, String date, String name, String portion,
      String chapter, int fromVerses, int toVerses) {
    this.uniqueId = uniqueId;
    this.date = date;
    this.name = name;
    this.portion = portion;
    this.chapter = chapter;
    this.fromVerses = fromVerses;
    this.toVerses = toVerses;
  }

  public String getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(String uniqueId) {
    this.uniqueId = uniqueId;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPortion() {
    return portion;
  }

  public void setPortion(String portion) {
    this.portion = portion;
  }

  public String getChapter() {
    return chapter;
  }

  public void setChapter(String chapter) {
    this.chapter = chapter;
  }

  public int getFromVerses() {
    return fromVerses;
  }

  public void setFromVerses(int fromVerses) {
    this.fromVerses = fromVerses;
  }

  public int getToVerses() {
    return toVerses;
  }

  public void setToVerses(int toVerses) {
    this.toVerses = toVerses;
  }
}
