package me.jimmy.hellospring.controller;

public class ApiResponse<T> {
    private ApiResult result;
    private T data;
    private Exception error;

    public ApiResponse(ApiResult result, T data) {
        this.result = result;
        this.data = data;
        this.error = null;
    }

    public ApiResponse(ApiResult result, Exception error) {
        this.result = result;
        this.error = error;
    }

    static <T> ApiResponse<T> success(T data) {
        return new  ApiResponse(ApiResult.SUCCESS, data);
    }

    static <T> ApiResponse error(Exception error) {
        return new  ApiResponse(ApiResult.SUCCESS, error);
    }

    private enum ApiResult {
        SUCCESS, ERROR
    }
}
