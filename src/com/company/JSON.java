package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JSON {

    public ArrayList<Reactors> JSON(String s) throws FileNotFoundException, IOException, ParseException {
        ArrayList<Reactors> reactorsList = new ArrayList<>();

        FileReader reader = new FileReader(s);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

        for (Object obj : jsonArray) {
            JSONObject pars = (JSONObject) obj;
            reactorsList.add(new Reactors((String) pars.get("classs"), (Double) pars.get("burnup"), (Double) pars.get("kpd"),
                    (Double) pars.get("enrichment"), (Double) pars.get("termal_capacity"), (Double) pars.get("electrical_capacity"),
                    (Double) pars.get("life_time"), (Double) pars.get("first_load"),"JSON"));
        }

        return reactorsList;
    }
}
