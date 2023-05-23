package FileIO;

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
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class fileInput {
	

    public static void readJsonFile() {

        String filePath = "./person.json"; // 읽고자 하는 JSON 파일의 경로와 이름을 지정하세요.

        Gson gson = new Gson();
        Person person = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            person = gson.fromJson(reader, Person.class);
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        }

        if (person != null) {
            System.out.println("이름: " + person.getName());
            System.out.println("나이: " + person.getAge());
        }
        
    }
    
    
	// 파일 읽기 METHOD
	public static List<String> readFileLines() {

        String filePath = "./input.txt"; // 읽고자 하는 파일의 경로와 이름을 지정하세요.
        List<String> fileDatas = new ArrayList<>();
        Map<String,String> fileSplit = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
            	
                fileDatas.add(line);
                String[] splitedLine = line.split(" ");
                fileSplit.put(splitedLine[0], splitedLine[1]);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(fileSplit);
        return fileDatas;
        
	}
	
	// 파일 쓰기 METHOD
	public static void writeFileLines(List<String> fileDatas) {

        String filePath = "./input.txt"; // 쓰고자 하는 파일의 경로와 이름을 지정하세요.

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : fileDatas) {
                bw.write(line);
                bw.newLine(); // 다음 줄로 넘어가기 위해 개행 문자를 쓰세요.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	

	public static void main(String[] args) {
		List<String> readTextFile = readFileLines();
//		writeFileLines(readTextFile);
//		readJsonFile();
	}
	
}
