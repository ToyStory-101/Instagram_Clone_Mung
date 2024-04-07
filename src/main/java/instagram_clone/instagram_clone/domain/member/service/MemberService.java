package instagram_clone.instagram_clone.domain.member.service;

import instagram_clone.instagram_clone.domain.member.dto.MemberRequestDTO;
import instagram_clone.instagram_clone.domain.member.dto.MemberResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface MemberService {
    // 로그인
    MemberResponseDTO.MemberLoginDTO login(MemberRequestDTO.MemberLoginDTO memberLoginDTO);

    // 로그아웃
    MemberResponseDTO.MemberLogoutDTO logout(HttpServletRequest request, String userEmail);

    // 회원 가입
    MemberResponseDTO.MemberJoinDTO join(MemberRequestDTO.MemberJoinDTO memberJoinDTO);

    // 회원 탈퇴
    MemberResponseDTO.MemberDeleteDTO delete(String userEmail);

    // 회원 수정
    MemberResponseDTO.MemberUpdateDTO update(MemberRequestDTO.MemberUpdateDTO memberUpdateDTO, String userEmail);

    // 회원 조회
    MemberResponseDTO.MemberFindOneDTO findOne(String userEmail);
}
