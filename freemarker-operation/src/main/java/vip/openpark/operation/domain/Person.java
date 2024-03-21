package vip.openpark.operation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author anthony
 * @version 2024/3/21 21:24
 */
@Getter
@Setter
@Builder
public class Person {
    private Long id;
    private String name;
    private Integer age;
    private Byte sex;
    private LocalDateTime birthday;
}