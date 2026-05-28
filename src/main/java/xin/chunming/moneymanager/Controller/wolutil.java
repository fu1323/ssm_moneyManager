package xin.chunming.moneymanager.Controller;

import java.io.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wol")
public class wolutil {

    static String mac = "18:4a:53:08:ff:46";
    @GetMapping
    @ResponseBody
    public String wake(@RequestParam(name = "wake",required = false) Integer num) {

        try{
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("wakeonlan", mac);
        Process process = processBuilder.start();

        // 读取标准输出
        String output = readStream(process.getInputStream());
        System.out.println(output);

        // 读取错误输出
        String error = readStream(process.getErrorStream());
        if (!error.isEmpty()) {
            System.err.println("Error:\n" + error);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"code\":\"200\"}";
    }

    private static String readStream(InputStream inputStream) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                result.append(line);


            }
        }
        return result.toString();
    }
}


