package instagram_clone.instagram_clone.domain.member.controller;

import instagram_clone.instagram_clone.domain.member.dto.MemberRequestDTO;
import instagram_clone.instagram_clone.domain.member.dto.MemberResponseDTO;
import instagram_clone.instagram_clone.domain.member.service.MemberServiceImpl;
import instagram_clone.instagram_clone.global.common.exception.Exception500;
import instagram_clone.instagram_clone.global.common.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
@Slf4j
public class MemberApiController {
    private final MemberServiceImpl memberService;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberRequestDTO.MemberLoginDTO memberLoginDTO, HttpSession httpSession) {
        try {
            log.info("[MemberApiController] login");
            MemberResponseDTO.MemberLoginDTO result = memberService.login(memberLoginDTO);

            httpSession.setAttribute("memberEmail", result.getMemberEmail());
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[MemberApiController] login success", result));
        } catch (Exception500 e) {
            log.info("[Exception] MemberApiController login");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 회원 가입
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody MemberRequestDTO.MemberJoinDTO memberJoinDTO) {
        try {
            log.info("[MemberApiController] join");
            MemberResponseDTO.MemberJoinDTO result = memberService.join(memberJoinDTO);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[MemberApiController] join success", result));
        } catch (Exception500 e) {
            log.info("[Exception500] MemberApiController join");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 회원 가입
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession httpSession, HttpServletRequest request) {
        try {
            log.info("[MemberApiController] logout");
            MemberResponseDTO.MemberLogoutDTO result = memberService.logout(request, (String) httpSession.getAttribute("memberEmail"));
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[MemberApiController] logout success", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] UserApiController join");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 회원 탈퇴
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(HttpSession httpSession) {
        try {
            log.info("[MemberApiController] delete");
            MemberResponseDTO.MemberDeleteDTO result = memberService.delete((String) httpSession.getAttribute("memberEmail"));
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[MemberApiController] delete success", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] MemberApiController delete");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 회원 수정
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MemberRequestDTO.MemberUpdateDTO memberUpdateDTO, HttpSession httpSession) {
        try {
            log.info("[MemberApiController] update");
            System.out.println(memberUpdateDTO.getMemberName());
            MemberResponseDTO.MemberUpdateDTO result = memberService.update(memberUpdateDTO, (String) httpSession.getAttribute("memberEmail"));
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[MemberApiController] update success", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] MemberApiController update");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    // 회원 조회
    @GetMapping("/findOne")
    public ResponseEntity<?> findOne(HttpSession httpSession) {
        try {
            log.info("[MemberApiController] findOne");
            MemberResponseDTO.MemberFindOneDTO result = memberService.findOne((String) httpSession.getAttribute("memberEmail"));
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[MemberApiController] findOne success", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] MemberApiController findOne");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }
}
