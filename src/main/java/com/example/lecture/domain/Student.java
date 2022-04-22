package com.example.lecture.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Student {
    private long studentId;
    private int score;
    private int starValue;
    private boolean showLecture;

    private List<Lecture> lectures;
}
