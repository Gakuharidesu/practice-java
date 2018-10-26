package com.sample.Sample.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable {

    private static final long serialVersionUID = -198279411106543L;

    private String userId;

    private String userName;

    private String createdAt;

    @JsonInclude(Include.NON_NULL)
    private String updatedAt;
}
