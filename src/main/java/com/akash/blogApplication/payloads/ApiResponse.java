package com.akash.blogApplication.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ApiResponse {
    private String message;
    private boolean success;
    private long time;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
