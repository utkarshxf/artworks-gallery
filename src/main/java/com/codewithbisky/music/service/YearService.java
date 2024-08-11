package com.codewithbisky.music.service;

import com.codewithbisky.music.model.Year;

public interface YearService {

    Year create(Integer year);
    Year getById(Integer year);
}
