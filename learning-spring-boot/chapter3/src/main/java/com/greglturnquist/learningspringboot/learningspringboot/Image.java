package com.greglturnquist.learningspringboot.learningspringboot;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Image {

    @Id
    private final String id;
    private final String name;

    public Image(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
