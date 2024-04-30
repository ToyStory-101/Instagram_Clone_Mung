package instagram_clone.instagram_clone.domain.post.controller;

import instagram_clone.instagram_clone.domain.post.dto.PostRequestDTO;
import instagram_clone.instagram_clone.domain.post.dto.PostResponseDTO;
import instagram_clone.instagram_clone.domain.post.service.PostServiceImpl;
import instagram_clone.instagram_clone.global.common.exception.Exception500;
import instagram_clone.instagram_clone.global.common.response.ApiResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
@Slf4j
public class PostApiController {
    private final PostServiceImpl postService;

    // 게시물 업로드
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestBody PostRequestDTO.PostUploadDTO postUploadDTO, HttpSession httpSession) {
        try {
            log.info("[PostApiController] upload");
            PostResponseDTO.PostUploadDTO result = postService.upload(postUploadDTO, (String) httpSession.getAttribute("memberEmail"));
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "post upload success", result));
        } catch (Exception500 e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 게시물 삭제
    @PostMapping("/delete/{postId}")
    public ResponseEntity<?> delete(@PathVariable("postId") Long postId, HttpSession httpSession) {
        try {
            log.info("[PostApiController] delete");
            postService.delete(postId, (String) httpSession.getAttribute("memberEmail"));
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "post delete success"));
        } catch (Exception500 e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 게시물 수정
    @PostMapping("/update/{postId}")
    public ResponseEntity<?> update(@RequestBody PostRequestDTO.PostUpdateDTO postUpdateDTO, @PathVariable("postId") Long postId, HttpSession httpSession) {
        try {
            log.info("[PostApiController] update");
            PostResponseDTO.PostUpdateDTO result = postService.update(postUpdateDTO, (String) httpSession.getAttribute("memberEmail"), postId);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "post update success", result));
        } catch (Exception500 e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 게시물 하나 조회
    @GetMapping("/findOne/{postId}")
    public ResponseEntity<?> findOne(@PathVariable("postId") Long postId) {
        try {
            log.info("[PostApiController] findOne");
            PostResponseDTO.PostFindOneDTO result = postService.findOne(postId);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "post findOne success", result));
        } catch (Exception500 e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 게시물 전체 조회
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(HttpSession httpSession) {
        try {
            log.info("[PostApiController] findAll");
            PostResponseDTO.PostFindAllDTO result = postService.findAll((String) httpSession.getAttribute("memberEmail"));
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "post findAll success", result));
        } catch (Exception500 e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }
}
