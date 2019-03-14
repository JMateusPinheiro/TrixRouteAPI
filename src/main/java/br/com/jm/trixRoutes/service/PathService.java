package br.com.jm.trixRoutes.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.internal.PolylineEncoding;
import com.google.maps.model.LatLng;

import br.com.jm.trixRoutes.repository.RouteRepository;


@Service
public class PathService {
	@Value("${APIkey}")
	private String APIKey;
	
	@Autowired
	private RouteRepository routeRepository;
	
	public String getPath(String origin, String destination, String waypoints) {
		
		try {
			URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?" + 
					"origin=" + origin + 
					"&destination=" + destination + 
					"&waypoints=" + waypoints + 
					"&key=" + APIKey);
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
					
			JSONObject jobj = new JSONObject(content.toString());
			JSONArray rt = jobj.getJSONArray("routes");
			JSONObject b = rt.getJSONObject(0);
			JSONObject opl = b.getJSONObject("overview_polyline");
			String pl = opl.getString("points");
			List<LatLng> pol = PolylineEncoding.decode(pl);
			List<String> polylines = new ArrayList<>();
			for(LatLng polyline:pol) {
				polylines.add("["+polyline.toString()+"]");
			}
			return polylines.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

}
