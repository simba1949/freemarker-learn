package vip.openpark.operation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author anthony
 * @version 2024/3/22 9:56
 */
@Getter
@Setter
@Builder
@ToString
public class Book {
    private String name;
    private BigDecimal price;

    private Person author;
}