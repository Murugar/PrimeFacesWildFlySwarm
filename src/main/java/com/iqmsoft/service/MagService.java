package com.iqmsoft.service;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.iqmsoft.domain.Magazine;


@Named
@SessionScoped
public class MagService implements Serializable {
    private List<Magazine> mags;
    
    @PostConstruct
    private void init() {
        mags = new LinkedList<>();
        mags.add(new Magazine("Test1", getDate(2014, Month.MARCH.ordinal(), 10)));
        mags.add(new Magazine("Test2", getDate(2014, Month.JANUARY.ordinal(), 01)));
        mags.add(new Magazine("Test3", getDate(2013, Month.DECEMBER.ordinal(), 24)));
        mags.add(new Magazine("Test4", getDate(2012, Month.NOVEMBER.ordinal(), 19)));
        mags.add(new Magazine("Test5", getDate(2013, Month.MARCH.ordinal(), 10)));
        mags.add(new Magazine("Test6", getDate(2013, Month.JUNE.ordinal(), 04)));
        mags.add(new Magazine("Test7", getDate(2013, Month.OCTOBER.ordinal(), 19)));
    }

    public List<Magazine> getBooks() {
        return mags;
    }
    
    public void addBook(Magazine book) {
        mags.add(book);
    }
    
    private Date getDate(int y, int m, int d) {
        Calendar cal = Calendar.getInstance();
        cal.set(y, m, d);
        return cal.getTime();
    }
    
}
