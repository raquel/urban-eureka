package com.serverless.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.domain.Unidade;
import com.serverless.rds.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Map;

public class UnidadeHandler2 implements RequestHandler<Map<String, Object>, Unidade> {

    @Override
    public Unidade handleRequest(Map<String, Object> stringObjectMap, Context context) {
        LambdaLogger logger = context.getLogger();

        Map<String, String> pathParameters = (Map<String, String>) stringObjectMap.get("pathParameters");
        String id = pathParameters.get("id");

        logger.log("Received id " + id);
        Transaction transaction = null;
        Unidade unidade = new Unidade();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.beginTransaction();
            unidade = session.load(Unidade.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return Unidade.builder().build();
        }

        return unidade;
    }
}
