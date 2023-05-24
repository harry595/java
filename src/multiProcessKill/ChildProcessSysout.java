package multiProcessKill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChildProcessSysout {
    public static void main(String[] args) {
        while (true) {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "ChildProcess");
            try {
                Process process = processBuilder.start();

                // 자식 프로세스의 출력을 읽어올 BufferedReader
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // 자식 프로세스가 종료되기를 대기
                int exitCode = process.waitFor();
                System.out.println("Child process exited with code: " + exitCode);

                // 자식 프로세스가 종료되면 재실행
                System.out.println("reStart");

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
