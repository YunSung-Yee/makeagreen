package img.crawling.controller;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Crawl {
    private static final Scanner sc = new Scanner(System.in);

    public void downloadImg(){

        System.out.println("상품코드를 입력하세요");
        String pdArr[] = sc.nextLine().split(",");
        String path = "C:\\img\\";

        for(String ptcode : pdArr){
            String url = "https://m.celectory.com/mobile/product/" + ptcode;

            Document doc = null;
            Connection.Response response = null;

            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            doc.html();

            Elements el = doc.select(".ImgBox a img");
            String imgUrl = el.attr("src");
            imgUrl = "https:" + imgUrl;

            Connection conn = Jsoup.connect(imgUrl).ignoreContentType(true);
            try {
                response = conn.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File saveFile = null;
            FileOutputStream fos = null;

            saveFile = new File(path);
            if(!saveFile.exists() || !saveFile.isDirectory()){
                saveFile.mkdir();
            }

            saveFile = new File(path,ptcode+".jpg");

            try {
                fos = new FileOutputStream(saveFile);
                fos.write(response.bodyAsBytes());
                fos.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
