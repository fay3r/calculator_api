/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.labab;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
/**
 * REST Web Service
 *
 * @author Patryk
 */
@Path("calc")
@RequestScoped
public class CalcResource {
    @Context
    private UriInfo context;

    /** Creates a new instance of CalcResource */
    public CalcResource() {
    }

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String add(@PathParam("a") double a,@PathParam("b") double b){
        return (a+b)+"";
    }

    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sub(@PathParam("a") double a,@PathParam("b") double b){
        return (a-b)+"";
    }

    @GET
    @Path("/mul/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String mul(@PathParam("a") double a,@PathParam("b") double b){
        return (a*b)+"";
    }

    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String div(@PathParam("a") double a,@PathParam("b") double b){
        return (a/b)+"";
    }

    @GET
    @Path("/sqrt/{a}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sqrt(@PathParam("a") double a,@PathParam("b") double b){
        if(a>0){
            return Math.sqrt(a)+"";
        } else {
            return "error";
        }
    }

    @GET
    @Path("/pow/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pow(@PathParam("a") double a,@PathParam("b") double b){
        return Math.pow(a,b)+"";
    }
}
