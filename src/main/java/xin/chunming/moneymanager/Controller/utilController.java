package xin.chunming.moneymanager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
@RequestMapping("/util")

public class utilController {
    @GetMapping
    @ResponseBody
    public String openSplashtop(){
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("open", "/Applications/Splashtop Streamer.app");

            // 重定向错误流到标准输出
            builder.redirectErrorStream(true);

            Process process = builder.start();

            // 读取输出
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {

                reader.lines().forEach(System.out::println);
            }

            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);
            if (exitCode != 0) {
                System.out.println("打开Splashtop");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "{\"code\":\"200\"}";
    }

}
