package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.jsoup.*;
import org.springframework.stereotype.Service;
import com.example.demo.KoreaStats;
@Service
public class CoronaVirusDataService {
	private static String KOREA_COVID_DATAS_URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13";

	@PostConstruct
	public  List<KoreaStats> getKoreaCovidDatas() throws IOException {
		  List<KoreaStats> koreaStatsList = new ArrayList<>();
    Document doc = Jsoup.connect(KOREA_COVID_DATAS_URL).get();
    Elements contents = doc.select("table tbody tr");
    
    for(Element content: contents) {
    	Elements tdContents = content.select("td");	
    	
    	KoreaStats koreaStats = KoreaStats.builder()
    			.country(content.select("th").text())
                .diffFromPrevDay(Integer.parseInt(tdContents.get(0).text()))
                .total(Integer.parseInt(tdContents.get(1).text()))
                .death(Integer.parseInt(tdContents.get(2).text()))
                .incidence(Double.parseDouble(tdContents.get(3).text()))
                .inspection(Integer.parseInt(tdContents.get(4).text()))
                .build();
    	 koreaStatsList.add(koreaStats);
    }
    return koreaStatsList;
  }
}