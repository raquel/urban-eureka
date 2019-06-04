package com.serverless.handlers;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.serverless.domain.Unidade;
import com.serverless.rds.HibernateUtil;
import com.serverless.request.UnidadeDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.*;


public class UnidadeHandler3 implements RequestStreamHandler {

    private static Gson gson = new Gson();

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
        UnidadeDTO dto = gson.fromJson(reader, UnidadeDTO.class);

        LambdaLogger logger = context.getLogger();

        logger.log("Received id " + dto.getId());
        Transaction transaction = null;
        Unidade unidade = new Unidade();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.beginTransaction();
            unidade = session.load(Unidade.class, dto.getId());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        //Pode-se parsear unidade (que é entidade) para o DTO novamente antes de montar o OutputStream
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        writer.write(gson.toJson(unidade, Unidade.class));
        writer.flush();
    }
}
