package br.edu.utfpr.usandoservicosweb

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.usandoservicosweb.api.RetrofitClient
import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE

class MainActivity : AppCompatActivity() {

    private lateinit var etNumero: EditText
    private lateinit var tvResultado: TextView

    private val NAMESPACE = "http://www.dataaccess.com/webservicesserver/"
    private val URL = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso"
    private val METHOD_NAME = "NumberToWords"
    private val SOAP_ACTION = "${NAMESPACE}${METHOD_NAME}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etNumero = findViewById(R.id.etNumero)
        tvResultado = findViewById(R.id.tvResultado)
    }

    fun btConverterOnClick(view: View) {

        Thread {

            try {

                val resposta = RetrofitClient.viaCepService.buscarCep(etNumero.text.toString()).execute()

                runOnUiThread {
                    tvResultado.text = resposta.body()?.logradouro
                }

            } catch (e: Exception) {
                runOnUiThread {
                    tvResultado.text = e.message
                }
            }
        }.start()
    }
}