package com.protosstechnology.train.bootexamine.Entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@Getter @Setter
public class Document {
    @Id @GeneratedValue
    private Long id;
    private String documentNumber;
    private String description;
}
