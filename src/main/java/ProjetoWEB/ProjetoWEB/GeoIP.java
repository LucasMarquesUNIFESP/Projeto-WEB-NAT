package ProjetoWEB;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeoIP {
	private String ip;
	private String pais;
	private String estado;
	private String ispCliente;
	private String cidadeIsp;
	private Boolean isError;
	
	public GeoIP() {
		isError = true;
	}

	public GeoIP(String ip) {
		// TODO Auto-generated constructor stub
		this.ip = ip;
		String apiKey = "944a3714d0d04330a12cf8244653c222";
		
		try {
            URL url = new URL("https://api.ipgeolocation.io/ipgeo?ip="+ip+"&apiKey="+apiKey);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != 200)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader reader = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            this.pais = jsonObject.getString("country_name");
            this.estado = jsonObject.getString("state_prov");
            this.ispCliente = jsonObject.getString("isp");
            this.cidadeIsp= jsonObject.getString("city");
            this.isError = false;
            
            
        } catch (Exception e) {
            isError = true;
            
            this.pais = "";
            this.estado = "";
            this.ispCliente = "";
            this.cidadeIsp= "";
        }
    }

	
	public String getIp() {
		return ip;
	}

	public String getPais() {
		return pais;
	}

	public String getEstado() {
		return estado;
	}

	public String getIspCliente() {
		return ispCliente;
	}

	public String getCidadeIsp() {
		return cidadeIsp;
	}

	public Boolean getIsError() {
		return isError;
	}
}
