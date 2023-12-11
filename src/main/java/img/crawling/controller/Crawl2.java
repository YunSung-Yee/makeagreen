package img.crawling.controller;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Crawl2 {
    private static final Scanner sc = new Scanner(System.in);

    public boolean downloadImg() {

        System.out.println("상품코드를 입력하세요");
        String pdArr[] = {"202311/goods_1700553775338.png","202311/goods_1700553732712.png","202311/goods_1700553678138.png","202311/goods_1700553416883.png","202311/goods_1700553635919.png","202311/goods_1700618891883.png","202311/goods_1700724726348.jpg","202311/goods_1700724792326.jpg","202311/goods_1700724856842.jpg","202311/goods_1700724903238.jpg","202311/goods_1701050305575.png","202311/goods_1701050253422.png","202311/goods_1701050203335.png","202311/goods_1701050127510.png","202311/goods_1701052489846.png","202311/goods_1701052520648.png","202311/goods_1700195973295.png","202311/goods_1700195955972.png","202311/goods_1701146779936.png","202311/goods_1701146824602.png","202311/goods_1701140505777.png","202311/goods_1701140587157.png","202311/goods_1701140642992.png","202311/goods_1701140193581.png","202311/goods_1701140700668.png","202311/goods_1701140757793.png","202311/goods_1701140837022.png","202311/goods_1701146688432.png","202311/goods_1701147030505.png","202311/goods_1701140946907.png","202311/goods_1701141056406.png","202311/goods_1701146742922.png","202311/goods_1701141113904.png","202311/goods_1701141006287.png","202311/goods_1701146688432.png","202311/goods_1701140946907.png","202311/goods_1700617774004.png","202311/goods_1700617895241.png","202311/goods_1700617966487.png","202311/goods_1700618018166.png","202311/goods_1700618091603.png","202311/goods_1700618167988.png","202311/goods_1700618232408.png","202311/goods_1700618299952.png","202311/goods_1700618935656.png","202311/goods_1700618587158.png","202311/goods_1700618629643.png","202311/goods_1700618687219.png","202311/goods_1700618741443.png","202311/goods_1700618804487.png","202311/goods_1700618993066.png","202311/goods_1700619042902.png","202311/goods_1700638512551.jpg","202311/goods_1700638708743.jpg","202311/goods_1700638895704.jpg","202311/goods_1700638790074.jpg","202311/goods_1700195929592.png","202311/goods_1700639146853.jpg","202311/goods_1700639206633.jpg","202311/goods_1700639036820.jpg","202311/goods_1700639325946.jpg","202311/goods_1700639263165.jpg","202311/goods_1700640353706.png","202311/goods_1700640386048.jpg","202311/goods_1700641421994.jpg","202311/goods_1700641374025.jpg","202311/goods_1700641221496.jpg","202311/goods_1700639822886.jpg","202311/goods_1700639860345.jpg","202311/goods_1700639506543.jpg","202311/goods_1700639597592.jpg","202311/goods_1700639932557.jpg","202311/goods_1700640000102.jpg","202311/goods_1700640081250.jpg","202311/goods_1700640129379.jpg","202311/goods_1700640675710.png","202311/goods_1700640744041.png","202311/goods_1700641151952.jpg","202311/goods_1700640975882.jpg","202311/goods_1700641093589.jpg","202311/goods_1700201869095.jpg","202311/goods_1700202135203.jpg","202311/goods_1700202227327.jpg","202311/goods_1700202372444.jpg","202311/goods_1700202425341.jpg","202311/goods_1700640929333.png","202311/goods_1700641050624.jpg","202311/goods_1700641012715.jpg","20230516/7ef99c63a83147cc9669c6913b38f351.png","20230516/996479838dfc42519a60c673d5215c06.png"};
        String path = "/Users/yslee/Downloads/img";
        //String path = "C:\\img\\";
        int cnt = 1;
        String goodsCode [] = {"HC23220774","HC23220773","HC23220772","HC23220770","HC23220771","HC23220788","HC23220838","HC23220839","HC23220840","HC23220841","PT23203117","PT23203116","PT23203115","PT23203114","PT23210953","PT23210954","HC23220759","HC23220758","HC23220879","HC23220880","HC23220881","HC23220882","HC23220883","HC23220876","HC23220884","HC23220885","HC23220886","HC23220887","HC23220877","HC23220888","HC23220890","HC23220878","HC23220891","HC23220889","HC23220887","HC23220888","HC23220775","HC23220776","HC23220777","HC23220778","HC23220779","HC23220780","HC23220781","HC23220782","HC23220789","HC23220783","HC23220784","HC23220785","HC23220786","HC23220787","HC23220790","HC23220791","HC23220800","HC23220801","HC23220803","HC23220802","HC23220757","HC23220805","HC23220806","HC23220804","HC23220808","HC23220807","HC23220817","HC23220818","HC23220834","HC23220833","HC23220832","HC23220812","HC23220809","HC23220810","HC23220811","HC23220813","HC23220814","HC23220815","HC23220816","HC23220823","HC23220824","HC23220831","HC23220827","HC23220830","HC23220761","HC23220762","HC23220763","HC23220764","HC23220765","HC23220826","HC23220829","HC23220828","PT22190739","PT22176407"};

        for (int i=0;i<pdArr.length;i++) {
            String ptCode = goodsCode[i];
            String url = pdArr[i];

            Connection.Response response = null;

            try {
                String imgUrl = "https://front.happypointcard.com/hc/static/images/goods/"+url;

                Connection conn = Jsoup.connect(imgUrl).ignoreContentType(true);
                response = conn.execute();

                File saveFile = null;
                FileOutputStream fos = null;

                saveFile = new File(path);
                if (!saveFile.exists() || !saveFile.isDirectory()) {
                    saveFile.mkdir();
                }

                saveFile = new File(path,ptCode + ".jpg");

                fos = new FileOutputStream(saveFile);
                fos.write(response.bodyAsBytes());
                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            cnt++;
        }

        return true;
    }
}