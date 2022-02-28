package com.record.backend.dto.tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class TagDto {
    private Long id;
    private String name;

    public static TagDto of(Long id, String name) {
        return new TagDto(id, name);
    }

    public TagDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
