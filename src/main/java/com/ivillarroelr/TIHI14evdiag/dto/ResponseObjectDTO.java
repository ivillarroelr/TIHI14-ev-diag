package com.ivillarroelr.TIHI14evdiag.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseObjectDTO implements Serializable {

    private MetadataDTO metadata;
    private Object data;

}
