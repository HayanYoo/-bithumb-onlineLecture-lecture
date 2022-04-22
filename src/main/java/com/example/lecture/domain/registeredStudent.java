package com.example.lecture.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class registeredStudent {
    private long id;
    private long studentId;
    private int score;
    private int starValue;
    private boolean showLecture;

    private Lecture lectures;
}
