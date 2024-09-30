package org.token.generate;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Version;


@Entity("Books")
public class Book {
    @Id
    private String isbn;
    @Version
    private Long version;


    private String title;
    private String author;
    @Property("number")
    private String number;
    @Property("javaPerformanceCompanion")
    private String javaPerformanceCompanion;
    @Property("price")
    private double cost;


    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getJavaPerformanceCompanion() {
        return javaPerformanceCompanion;
    }

    public void setJavaPerformanceCompanion(String javaPerformanceCompanion) {
        this.javaPerformanceCompanion = javaPerformanceCompanion;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }



    public Book(String number, String javaPerformanceCompanion, String author, double v, Publisher publisher) {
        this.number=number;
        this.javaPerformanceCompanion=javaPerformanceCompanion;
        this.author=author;
    }

    public Book() {
    }

    // constructors, getters, setters and hashCode, equals, toString implementations
}
