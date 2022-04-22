package com.example.lecture.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LectureContent {
    private long id;
    private String name;
    private String url;

    private Lecture lecture;
}
