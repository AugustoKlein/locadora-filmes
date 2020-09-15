package com.locadora.locadorafilmes.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomErrorResponse implements Serializable {

    private int status;
    private String timestamp;
    private String message;
}