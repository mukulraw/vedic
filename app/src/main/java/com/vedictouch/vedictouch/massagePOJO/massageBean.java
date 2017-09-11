package com.vedictouch.vedictouch.massagePOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tvs on 9/11/2017.
 */

public class massageBean {

    @SerializedName("massage_api")
    @Expose
    private List<MassageApus> massageApi = null;

    public List<MassageApus> getMassageApi() {
        return massageApi;
    }

    public void setMassageApi(List<MassageApus> massageApi) {
        this.massageApi = massageApi;
    }
}
