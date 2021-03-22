package com.ivillarroelr.TIHI14evdiag.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MetadataDTO implements Serializable {

    private String timestamp;
    private String message;
    private Integer statusCode;

}
