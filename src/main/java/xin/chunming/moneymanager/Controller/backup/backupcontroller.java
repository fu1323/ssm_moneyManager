package xin.chunming.moneymanager.Controller.backup;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xin.chunming.moneymanager.pojo.monthyear;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class backupcontroller {
    private static final Object obj = new Object();

    @RequestMapping(value = "/backup", produces = "application/json",method = RequestMethod.GET)
    public ResponseEntity backup(HttpServletRequest hsr) throws IOException, InterruptedException {
        synchronized (obj) {
            String file = "/home/fuchunming/money.sql";
            File file1 = new File(file);
            if (file1.exists()) {
                file1.delete();
            }
            if (hsr.getRemoteAddr().startsWith("192.168") || hsr.getRemoteAddr().startsWith("127.0.0.1")
                    || hsr.getRemoteAddr().startsWith("172.16") || hsr.getRemoteAddr().startsWith("172.31") || hsr.getRemoteAddr().startsWith("10.1")||hsr.getRemoteAddr().equals("0:0:0:0:0:0:0:1")) {
                /*mysqldump -u [用户名] -p [数据库名] > [输出文件.sql]*/
                // 使用 ProcessBuilder
                ProcessBuilder processBuilder = new ProcessBuilder();
                processBuilder.command("sh", "/home/fuchunming/mysqlbak.sh");
                Process process = processBuilder.start();

                // 读取标准输出
                String output = readStream(process.getInputStream());
                System.out.println(output);

                // 读取错误输出
                String error = readStream(process.getErrorStream());
                if (!error.isEmpty()) {
                    System.err.println("Error:\n" + error);
                }


                // 等待命令完成
                int exitCode = process.waitFor();

                FileUrlResource fileUrlResource = new FileUrlResource(file);
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=");
                headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
                headers.add(HttpHeaders.PRAGMA, "no-cache");
                headers.add(HttpHeaders.EXPIRES, "0");
                if (exitCode == 0 && new File(file).exists()) {
                    return ResponseEntity.ok()
                            .headers(headers)
                            .contentLength(fileUrlResource.contentLength())
                            .contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(fileUrlResource);
                } else return (ResponseEntity) ResponseEntity.status(400).contentType(new MediaType("text","plain", StandardCharsets.UTF_8)).body(error+" 400 想找对象,没有?new 一个 "+hsr.getRemoteAddr());
            } else return (ResponseEntity) ResponseEntity.status(403).contentType(new MediaType("text","plain", StandardCharsets.UTF_8)).body("403 禁止访问, 想找对象,没有?new 一个"+hsr.getRemoteAddr());


        }
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
