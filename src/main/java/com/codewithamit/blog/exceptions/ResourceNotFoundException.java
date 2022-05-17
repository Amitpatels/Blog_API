package com.codewithamit.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException{
    String resourcesName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourcesName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s", resourcesName,fieldName,fieldValue ));
        this.resourcesName = resourcesName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
