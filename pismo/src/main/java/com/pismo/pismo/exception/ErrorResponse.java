package com.pismo.pismo.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponse {
    private int status;
    private String message;
}
