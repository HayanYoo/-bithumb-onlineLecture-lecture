package com.example.lecture.dto;

import com.example.lecture.domain.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentDto {
    private long studentId;
    private int score;
    private int starValue;
    private boolean showLecture;

    public StudentDto(Student student) {
        this.studentId = student.getStudentId();
        this.score = student.getScore();
        this.starValue = student.getStarValue();
        this.showLecture = student.isShowLecture();

    }
}
