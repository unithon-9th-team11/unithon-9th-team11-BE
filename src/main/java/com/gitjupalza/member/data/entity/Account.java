package com.gitjupalza.member.data.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 3
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column(nullable = false, length = 30, unique = true) // 1
    private String id;

    private String password; // 2

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Builder
    public Account(String id, String password, List<String> roles) {
        this.id = id;
        this.password = password;
        this.roles = roles;
    }
}
