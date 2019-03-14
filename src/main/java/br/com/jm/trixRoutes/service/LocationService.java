package br.com.jm.trixRoutes.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jm.trixRoutes.model.Stop;

@Service
public class LocationService {
	
	@Value("${APIkey}")
	private String APIkey;

	public String getLocation(String location) {
		
		try {
			URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?" +
					"address=" + location +
					"&key=" + APIkey);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
			    content.append(inputLine);
			}
			in.close();
			con.disconnect();
			
			ObjectMapper mapper = new ObjectMapper();
			
			JSONObject jobj = new JSONObject(content.toString());
			JSONArray rst = jobj.getJSONArray("results");
			JSONObject obj = rst.getJSONObject(0);
			JSONObject geo = obj.getJSONObject("geometry");
			JSONObject loc = geo.getJSONObject("location");
			String name = obj.getString("formatted_address");
			Stop stop = new Stop();
			stop.setName(name);
			stop.getCoords().setLat(loc.getDouble("lat"));
			stop.getCoords().setLng(loc.getDouble("lng"));
			
			return mapper.writeValueAsString(stop);
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
