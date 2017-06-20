package com.company;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.*;

public class Shorty implements Comparator<Shorty> {
  String name;
  int age;
  double height;
  String hobby;
  Status status;
  private int id;
  ZonedDateTime date;

  public Shorty(String name, int age, double height, String hobby, Status status, int id, ZonedDateTime date) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.hobby = hobby;
    this.status = status;
    this.id = id;
    this.date = date;
  }

  public String toString() {
    return "{name: '" + this.name + "', age: " + this.age + ", height: " + this.height + ", hobby: '" + this.hobby + "'" +
        ", status: " + this.status + ", id: " + this.id + ", date: '" + this.date + "'}%";
  }

  public int compare(Shorty a, Shorty b) {
    if (a.name.compareTo(b.name) == 0) {
      if (a.age == b.age) {
        if (a.height == b.height) {
          if (a.hobby.compareTo(b.hobby) == 0) {
            return a.status.toString().compareTo(b.status.toString());
          } else return a.hobby.compareTo(b.hobby);
        } else if (a.height - b.height > 0) {
          return 1;
        } else return -1;
      } else return a.age - b.age;
    } else return a.name.compareTo(b.name);
  }
}