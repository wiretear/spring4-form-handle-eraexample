package com.mkyong.form.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataStore {
	private List<String> databases;
    private List<String> lt;

    public DataStore() {

        String data = "Steve Jobs, Bill Gates, Dell, Larry Ellision, Lary Page, Sergy Brin";

        databases = new ArrayList<String>();
        StringTokenizer token = new StringTokenizer(data, ",");

        while(token.hasMoreTokens()) {
            databases.add(token.nextToken().trim());
        }

        String strTags = "Apple, Microsoft, Oracle, Google, Facebook, Twitter";
    lt = new ArrayList<String>();
        StringTokenizer token2 = new StringTokenizer(strTags, ",");

        while(token2.hasMoreTokens()) {
           lt.add(token2.nextToken().trim());
        }

    }

    public List<String> getdatabasesList(String query) {

        String database= null;
        query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for(int i=0; i < databases.size(); i++) {
            database = databases.get(i).toLowerCase();
            if(database.startsWith(query)) {
                matched.add(databases.get(i));
            }
        }
        return matched;
    }

}