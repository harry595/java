package DataCasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

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

    public static Person extractInTwoDepth(String jsonString) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        JsonObject testObject = jsonObject.getAsJsonObject("test");
        Person person = gson.fromJson(testObject, Person.class);
        return person;
    }
    
    public static List<Person> stringToPojoJsonList(String jsonString) {

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        JsonArray testArray = jsonObject.getAsJsonArray("test");

        List<Person> personList = new ArrayList<>();
        
        for (JsonElement element : testArray) {
            JsonObject testObject = element.getAsJsonObject();
            Person person = gson.fromJson(testObject, Person.class);

            personList.add(person);
        }
        
        return personList;
    }
    
    public static List<Person> stringToPojoJsonListByType(String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Person>>() {}.getType();
        List<Person> personList = gson.fromJson(jsonString, listType);

        return personList;
    }
    
    public static List<Person> stringToPojoJsonArray(String jsonString) {

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Person>>() {}.getType();
        List<Person> personList = gson.fromJson(jsonString, listType);
        
        return personList;
    }
    
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John\",\"age\":30}";
        String twoDepthJsonString = "{\"test\": {\"name\":\"John\",\"age\":30}}";
        String jsonListString = "{\"test\" : [{\"name\":\"jiun\", \"age\":27}, {\"name\":\"haeun\", \"age\":28}] }";
        String jsonArrayString = "[{\"name\":\"jiun\", \"age\":27}, {\"name\":\"haeun\", \"age\":28}]";
        
        // String을 JSON으로 변환
        JsonObject json = stringToJson(jsonString);
        System.out.println("String to JSON:");
        System.out.println(json);

        // JSON을 String으로 변환
        String str = jsonToString(json);
        System.out.println("JSON to String:");
        System.out.println(str);
        
        Person person = extractInTwoDepth(twoDepthJsonString);
        System.out.println(person.getName());
        
        // 좀 복잡한 데이터 일 경우
        List<Person> personList = stringToPojoJsonListByType(jsonArrayString);
        System.out.println(personList.get(0).getAge());

        personList = stringToPojoJsonArray(jsonArrayString);
        System.out.println(personList.get(0).getAge());
        

        personList = stringToPojoJsonList(jsonListString);
        System.out.println(personList.get(0).getAge());
        
        // String을 JsonObject로 변환
        person = stringToPojo(jsonString);
        System.out.println("String to POJO:");
        System.out.println(person.getName());
    }
}
