package com.xworkz.wild.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedQuery(name = "fetchAllWildEntity", query = "SELECT i FROM WildEntity i")
@NamedQuery(name="fetchById" ,query="Select a from WildEntity a where a.ID=:ID")


@Table(name="wild_sparks")
public class WildEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;

    @Column(name="DocumentaryName")
    private String DocumentaryName;

    @Column(name="Episode")
    private Integer Episode;

    @Column(name="Photographer")
    private String Photographer;

    @Column(name="FilmingLocation")
    private String FilmingLocation;

    @Column(name="Category")
    private String Category;








}
