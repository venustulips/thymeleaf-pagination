package com.example.thymeleafpagination;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String field;

    public Long getId() {
        return id;
    }

    public MyEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getField() {
        return field;
    }

    public MyEntity setField(String field) {
        this.field = field;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEntity myEntity = (MyEntity) o;
        return Objects.equals(id, myEntity.id) && Objects.equals(field, myEntity.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, field);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", field='" + field + '\'' +
                '}';
    }
}