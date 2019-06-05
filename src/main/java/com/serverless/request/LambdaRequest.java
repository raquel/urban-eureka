package com.serverless.request;
import java.util.Map;

public class LambdaRequest
{
    public Map<String,String> stageVariables;
    public Map<String,String> path;
    public Map<String,String> querystring;
    public Map<String,String> header;
    public Map<String,String> context;
}