package com.example.lecture.dto;

import com.example.lecture.domain.registeredStudent;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class registeredStudentDto {
    private long studentId;
    private int score;
    private int starValue;
    private boolean showLecture;

    public registeredStudentDto(registeredStudent student) {
        this.studentId = student.getStudentId();
        this.score = student.getScore();
        this.starValue = student.getStarValue();
        this.showLecture = student.isShowLecture();

    }
}
