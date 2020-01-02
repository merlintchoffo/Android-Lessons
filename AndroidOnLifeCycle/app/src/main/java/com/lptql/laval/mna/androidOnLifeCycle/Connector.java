package com.lptql.laval.mna.androidOnLifeCycle;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;


import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by guillaume on 24/03/2019.
 */

public interface Connector {

    public static final String ENDPOINT = "http://192.168.20.102/";

    //Tous les users
    @GET("backend/user.php")
    Call<String> getUsers(@Query("action") String action);

    @GET("/backend/user.php")
    Call<String> registerUser(@Query("nom") String nom,
                              @Query("prenom") String prenom,
                              @Query("tel") int telephone,
                              @Query("mail") String email,
                              @Query("ville") String ville,
                              @Query("mdp") String mdp,
                              @Query("type") String type,
                              @Query("action") String action);

    @GET("/backend/user.php")
    Call<String> countUsers(@Query("action") String action);

    @GET("/backend/child.php")
    Call<String> getChildByParent(@Query("action") String action,
                                  @Query("id_user") int id_user);

    @GET("/backend/child.php")
    Call<String> registerChild(@Query("prenom") String prenom,
                               @Query("age") int age,
                               @Query("id_user") int id_user,
                               @Query("action") String action);

    @GET("/backend/child.php")
    Call<String> getChildById(@Query("action") String action,
                              @Query("id") int id);

    @GET("/backend/liaison.php")
    Call<String> registerLiaison(@Query("id_enfant") int id_enfant,
                                 @Query("id_nounou") int id_nounou,
                                 @Query("statut") String statut,
                                 @Query("action") String action);

    @GET("/backend/liaison.php")
    Call<String> getLiaisons(@Query("action") String action,
                             @Query("id_nounou") int id);

    @GET("/backend/liaison.php")
    Call<String> getLiaisonByChild(@Query("action") String action,
                                   @Query("id_enfant") int id);

    @GET("/backend/liaison.php")
    Call<String> setLiaisonStatus(@Query("action") String action,
                                  @Query("statut") String statut,
                                  @Query("id") int id);

    @GET("/backend/liaison.php")
    Call<String> deleteLiaison(@Query("action") String action,
                               @Query("id") int id);

    @GET("/backend/user.php")
    Call<String> updateUserDispo(@Query("action") String action,
                                 @Query("id") int id,
                                 @Query("disponible") int dispo);

    @GET("/backend/horaire.php")
    Call<String> getHoraires(@Query("action") String action,
                             @Query("id_liaison") int id_liaison);

    @GET("/backend/horaire.php")
    Call<String> changeValideNounou(@Query("action") String action,
                                    @Query("id") int id_liaison,
                                    @Query("valide_nounou") int valN);
    @GET("/backend/horaire.php")
    Call<String> changeValideParent(@Query("action") String action,
                                    @Query("id") int id_liaison,
                                    @Query("valide_parent") int valN);

    @GET("/backend/horaire.php")
    Call<String> addHoraire(@Query("action") String action,
                            @Query("id_liaison") int id_liaison,
                            @Query("debut") String debut,
                            @Query("fin") String fin);

    @GET("/backend/horaire.php")
    Call<String> deleteHoraire(@Query("action") String action,
                               @Query("id") int id);

    @GET("/backend/child.php")
    Call<String> deleteChild(@Query("action") String action,
                             @Query("id") int id);


}
