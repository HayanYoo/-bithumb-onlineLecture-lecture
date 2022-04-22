package com.example.lecture.service;

import com.example.lecture.domain.Lecture;
import com.example.lecture.domain.registeredStudent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public interface LectureService {
    // 1. 학생은 강의를 수강신청
    Mono<Lecture> enrollLecture(ServerRequest serverRequest);

    // 2. 학생은 수강신청 강의 컨텐츠 조회
    Mono<Lecture> getLectureContents(ServerRequest serverRequest);

    // 3. 학생은 수강한 강의에 대해 별점
    Mono<Lecture> evaluateLecture(ServerRequest serverRequest);

    // 4. 학생은 수강한 강의 목록을 조회
    // 9. 강사는 과거에 매칭된 강의 목록 조회 가능
    Mono<List<Lecture>> getLectures(ServerRequest serverRequest);

    // 5. 강의 개설 및 강사 매칭
    Mono<Lecture> makeLecture(ServerRequest serverRequest);

    // 6. 강의를 노출
    Mono<registeredStudent> showLecture(ServerRequest serverRequest);

    // 7. 강의 노출을 종료하고 학생 별점 열람
    Mono<registeredStudent> hideLectureAndGetStarValue(ServerRequest serverRequest);

    // 8. 강사는 강의에 컨텐츠 업로드
    Mono<Lecture> uploadLectureContent(ServerRequest serverRequest);

    // 10. 강사는 강의 컨텐츠에 시험 컨텐츠를 추가
    Mono<Lecture> uploadTest(ServerRequest serverRequest);

    // 11. 강사는 학생 성적 입력 가능
    Mono<registeredStudent> makeScore(ServerRequest serverRequest);
}
