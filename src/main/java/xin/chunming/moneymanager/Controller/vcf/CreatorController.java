package xin.chunming.moneymanager.Controller.vcf;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import xin.chunming.moneymanager.tools.vcf.numshit;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

@Controller

public class CreatorController {

    @RequestMapping(value = "/vcf")
    public ResponseEntity create(@RequestParam(name = "num",required = false) Integer num) throws IOException {
        if (num == null||num<0||num>400000) {
            return ResponseEntity.status(301).location(URI.create("https://www.baidu.com/s?wd=sb")).build();

        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"out.vcf\"");
            headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
            headers.add(HttpHeaders.PRAGMA, "no-cache");
            headers.add(HttpHeaders.EXPIRES, "0");
            String property = System.getProperty("user.home");
            File file = new File(property + "/" + "out" + ".vcf");
            if (file.exists()) {
                file.delete();
            }
            numshit numshit = new numshit(num);
            FileUrlResource fileUrlResource = new FileUrlResource(numshit.getFile().getAbsolutePath());
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(fileUrlResource.contentLength())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(fileUrlResource);


        }
    }
}
