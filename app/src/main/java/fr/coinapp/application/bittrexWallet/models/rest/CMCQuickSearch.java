package fr.coinapp.application.bittrexWallet.models.rest;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CMCQuickSearch {

    @JsonProperty("slug")
    private String slug;
    @JsonProperty("id")
    private int id = -1;

    public CMCQuickSearch (){
        super();
    }
    public String getSlug() {
        return slug;
    }

    public int getId() {
        return id;
    }
}
