package com.example.lecture.component;

import com.example.lecture.dto.LectureDto;
import com.example.lecture.dto.StudentDto;
import com.example.lecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class PostHandler {

    private final WebClient webClient;
    private final LectureService lectureService;

    public Mono<ServerResponse> takeLecture(ServerRequest serverRequest) {
        Mono<LectureDto> lectureDto = lectureService.takeLecture(serverRequest)
                .map(LectureDto::new);

        return lectureResponseOK(lectureDto);
    }


    // 2. 학생은 수강신청 강의 컨텐츠 조회
    public Mono<ServerResponse> getLectureContents(ServerRequest serverRequest) {
        Mono<LectureDto> lectureDto = lectureService.getLectureContents(serverRequest)
                .map(LectureDto::new);

        return lectureResponseOK(lectureDto);
    }

    ;

    // 3. 학생은 수강한 강의에 대해 별점
    public Mono<ServerResponse> evaluateLecture(ServerRequest serverRequest) {
        Mono<LectureDto> lectureDto = lectureService.evaluateLecture(serverRequest)
                .map(LectureDto::new);

        return lectureResponseOK(lectureDto);
    }

    ;

    // 4. 학생은 수강한 강의 목록을 조회
    // 9. 강사는 과거에 매칭된 강의 목록 조회 가능
    public Mono<ServerResponse> getLectures(ServerRequest serverRequest) {
        Mono<List<LectureDto>> lectureDtos = lectureService.getLectures(serverRequest)
                .map(lectures -> lectures.stream()
                        .map(LectureDto::new)
                        .collect(Collectors.toList())
                );

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureDtos, LectureDto.class);
    }

    ;

    // 5. 강의 개설 및 강사 매칭
    public Mono<ServerResponse> makeLecture(ServerRequest serverRequest) {
        Mono<LectureDto> lectureDto = lectureService.makeLecture(serverRequest)
                .map(LectureDto::new);

        return lectureResponseOK(lectureDto);
    }

    ;

    // 6. 강의를 노출
    public Mono<ServerResponse> showLecture(ServerRequest serverRequest) {
        Mono<StudentDto> studentDto = lectureService.showLecture(serverRequest)
                .map(StudentDto::new);

        return studentResponseOK(studentDto);
    }

    ;

    // 7. 강의 노출을 종료하고 학생 별점 열람
    public Mono<ServerResponse> hideLectureAndOpenStarValue(ServerRequest serverRequest) {
        Mono<StudentDto> studentDto = lectureService.hideLectureAndOpenStarValue(serverRequest)
                .map(StudentDto::new);

        return studentResponseOK(studentDto);
    }

    ;

    // 8. 강사는 강의에 컨텐츠 업로드
    public Mono<ServerResponse> uploadLectureContent(ServerRequest serverRequest) {
        Mono<LectureDto> lectureDto = lectureService.uploadLectureContent(serverRequest)
                .map(LectureDto::new);

        return lectureResponseOK(lectureDto);
    }

    ;

    // 10. 강사는 강의 컨텐츠에 시험 컨텐츠를 추가
    public Mono<ServerResponse> uploadTest(ServerRequest serverRequest) {
        Mono<LectureDto> lectureDto = lectureService.uploadTest(serverRequest)
                .map(LectureDto::new);

        return lectureResponseOK(lectureDto);
    }


    // 11. 강사는 학생 성적 입력 가능
    public Mono<ServerResponse> makeScore(ServerRequest serverRequest) {
        Mono<StudentDto> studentDto = lectureService.makeScore(serverRequest)
                .map(StudentDto::new);

        return studentResponseOK(studentDto);
    }

    private Mono<ServerResponse> lectureResponseOK(Mono<LectureDto> lectureDto) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureDto, LectureDto.class);
    }

    private Mono<ServerResponse> studentResponseOK(Mono<StudentDto> studentDto) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(studentDto, StudentDto.class);
    }


    ;
}
