package xin.chunming.moneymanager.Controller.vpn;

import jakarta.servlet.http.HttpSession;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.aspectj.weaver.ast.Call;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.chunming.moneymanager.Service.vpn.file;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.function.BiConsumer;

@Controller
public class config {

    @Autowired
    public file vpnservice;

    @RequestMapping(value = "/vpn", produces = "application/json")
    @ResponseBody
    public String now(String url) throws NoSuchAlgorithmException, KeyManagementException, IOException, URISyntaxException {
        vpnservice.config(url);
        return "{\"code\":\"200\"}";

    }
}
