package org.example.homework.dto;

import lombok.Getter;

@Getter
public class MemberResponse {
    private final long id;
    private final String name;

    public MemberResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
