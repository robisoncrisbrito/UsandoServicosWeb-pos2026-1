package br.edu.utfpr.usandoservicosweb.api

import br.edu.utfpr.usandoservicosweb.model.EnderecoViaCep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {

    @GET("{cep}/json/")
    fun buscarCep(@Path("cep") cep: String): Call<EnderecoViaCep>

}