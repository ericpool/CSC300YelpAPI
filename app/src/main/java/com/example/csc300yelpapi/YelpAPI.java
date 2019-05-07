package com.example.csc300yelpapi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YelpAPI extends Thread
{
    @Override
    public void run()
    {
        try
        {
            URL businessEndpoint = new URL("https://api.yelp.com/v3/businesses/search?location=Mequon+WI&categories=restaurants");
            HttpURLConnection conn = (HttpURLConnection)businessEndpoint.openConnection();
            conn.setRequestProperty("Authorization", "Bearer _fudvZjjQRmQpuzZTXjRDPxJeLlYw8rGTsrzZNknmb_B7AA7ilLpaYgwHl-nM8UmgEKWI3rs7DPYseiuGzUmEybSLzLiGIiQVLFExouUcl-mKZQtHTymfnB1AgDJXHYx");
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
            System.out.println("*** DATA: " + data);

            //List<String> tempList = new ArrayList<>();
            JSONObject obj = new JSONObject(data);
            JSONArray businesses = obj.getJSONArray("businesses");
            for(int i = 0; i < businesses.length(); i++)
            {
                MainActivity.listVals.add(businesses.getJSONObject(i).getString("name"));
            }


        }
        catch(Exception e)
        {
            System.out.println("***.***" + e.toString());

        }

    }

}
