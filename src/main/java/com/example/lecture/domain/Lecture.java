package com.example.lecture.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Lecture {
    private long id;
    private String lectureName;
    private long teacherId;
    private List<registeredStudent> registeredStudents;
    private List<LectureContent> lectureContents;
    private Test test;
}
