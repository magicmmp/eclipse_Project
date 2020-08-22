package test;

import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Random;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Test {

	public static void main(String[] args) {

		LinkedHashMap<String, String> users = new LinkedHashMap<>();
		int page = 1;
		while (page < 100) {
			String url = "https://api.bilibili.com/x/v2/reply?callback=jQuery17205107188126300766_1576653500266&jsonp=jsonp&pn=" + page + "&type=1&oid=79335874&sort=2&_=1576653505885";
			try {
				URLConnection connection = new URL(url).openConnection();
				connection.setRequestProperty("Accept", "*/*");
				connection.setRequestProperty("Cookie", "_uuid=4B94303B-E114-CD8C-C689-A6B0F57F7CBE15873infoc; buvid3=0E06D678-1290-4F3D-B307-4836003C8046190949infoc; LIVE_BUVID=AUTO6815717319189047; sid=inmcdjak; DedeUserID=264295238; DedeUserID__ckMd5=8b0fbeb7f0e1c7ec; SESSDATA=0cee3777%2C1577862064%2C9675f4c1; bili_jct=ffc68e28848de38225533ef891566256; rpdid=|(umYmuYJJY|0J'ul~lk~Jl)); finger=7360d3c2; CURRENT_QUALITY=64; INTVER=1; im_notify_type_264295238=0; bp_t_offset_264295238=334131391726653600; laboratory=1-1; bsource=seo_baidu; CURRENT_FNVAL=16; stardustvideo=1");
				connection.setRequestProperty("Host", "api.bilibili.com");
				connection.setRequestProperty("Referer", "https://www.bilibili.com/video/av79335874/");
				String result = IOUtils.toString(connection.getInputStream(), "utf-8");
//				System.out.println(result);
				result = result.substring(result.indexOf("(") + 1, result.lastIndexOf(")"));
//				System.out.println(result);
				JsonObject object = new JsonParser().parse(result).getAsJsonObject();
//				System.out.println(object.toString());
				if (object.get("data").getAsJsonObject().get("replies").toString().equals("null")) {
					break;
				}
//				System.out.println(object.get("data").getAsJsonObject().get("replies"));
				JsonArray array = object.get("data").getAsJsonObject().get("replies").getAsJsonArray();
//				System.out.println(array.toString());
				for (int i = 0; i < array.size(); i++) {
					JsonObject tmp = array.get(i).getAsJsonObject();
//					System.out.println(tmp);
					JsonObject tmp2 = tmp.get("member").getAsJsonObject();
//					System.out.println(tmp);
					users.put(tmp2.get("mid").getAsString(), tmp2.get("uname").getAsString());
				}

				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			page++;
		}
		for (String mid : users.keySet()) {
			System.out.println(mid + ":" + users.get(mid));
		}
		System.out.println("参与抽奖人数:" + users.size());
		Random random = new Random();
		int a = random.nextInt(users.size());
		int b = random.nextInt(users.size());
		while(b==a) {
			b = random.nextInt(users.size());
		}
		int num = 0;
		for (String mid : users.keySet()) {
			if (num == a || num == b) {
				System.out.println("中奖用户:" + mid + ":" + users.get(mid));
			}
			num++;
		}
	}

}
