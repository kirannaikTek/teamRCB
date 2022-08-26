package testRCB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ValidateFourForeignPlayers {

	static String requestBody = null;
	static int foreignPlayersCount = 0;
	@Test
	public void verifyFourForeignPlayers() {
		
		try {
			requestBody = new String(Files.readAllBytes(Paths.get("payload/TeamRCB.json")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject root = new JSONObject(requestBody);	
		JSONArray rootArray = root.getJSONArray("player");
		for(int i=0;i<rootArray.length();i++) {
			JSONObject arrayIndex = rootArray.getJSONObject(i);
			String countryName = (String) arrayIndex.get("country");
			System.out.println(countryName);
			if(!countryName.equalsIgnoreCase("India")) {
				foreignPlayersCount++;
			}
		}
		Assert.assertEquals(4, foreignPlayersCount);
		
	}
}
