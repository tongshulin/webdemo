package com.zerokong.webdemo.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import com.alibaba.fastjson.JSONArray;


public class JSONParsr {
	
	public String getWebHtml(){
		String result = "";
		String strUrl = "http://www.jointwisefund.cn/lhmjFundNew/mobileAction/accountList";
		URL url = null; 
		HttpURLConnection httpURLConn = null;
		try{
			url = new URL(strUrl);
			httpURLConn = (HttpURLConnection) url.openConnection();
			httpURLConn.setDoInput(true);
			httpURLConn.setDoOutput(true);
			httpURLConn.setUseCaches(false);
			httpURLConn.setRequestMethod("GET");
			//httpURLConn.connect();
			
			InputStream is = httpURLConn.getInputStream();
			if(httpURLConn.getResponseCode() ==HttpURLConnection.HTTP_OK){
				System.out.println("SB");
			}
			InputStreamReader isr =new InputStreamReader(is);
			BufferedReader bufferReader = new  BufferedReader(isr);
			String inputLine = "";
			while((inputLine = bufferReader.readLine())!=null){
				result +=inputLine ;
			}
			//result= httpURLConn.getContent().toString();
			System.out.println("========" + result);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
		return result;
	}
	
	
	public void parserJson(String parsrJsonString){
		if(null ==parsrJsonString || "".equals(parsrJsonString.trim())){
			System.out.println("JSON数据错误！");
			return ;
		}
		JSONArray jsonArray = JSONArray.parseArray(parsrJsonString);
		int arraySize = jsonArray.size();
		Map<String,String> resultMap = new HashMap<String,String>();
		for(int i =0;i<arraySize;i++){
			String account = jsonArray.getJSONObject(i).get("account").toString();
			resultMap.put(account,account);
		}
		int mapSize = resultMap.size();
		System.out.println(mapSize +"--" + arraySize);
		Set<String> resultSet = resultMap.keySet();
		Iterator<String > it = resultSet.iterator();
		StringBuffer sbResultAccounts = new StringBuffer("");
		while(it.hasNext()){
			sbResultAccounts.append(",'").append(it.next()).append("'");
		}
		String resultAccounts = new StringBuffer("(\''").append(sbResultAccounts.toString()).append(")").toString();
		System.out.println(resultAccounts);
	}
	public static void main(String[] args){
		//String parsrJsonString = "[{\"account\":\"8808919\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8800158\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808900\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808901\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808910\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808916\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808888\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808891\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808902\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808903\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808906\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808908\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808928\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808931\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808951\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808952\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808920\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808925\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808958\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808922\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808929\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808933\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808935\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808936\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808957\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808921\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808927\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808926\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808932\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808937\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808938\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808939\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808950\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808955\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808953\",\"id\":0,\"productId\":0,\"type\":0},{\"account\":\"8808956\",\"id\":0,\"productId\":0,\"type\":0}]";
		JSONParsr p = new JSONParsr();
		p.parserJson(p.getWebHtml());
	}
}
