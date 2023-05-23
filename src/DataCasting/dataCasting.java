package DataCasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class dataCasting {

    public static JsonObject stringToJson(String jsonString) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonData = jsonParser.parse(jsonString).getAsJsonObject();
        String name = jsonData.get("name").getAsString();
        int age = jsonData.get("age").getAsInt();
        
        return jsonData;
    }

    public static String jsonToString(JsonObject json) {
        Gson gson = new Gson();
        return gson.toJson(json);
    }

    public static Person stringToPojo(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Person.class);
    }

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John\",\"age\":30}";

        // String을 JSON으로 변환
        JsonObject json = stringToJson(jsonString);
        System.out.println("String to JSON:");
        System.out.println(json);

        // JSON을 String으로 변환
        String str = jsonToString(json);
        System.out.println("JSON to String:");
        System.out.println(str);

        // String을 JsonObject로 변환
        Person person = stringToPojo(jsonString);
        System.out.println("String to POJO:");
        System.out.println(person.getName());
    }
}
