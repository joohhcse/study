package com.example.study.model.entity;

//DB의 테이블 이름과 같이 User로

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Table(name = "user") DB테이블 이름과 같으면 필요 x
@Data
@AllArgsConstructor
@NoArgsConstructor      //기본생성자
@Entity     // == table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

}
