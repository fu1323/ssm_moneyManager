package xin.chunming.moneymanager.Service.vpn;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xin.chunming.moneymanager.Controller.vpn.config;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.UUID;
@Service
public class file {

    @Value("${vpn.savepath}")
    public String basepath;

    public void config(String url) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        String filename = UUID.randomUUID().toString().replace("-", "");
        File file = new File(basepath + File.separator + filename);


        download(url, file);

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line+"\n");
        }
        bufferedReader.close();
        String conf = stringBuilder.toString();
        conf=conf.replace("dev tun", "dev tun78");
       conf= conf.replace("\nclient\n", "\nclient\nroute-nopull\n");
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(file + ".ovpn"));
        bufferedWriter1.write(conf);
        bufferedWriter1.flush();
        bufferedWriter1.close();


        ProcessBuilder pb = new ProcessBuilder(
                "/bin/bash",
                basepath + File.separator + "run.sh",
                basepath + File.separator + filename + ".ovpn"     // 对应 $1// 对应 $2
        );
        pb.start();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(basepath + File.separator + "conf"));
        bufferedWriter.write(basepath + File.separator + filename + ".ovpn");
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    public static void download(String url, File saveFile) throws
            NoSuchAlgorithmException, KeyManagementException, IOException {

        // 1. 创建信任所有证书的 TrustManager
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }
                }
        };

        // 2. 初始化 SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

        // 3. 构建 OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0])
                .hostnameVerifier((hostname, session) -> true) // 总是返回 true 表示接受所有域名
                .build();

        System.out.println("下载" + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        // 同步执行请求
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // 使用 try-with-resources 自动关闭流
            try (InputStream is = response.body().byteStream();
                 FileOutputStream fos = new FileOutputStream(saveFile)) {

                byte[] buffer = new byte[8192]; // 8KB 缓冲区
                int len;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fos.flush();
                System.out.println("下载完成！");
            }
        }
    }


}
