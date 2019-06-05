package com.serverless.handlers;

import com.amazonaws.services.lambda.runtime.events.*;
import com.google.gson.Gson;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MainHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log(input.toString());

        String httpMethod= input.getHttpMethod();
        String resource = input.getResource();

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        if(httpMethod.toLowerCase().equals("get") && resource.toLowerCase().equals("/unidade/{id}"))
        {
            UnidadeHandler handler = new UnidadeHandler();
            response = handler.Get(input, logger);
        }
        else
        {
            response.setBody("Não existe este endpoint");
            response.setStatusCode(404);
        }
        
        return response;
    }
   
}

