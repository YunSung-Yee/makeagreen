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
        String pdArr[] = {"20230508/3eaee415c4324471852e9454c07fa4af.jpg","20230504/3aa3022c4ff3425a9e694f2feb7f8004.jpg","20230504/1f889498e74643afac6c91a567b046d0.jpg","20230504/c5d002ec6e884c648417604550dd4a61.jpg","20230504/77a9c5459e3b4e1cb18ad29de09da122.jpg","20230504/6be1735636c5419d849df8ee2ce3aed5.jpg","20230508/17bc163c654647f78d765bf6311369a9.jpg","20230508/95e5184977cc420da1a20a3b841798fd.jpg","20230508/0c562a3f14194717b696e49f50f6a5a5.jpg","20230507/ee426a9c40f047a58d890d680d11c7ce.png","20230508/ef16051aa655425b839ab9c1586c38b2.jpg","20230508/80284bc0fb7842ac8e9101da39f02154.jpg","20230507/28c8fb87d2a840aca79aff62cf137878.png","20230508/d1a06ec6d61a4266adc1af55feefb3bc.png","20230508/c4c80bf895524c4f9a63f0eab780ea9c.png","20230508/ea134bc3a86a4cb5a43d17000ef1f2a0.jpg","20230508/7aacaec954824044bb57399dec4ae144.png","20230508/f80724b71d1849e5a9154439a9492f88.jpg","20230508/634f4ad1da184b5783f193dc9b302c0c.jpg","20230508/d9843ce9c32b43029f9040232d77398b.jpg","20230518/e2df620fca3d4bc09e9f2ed28f9a9888.png","20230508/4909303dd17c469d9d2ffafbe62a60dd.png","20230508/17bbfcb0d1204772bea459effedeca89.png","20230508/b08e784ea430495789936c81fa4b145d.png","20230508/fb76411608da4ef8ae9c5f207166f890.png","20230508/41fc5438f2dc42d4964093c4a8b9dd23.png","20230508/44bf467d7911499ead400d6ba193b479.png","20230508/5efaffd8df60475a800099fa934c6a7c.png","20230508/83b8ed048abe481d8dc6a5fe7f7b6741.png","20230508/de5048c6f5454436b7eab33dd5cb86cc.png","20230508/aaddcd0b982649e68f4f9e6b0ea28d67.png","20230508/356a032a8f704a469d08fddb0fe6691b.png","20230508/26947d54f6c7486da7dcd56116581a15.png","20230508/553c4da890a944588e1644243e824f0a.jpg","20230508/a749cd44290543e08d85c810e2101c99.png","20230508/08ca52affcee4d28ac8e82965f9ecf06.png","20230508/ed6a302412634ccda24e366c443be35a.jpg","20230508/7689f186cfe84b449d8daa3a763dc718.jpg","20230508/804fab37fe67413c8ee19f139f239d7d.png","20230508/9247f42140fe49d99f9eafc260c59cd2.png","20230508/940e21d80ba34c88b568f88e5dbad6e7.png","20230508/d28f83745782454c86cdfd91744f2b7f.png","20230508/1bd4c889eeb34eaab0ceaef48fb62205.png","20230508/e1e4fb5d5e004457b2c42d3671c2a820.jpg","20230508/f7e8192daa0c4d298ba00d5ce9ce52c6.png","20230508/e5dce4e675c641e481fee35ee5e57ea2.png","20230509/83a206a6c9c74d9ab9048df05adc45c7.jpg","20230509/b790ac56551440288d554ad355140873.jpg","20230509/39c279d993c3418abe0e621a1c0223a8.png","20230509/8a9358d6fde540fc943f4b0ed4d178b0.jpg","202310/goods_1696472602910.jpg","202310/goods_1696472629805.jpg","202310/goods_1696472617023.jpg","20230518/ed6254d2cb494b8a96b998198a03d957.png","20230510/895b70132e4d44e7860af4b5b3cec7bf.png","20230510/1fb5203b6e8e42209bd30e9196797e88.jpg","20230510/75f92fd398a94b098ed2a64dd081a312.jpg","20230510/4f0c52b54ac64d71a89a2609fa94daa0.jpg","20230510/6c3d88f82ca64c9cb196c11249cd4458.jpg","20230510/f6ae864367354d51bd76e8373762b491.jpg","202309/goods_1695031417514.jpg","202309/goods_1695031399771.jpg","20230510/00b7d8769e2244f1836ca8b25ebcc05d.jpg","20230510/2932c6482f6a49838f710b434df3730d.jpg","202310/goods_1696397136224.jpg","202310/goods_1696397154145.jpg","202310/goods_1696397181945.jpg","20230510/e6f75cf7df0c4cfd96dce536a4c17381.jpg","20230512/b4f1725d68a34fb1a052eab56e673198.png","202310/goods_1696472571191.jpg","20230513/1ee48d308f404024b9277558d85bac1c.jpg","20230513/0888360e406946f0a279b2f477ce24e2.jpg","20230513/a45ecc30ffe6467c818426fa22bd7c90.png","20230513/d7157a64bf314092b05233b08405774d.png","20230513/3eeb721eea634f8b81faaa2b0e5a6d3d.png","20230513/86fe771f7d64479aabb3d1f4bb1e9cca.png","20230513/0bdf3c3f4f2b4336bc40f05955982dc1.png","20230513/22e140c0e81941aa9e4c5d644232b93c.png","20230513/24c0c3096d4a434d93d39a98e9d5c078.png","20230513/65b355f1d2a04100bbd57a535ff45dac.png","20230513/5e5fa2b3fb90472f8143c0a89b6f3b0d.png","20230510/0265786f94b4400093751f5e8f707f26.png","20230514/f47d7686c48841519894dd69c9069c94.jpg","20230514/4c14e1cc83424797be05fcc01b35c48f.png","20230509/f1fa52d4e68e408b98470ac68e53344d.png","20230509/ccdbc956ca034812b3c319096c42bfd7.png","202309/goods_1693987663435.jpg","20230516/ed5a09faf25a4fc6a86c84bd9dc5e45f.jpg","202310/goods_1698135044263.jpg","202310/goods_1698134900084.jpg","202310/goods_1698134995828.jpg","20230518/cb61f2d6754f49d5a363fee50d5516ba.png","20230518/d962c1f2fe5e47689b26572f0a2d3197.png","20230518/7280227a3ec246388ce4b038a8850fb2.png","20230518/c2808deb9ea644e8b81d1669f7929315.jpg","20230518/da95b4f3b800456ca42ff60e32a769a0.jpg","202309/goods_1693987689730.jpg","202309/goods_1694582312704.jpg","202309/goods_1694582292482.jpg","202309/goods_1694590050809.jpg","202309/goods_1694667565622.jpg","202309/goods_1694668019181.jpg","202309/goods_1694668321906.jpg","202309/goods_1695347471680.jpg","202308/goods_1692689605098.png","202310/goods_1698134958506.jpg","202309/goods_1693987636931.jpg","202310/goods_1696471186983.jpg","202309/goods_1695775886708.jpg","202309/goods_1695775923568.jpg","202309/goods_1695775904565.jpg","202309/goods_1695347707645.jpg","202309/goods_1695347751449.jpg","202309/goods_1694758696765.jpg"};
        String path = "/Users/yslee/Downloads/img";
        //String path = "C:\\img\\";
        int cnt = 1;
        String goodsCode [] = {"PT2062111","PT1730370","PT1730371","PT1834330","PT1834331","PT1834332","PT2064373","PT2064374","PT2064375","PT1956700","PT2062112","PT2062113","PT1956999","PT2066040","PT2066041","PT2064376","PT2063173","PT2062105","PT2062106","PT2062057","PT23218759","PT2063622","PT2065504","PT2065505","PT2065506","PT2062584","PT2062585","PT2062586","PT2062587","PT2066042","PT2064301","PT2065502","PT2065503","PT2064323","PT2065501","PT2063526","PT2064318","PT2064319","PT2066028","PT2066029","PT2066030","PT2066031","PT2062107","PT2064302","PT2065909","PT2065910","PT2070084","PT2070085","PT2070667","PT2070083","PT2068431","PT2068432","PT2068433","PT23218760","PT2074233","PT2073652","PT2073654","PT2073655","PT2073644","PT2073656","PT2073637","PT2073638","PT2073030","PT2073032","PT2071293","PT2071294","PT2071295","PT2073031","PT2185606","PT2183533","PT2187180","PT2187181","PT2191422","PT2191425","PT2191427","PT2191424","PT2191423","PT2191426","PT2191428","PT2191429","PT2191430","PT21101492","PT22113719","PT22113720","PT2070669","PT2070668","PT22165791","PT22173502","PT23203117","PT23203114","PT23203116","PT23211990","PT23211992","PT23211994","PT23217725","PT23217726","PT22165795","HC23220271","HC23220272","HC23220273","HC23220284","HC23220285","HC23220286","HC23220358","HC23220145","PT23203115","PT22165793","HC23220407","HC23220366","HC23220364","HC23220365","HC23220359","HC23220360","HC23220318"};

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

                saveFile = new File(path,cnt + "_" + ptCode + ".jpg");

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