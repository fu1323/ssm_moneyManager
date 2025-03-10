package xin.chunming.moneymanager.Controller.file;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import xin.chunming.moneymanager.pojo.login.user;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

@Controller
@RequestMapping("/file")
public class upload {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest hsr, HttpSession session, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
           hsr.setAttribute("message", "请选择要上传的文件！");
            return "/upload.jsp?a="+new Date().getTime();
        }

        try {
            String property = System.getProperty("user.home");
            user user = (user)session.getAttribute("user");
            // 指定存储路径（这里存到服务器本地）
            String uploadDir = property + File.separator + "upload"+File.separator;
            File file1 = new File(uploadDir + user.getName()+File.separator);
            if (!file1.exists()) {
                file1.mkdirs();

            }

            File dest = new File(uploadDir +user.getName()+File.separator+ new Date().getTime()+file.getOriginalFilename());

            // 保存文件
            file.transferTo(dest);

            hsr.setAttribute("message", "成功!"+file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            hsr.setAttribute("message", " 失败!");
        }

        return "/upload.jsp?a="+new Date().getTime();
    }
}