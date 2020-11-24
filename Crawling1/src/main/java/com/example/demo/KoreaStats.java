package com.example.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class KoreaStats {

    public String country; // �õ���

    public int diffFromPrevDay; // ���ϴ��Ȯ��ȯ������

    public int total; // Ȯ��ȯ�ڼ�

    public int death; // ����ڼ�

    private double incidence; // �ߺ���

    private int inspection; // ���� �˻�ȯ�� ��

}