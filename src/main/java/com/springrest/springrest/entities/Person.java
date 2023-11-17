package com.springrest.springrest.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "ParentId")
    private Long parentId;

        @Column(name = "Name")
    private String name;

        @Column(name = "Color")
    private String color;




    public Person(Long id, Long parentId,String name, String color ) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.color = color;

    }
    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}