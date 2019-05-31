package com.ibokngl.issuemanagement.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public class Tpage<T> {

    private int number;         // kaçınca sayfa
    private int size;           // kaçarlı gösteriyor
    private Sort sort;          // herhangi bir sayfayı sıralayacak
    private int totalPage;      // toplamda kaç sayfa
    private Long totalElements; // toplamda kaç kayıt
    private List<T> content;    // Gösterilecek data

    public void setStat(Page page,List<T> list){
        this.number=page.getNumber();
        this.size=page.getSize();
        this.sort=page.getSort();
        this.totalPage=page.getTotalPages();
        this.totalElements=page.getTotalElements();
        this.content=list;

    }
}
