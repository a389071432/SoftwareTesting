package com.sse.software_testing.model;

/**
 * @author hq
 */
public class Result {
    private String realOutput;
    private String result;
    public String getRealOutput() {
        return realOutput;
    }
    public void setRealOutput(String name) {
        this.realOutput = name;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String pass) {
        this.result = pass;
    }
}
