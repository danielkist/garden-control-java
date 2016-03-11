package in.k2s.raspberry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

public class MainTest {
	
	public static void main(String[] args) {
//		String link = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%3D455861&format=json&diagnostics=true&callback=";
//		String json = new HttpUtil().doGet(link);
//		YahooWeather bean = YahooWeatherParser.parse(json);
//        System.out.println(new GsonBuilder().create().toJson(bean));
		
		System.out.println(parseTime("Tue, 09 Feb 2016 2:01 pm BRST"));
	}
	
	private static LocalTime parseTime(String date) {
		LocalTime t = null;
		int index = date.indexOf(":");
		if(index > 0) {
			Integer hour   = new Integer(date.substring(index - 2, index).trim());
			Integer minute = new Integer(date.substring(index + 1, index + 3));
			if(date.toLowerCase().contains("pm")) hour = hour + 12;
			t = LocalTime.of(hour, minute);
		}
		return t;
	}

}
