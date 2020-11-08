package id.ac.itn.gibolapps.api;

import id.ac.itn.gibolapps.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient mInstannce;
    private Retrofit retrofit;

    private ApiClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BaseURL).addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiClient getInstance(){
        if(mInstannce==null){
            mInstannce=new ApiClient();
        }
        return mInstannce;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
