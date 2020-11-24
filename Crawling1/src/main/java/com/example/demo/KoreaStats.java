package com.example.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class KoreaStats {

    public String country; // 시도명

    public int diffFromPrevDay; // 전일대비확진환자증감

    public int total; // 확진환자수

    public int death; // 사망자수

    private double incidence; // 발병률

    private int inspection; // 일일 검사환자 수

}