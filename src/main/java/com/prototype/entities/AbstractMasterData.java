package com.prototype.entities;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited
@MappedSuperclass
public abstract class AbstractMasterData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String symbol;

    @Column(length = 6, nullable = false)
    private String color;

    private boolean deleted;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
