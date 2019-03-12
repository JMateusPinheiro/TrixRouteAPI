package br.com.jm.trixRoutes.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.maps.internal.PolylineEncoding;
import com.google.maps.model.LatLng;

import br.com.jm.trixRoutes.repository.RouteRepository;


@Service
public class RouteService {
	@Value("${APIkey}")
	private String APIKey;
	
	@Autowired
	private RouteRepository routeRepository;
	
	public String getRoute(String origin, String destination, String waypoints) throws IOException {
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
		
		List<LatLng> ways = PolylineEncoding.decode("ykpaG`{upL_Af@aA|@i@n@c@~@[v@USGESY{C{HoAeDgAuEUo@_@i@YMEXSb@oAzAcBvA_Ap@kE`EmGtGsCzCaKnLmCbDkAzAcBbCaBrCyAjCiBtDaBnDyDvJmAzCsBfE{BfDwCjDm@j@qB~AiE~CgCxAoCbAaAR{@LsAHaB@w@EaGm@cBKsBByANoATcCp@sB~@qAx@mB~Aq@p@yA`B}CfEyH~K_C~C}@`AkAlAeA|@aDnCuAnAgBnB}@lAcClD{B~C{DbGiIrLoFrHsClD_EbEaEnDwO|M{ChC}ClCqF|EcGlFc@@wAf@uBf@qADqBMkAGeAK{CMo@FoA`@e@\\\\cAfA]l@Yv@wCrN[`A]x@}BtDcHfLc@hA_@xAw@tDc@hBa@~@}AlCu@jDE\\\\St@}@nBg@lAS~@Kx@IjCa@hXOlLHrCFlCEtDJxB^xCPp@d@hAVd@Zf@\\\\ZNDVHTJJRTx@ZrA\\\\dAt@`BlApBzApBhAjAfB~AzAzAT`@f@r@FLJDLEDGZU`@Op@@xABx@EdDu@hAIxBF`B?ZEvBc@fB_@N@XAn@BZJh@\\\\p@h@h@v@PTn@dBlAhCjAhBn@p@rBdBbAj@v@VjAP|A?vII~@B~@Vt@f@dAjAz@z@~@t@fB~AbBhB`@r@\\\\z@Nh@PhAVlFHpALbAR|@`@fAd@x@~@lAvAdAZ\\\\`@dA\\\\nABh@@f@iAnFQ|@oCpMeAjFoH~]w@xCq@jBkB~EuBhFiB~DuCxFkAtBc@dAo@rBs@dD}CjPeBjJeApEgDfM_E`OeBfHeBnIgAfG_AhGa@jDqB|S[jC_AhGe@|BqGxWaAjD_CtHkDzKkAnEs@|C}DjToB`McAtJa@nGUhFe@r\\\\QtH]dHo@rIg@tE{@jGoAzGoApF_@pAaC|HaAbDw@bD{@rEa@pD_@zFO`HQtQi@de@Y~XWtP[lGm@tGY`Cu@vEgAvFaCpIaA`DyAbEqB`FeFhLkHfP}@pBgHlPsK`Ym@fBkBxE{C|HaBjFo@`CqArG{@`G{BxS}AjNeCjUe@lFeB`S}@zJmAhNm@bF}@~EkAtEmArDuAfDqIjQyFrLyAxDiCrHcLn\\\\}@pCsA~FaAnG_@jCeA|Ei@hBq@hB{CvHg@z@e@hAo@vB}@bE]jB}@hDyAbGm@hDY|BkA`LQ|B{ApR[lBu@nDsArHeA~Do@lBsAdDcInSwPhc@Uh@I`Am@nE_@`BYj@{CzE_BjEs@|Ag@P{@n@_CjBTx@~AcAr@e@d@i@");
		
		return content.toString();
	}

}
