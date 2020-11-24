package com.example.demo;

import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoronaVirusDataServiceTest {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @Test
    public void getKoreaCovidDatas_�����׽�Ʈ() throws IOException {

        // given
        List<KoreaStats> coronaList = new ArrayList<>();

        // when
        coronaList = coronaVirusDataService.getKoreaCovidDatas();

        // then
        assertThat(coronaList.get(0).getCountry()).isEqualTo("�հ�");
        assertThat(coronaList.get(0).getTotal()).isGreaterThan(0);

    }

}