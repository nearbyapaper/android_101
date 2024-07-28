package com.example.neardroid.api;

public class ServerErrorException extends RuntimeException {
    private ErrorCollection error;
    private int code;

    public ServerErrorException(int code, ErrorCollection error) {
        super(String.format("Server error http status:%s codeType:%s code:%s desc:%s",
                code, error.getCodeType(), error.getStatusCode(), error.getDescription()));
        this.code = code;
        this.error = error;
    }

    public ErrorCollection error() {
        return error;
    }

    public int code() {
        return code;
    }
}

