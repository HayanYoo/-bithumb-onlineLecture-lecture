package com.example.lecture.config;

import com.example.lecture.component.PostHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> getRoute(PostHandler postHandler) {
        return RouterFunctions.route()
                .path("/lecture", builder -> builder
                        .POST("/take", accept(APPLICATION_JSON), postHandler::takeLecture)
                        .GET("/{id}/{studentId}/lectureContents", accept(APPLICATION_JSON), postHandler::getLectureContents)
                        .POST("/{id}/{studentId}/evaluate", accept(APPLICATION_JSON), postHandler::evaluateLecture)
                        .GET("/{memberId}", accept(APPLICATION_JSON), postHandler::getLectures)
                        .POST("/make", accept(APPLICATION_JSON), postHandler::makeLecture)
                        .PATCH("/{id}/show/{studentId}", accept(APPLICATION_JSON), postHandler::showLecture)
                        .PATCH("/{id}/hide/{studentId}", accept(APPLICATION_JSON), postHandler::hideLectureAndOpenStarValue)
                        .POST("/{id}/upload", accept(APPLICATION_JSON), postHandler::uploadLectureContent)
                        .POST("/{id}/test", accept(APPLICATION_JSON), postHandler::uploadTest)
                        .PATCH("/{id}/{studentId}/score", accept(APPLICATION_JSON), postHandler::makeScore)
                )
                .build();
    }


}
