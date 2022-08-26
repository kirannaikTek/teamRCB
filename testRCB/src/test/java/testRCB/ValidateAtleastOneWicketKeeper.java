package testRCB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ValidateAtleastOneWicketKeeper {

	static String requestBody = null;
	static int wicketKeeperCount = 0;

	@Test
	public void verifyAtlestOneWicketKeeper() {

		try {
			requestBody = new String(Files.readAllBytes(Paths.get("payload/TeamRCB.json")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject root = new JSONObject(requestBody);
		JSONArray rootArray = root.getJSONArray("player");
		for (int i = 0; i < rootArray.length(); i++) {
			JSONObject arrayIndex = rootArray.getJSONObject(i);
			String strRole = (String) arrayIndex.get("role");
			if (strRole.equalsIgnoreCase("Wicket-keeper")) {
				wicketKeeperCount++;
			}
		}
		boolean blnWicketKeeper = false;
		if (wicketKeeperCount > 0) {
			blnWicketKeeper = true;
		}
		Assert.assertTrue(blnWicketKeeper);

	}
}
