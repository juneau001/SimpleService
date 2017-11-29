package org.simpleservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.simpleservice.entity.SuggestedName;

/**
 *
 * @author Juneau
 */
@Stateless
@Path("suggestedNameService")
public class SuggestedNameService {

    @PersistenceContext(unitName = "SimpleService_1.0PU")
    private EntityManager em;


    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public SuggestedName find(@PathParam("id") BigDecimal id) {
        SuggestedName suggestedName = null;
        try {
            suggestedName = (SuggestedName) 
                    em.createQuery("select object(o) from  SuggestedName o " +
                    "where o.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException ex){
            System.out.println("Error: "  + ex);
        }
        return suggestedName;
    }
   
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SuggestedName> findAll() {
        List<SuggestedName> suggestedNames = null;
        try {
            suggestedNames = em.createQuery("select object(o) from SuggestedName o")
                    .getResultList();
        } catch (NoResultException ex){
            System.out.println("Error: "  + ex);
        }
        return suggestedNames;
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
}
