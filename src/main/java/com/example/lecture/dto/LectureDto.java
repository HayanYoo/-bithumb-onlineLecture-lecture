package com.example.lecture.dto;

import com.example.lecture.domain.Lecture;
import com.example.lecture.domain.LectureContent;
import com.example.lecture.domain.Test;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LectureDto {
    private long id;
    private String lectureName;
    private long teacherId;
    private List<LectureContent> lectureContents;
    private Test test;


    public LectureDto(Lecture lecture) {
        this.id = lecture.getId();
        this.lectureName = lecture.getLectureName();
        this.teacherId = lecture.getTeacherId();
        this.lectureContents = lecture.getLectureContents();
        this.test = lecture.getTest();
    }

}
