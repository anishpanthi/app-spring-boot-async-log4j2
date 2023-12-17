package dev.app.spring.api.family;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDateTime;

/**
 * @author Anish Panthi
 */
public record Member(
    Long id,
    String type,
    String fullName,
    String words,
    String updatedName,

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updatedOn) {

}
