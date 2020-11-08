package id.ac.itn.gibolapps.api;

import id.ac.itn.gibolapps.model.MatchDetailsMD;
import id.ac.itn.gibolapps.model.MatchesList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("competitions/{comp_id}/matches")
    Call<MatchesList> getScheduledMatchesList(@Path("comp_id") String comp_id, @Query("status") String status, @Header("X-Auth-Token") String token);

    @GET("matches")
    Call<MatchesList> getMatchesList(@Query("competitions") String comp_id, @Header("X-Auth-Token") String token);

    @GET("matches/{match_id}")
    Call<MatchDetailsMD> getMatchesDetails(@Path("match_id") int match_id, @Header("X-Auth-Token") String token);
}
