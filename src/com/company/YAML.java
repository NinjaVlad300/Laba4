package com.company;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class YAML {
   public ArrayList<Reactors> YAML(String  s) throws FileNotFoundException {

       ArrayList<Reactors> reactorsArrayList = new ArrayList<>();
       Reactors r = new Reactors();

       InputStream inputStream = new FileInputStream(new File(s));
       Yaml yaml = new Yaml(new Constructor(ReactorType_for_YAML.class));
       ReactorType_for_YAML data = (ReactorType_for_YAML) yaml.load(inputStream);
       reactorsArrayList.addAll(data.getReactorType());

       return reactorsArrayList;
   }

}

