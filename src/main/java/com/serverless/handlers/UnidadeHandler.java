package com.serverless.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.serverless.domain.TipoUnidade;
import com.serverless.domain.Unidade;
import com.serverless.rds.HibernateUtil;
import com.serverless.request.UnidadeDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UnidadeHandler {

    public Unidade post(UnidadeDTO unidadeDTO, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log(unidadeDTO.toString());
        Transaction transaction = null;
        Unidade unidade = new Unidade();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            unidade = session.byId(Unidade.class).getReference(unidadeDTO.getId());
            unidade.setId(unidadeDTO.getId());
            unidade.setName(unidadeDTO.getName());
            unidade.setType(TipoUnidade.UNIT_OPERATIONAL);
            session.save(unidade);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return unidade;
    }

    public Unidade delete(UnidadeDTO id, Context context) {
        LambdaLogger logger = context.getLogger();
        Transaction transaction = null;
        Unidade unidade = new Unidade();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            unidade = session.byId(Unidade.class).getReference(id.getId());
            session.delete(unidade);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return unidade;
    }

    public Unidade get(UnidadeDTO id, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Received id " + id.getId());
        Transaction transaction = null;
        Unidade unidade = new Unidade();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            unidade = session.byId(Unidade.class).getReference(id.getId());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

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
    }
}

