package instagram_clone.instagram_clone.domain.likes.controller;

import instagram_clone.instagram_clone.domain.likes.service.LikesServiceImpl;
import instagram_clone.instagram_clone.global.common.exception.Exception500;
import instagram_clone.instagram_clone.global.common.response.ApiResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/likes")
@RequiredArgsConstructor
@Slf4j
public class LikesApiController {
    private final LikesServiceImpl likesService;

    @PostMapping("toggle/{postId}")
    public ResponseEntity<?> toggle(@PathVariable("postId") Long postId, HttpSession httpSession) {
        try {
            String result = likesService.toggle(postId, (String) httpSession.getAttribute("memberEmail"));
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "like toggle success", result));
        } catch (Exception500 e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    @GetMapping("count/{postId}")
    public ResponseEntity<?> count(@PathVariable("postId") Long postId) {
        try {
            String result = likesService.count(postId);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "like count success", result));
        } catch (Exception500 e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }
}
