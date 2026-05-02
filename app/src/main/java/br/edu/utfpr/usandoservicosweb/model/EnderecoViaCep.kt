package br.edu.utfpr.usandoservicosweb.model

data class EnderecoViaCep(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val unidade: String,
    val ibge: String,
    val gia: String,
    val ddd: String,
    val siafi: String,
    val erro: Boolean
)
