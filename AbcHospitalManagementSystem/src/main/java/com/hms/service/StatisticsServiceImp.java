/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.hms.dao.StatisticUtils;
import com.hms.objects.Statistics;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author User
 */
@Path("/statistics-json")
public class StatisticsServiceImp {
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatistics() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(StatisticUtils.getStatistics());
    }
    Statistics convertJsonToStat(String json) {
        return new Gson().fromJson(json, Statistics.class);
    }
}