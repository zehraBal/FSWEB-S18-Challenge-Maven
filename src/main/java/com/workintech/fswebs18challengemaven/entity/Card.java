package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="card",schema = "public")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="value")
    private Integer value;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)

    private Color color;


}
