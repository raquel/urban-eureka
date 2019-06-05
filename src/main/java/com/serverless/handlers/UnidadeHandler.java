package com.serverless.handlers;

import com.amazonaws.services.lambda.runtime.events.*;
import com.google.gson.Gson;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.serverless.domain.Unidade;
import com.serverless.rds.HibernateUtil;
import com.serverless.request.UnidadeDTO;
import org.hibernate.Session;
import java.util.Map;


public class UnidadeHandler {

    private final Gson gson = new Gson();
    public APIGatewayProxyResponseEvent Get(APIGatewayProxyRequestEvent input, LambdaLogger logger) {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

        String id = null;
        Map<String, String> hps = input.getPathParameters();
        if (hps != null) {
            id = hps.get("id");
        }

        UnidadeDTO obj = new UnidadeDTO();
        obj.setId(Long.parseLong(id));

        logger.log("Received id " + obj.getId());
        Unidade unidade = new Unidade();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            unidade = session.byId(Unidade.class).getReference(obj.getId());
        } catch (Exception e) {
            response.setBody("MESSAGE: "+e.getMessage() + " STACKTRACE " + e.getStackTrace());
            response.setStatusCode(503);
            return response;
        }

<<<<<<< HEAD
        UnidadeDTO unidadeDto = new UnidadeDTO(unidade);
        response.setBody(gson.toJson(unidadeDto));
        response.setStatusCode(200);
        return response;
=======
        return unidade;
    }
    public Unidade put(UnidadeDTO unidadeDTO, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log(unidadeDTO.toString());
        Transaction transaction = null;
        Unidade unidade = new Unidade(); 

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            unidade.setName(unidadeDTO.getName());
            unidade.setType(TipoUnidade.UNIT_OPERATIONAL);
            unidade.setCity(unidadeDTO.getCity());
            unidade.setAddress(unidadeDTO.getAddress());
            unidade.setLatitude(unidadeDTO.getLatitude());
            unidade.setLongitude(unidadeDTO.getLongitude());
            unidade.setUrl(unidadeDTO.getUrl());
            unidade.setSescId(unidadeDTO.getSescId());
            unidade.setActive(true);
            unidade.setAvatar(unidadeDTO.getAvatar());

            session.save(unidade);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return unidade;
>>>>>>> da0b0e749b7b2b74bc44f54e9de21184f84a6a38
    }
   
}

