package vip.openpark.operation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author anthony
 * @version 2024/3/21 21:24
 */
@Getter
@Setter
@Builder
@ToString
public class Person {
    private String name;
    private Byte sex;
    private LocalDateTime birthday;
}