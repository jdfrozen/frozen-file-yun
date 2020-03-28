package com.frozen.frozenfileyun.dto;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
@Entity
@Table(name = "t_user")
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
}
