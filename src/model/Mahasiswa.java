package model;

import java.util.Arrays;

public class Mahasiswa {
  public String name;
  public String address;
  public int age;
  public char gender;
  public String[] hobbies;
  public float gpa;

  public Mahasiswa(String name, String address, int age, char gender, String[] hobbies, float gpa) {
    this.name = name;
    this.address = address;
    this.age = age;
    this.gender = gender;
    this.hobbies = hobbies;
    this.gpa = gpa;
  }

  @Override
  public String toString() {
    return "Mahasiswa [name=" + name + ", address=" + address + ", age=" + age + ", gender=" + gender + ", hobbies="
        + Arrays.toString(hobbies) + ", gpa=" + gpa + "]";
  }
}
