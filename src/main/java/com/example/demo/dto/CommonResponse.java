package com.example.demo.dto;

public class CommonResponse {
    private String responseCode;
    private String responseMessage;

    public CommonResponse() {
        this.responseCode =  "00";
        this.responseMessage = "SUCCESS";
    }

    public CommonResponse(String responseMessage) {
        this.responseCode =  "00";
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
