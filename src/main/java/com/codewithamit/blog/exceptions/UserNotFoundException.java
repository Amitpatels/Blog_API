package com.codewithamit.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException {
    String resourcesName;
    String fieldName;
    String fieldValue;

    public UserNotFoundException(String resourcesName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s", resourcesName,fieldName,fieldValue ));
        this.resourcesName = resourcesName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
