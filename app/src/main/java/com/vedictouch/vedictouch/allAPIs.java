package com.vedictouch.vedictouch;

import com.vedictouch.vedictouch.massagePOJO.massageBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by tvs on 9/11/2017.
 */

public interface allAPIs{

    @Multipart
    @POST("newtbx/vedic_touch/app-api/massage_api.php")
    Call<massageBean> getMassages(@Part("id") String id);

    /*@GET("Service.svc/GetTrackingDJSONP/")
    Call<List<trackBean>> track(
            @Query("docno") String docno
    );*/

}
