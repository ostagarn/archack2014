package controllers;

import models.SndModel;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.mvc.Controller;

public class SndClient extends Controller {
	private static Logger logger = Logger.getLogger(SndClient.class);
	
	public static void index() {
		logger.info("Sndclient.index");
		render();
	}
	
	public static void search(String raanummer){
		logger.info("raanummer:" +raanummer);
		String sndws = "http://xml.snd.gu.se/ws/search.xql?type=study&format=json&id=" + raanummer;
		HttpResponse sndresp = WS.url(sndws).get();
		String link;
		int status = sndresp.getStatus();
		if(status == 200){ 
			
			String ss = sndresp.getJson().toString();
			if(ss.indexOf("\"StudyUnit\":{\"url\":\"") + 20 < ss.length()){
				String sub = ss.substring(ss.indexOf("\"StudyUnit\":{\"url\":\"")+20);
				link = sub.substring(0, sub.indexOf("\"") );
				renderArgs.put("sndurl", link);
			}
			
			
		}else{
			logger.info("fel:" +status);
		}
		render();
	}

}
