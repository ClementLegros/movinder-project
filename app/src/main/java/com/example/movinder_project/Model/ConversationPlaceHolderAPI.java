package com.example.movinder_project.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConversationPlaceHolderAPI {
    @GET("/conversation/{idUtilisateur}")
    Call<List<Conversation>> getsConversation(@Path(value = "idUtilisateur", encoded = false)int idUtilisateur);

    @GET("/conversation/{idUtilisateur/{idConversation}")
    Call<List<Utilisateur>> getsConversationUtilisateur(@Path(value = "idUtilisateur", encoded = false)int idUtilisateur, @Path(value = "idConversation", encoded = false)int idConversation);

    @GET("message/conversation/{idConversation}")
    Call<List<Message>> getMessage(@Path(value = "idConversation", encoded = false)int idConversation);




}
