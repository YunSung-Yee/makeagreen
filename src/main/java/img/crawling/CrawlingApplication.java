package img.crawling;

import img.crawling.controller.Crawl;
import img.crawling.controller.Crawl2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CrawlingApplication {

	private static ApplicationContext context;

	public CrawlingApplication(ApplicationContext context) {
		this.context = context;
	}

	public static void main(String[] args) {
		SpringApplication.run(CrawlingApplication.class, args);
		Crawl crawl = new Crawl();
		boolean end = crawl.downloadImg();
		if(end) SpringApplication.exit(context,() -> 0);
	}
}
