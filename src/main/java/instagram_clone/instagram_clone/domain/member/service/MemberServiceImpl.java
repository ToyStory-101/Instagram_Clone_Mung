package instagram_clone.instagram_clone.domain.member.service;

import instagram_clone.instagram_clone.domain.member.dto.MemberRequestDTO;
import instagram_clone.instagram_clone.domain.member.dto.MemberResponseDTO;
import instagram_clone.instagram_clone.domain.member.entity.Member;
import instagram_clone.instagram_clone.domain.member.repository.MemberRepository;
import instagram_clone.instagram_clone.global.common.CommonMethod;
import instagram_clone.instagram_clone.global.common.exception.CustomException;
import instagram_clone.instagram_clone.global.common.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final CommonMethod commonMethod;
    @Override
    public MemberResponseDTO.MemberLoginDTO login(MemberRequestDTO.MemberLoginDTO memberLoginDTO) {
        log.info("[MemberServiceImpl] login");
        try {
            Optional<Member> optionalFindMember = memberRepository.findByMemberEmailAndMemberPassword(memberLoginDTO.getMemberEmail(), memberLoginDTO.getMemberPassword());
            if(optionalFindMember.isPresent()) {
                return new MemberResponseDTO.MemberLoginDTO(optionalFindMember.get());
            }
            else {
                throw new CustomException(ErrorCode.USER_NOT_FOUND);
            }
        } catch (CustomException ce){
            log.info("[CustomException] MemberServiceImpl login");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] MemberServiceImpl login");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] MemberServiceImpl login : " + e.getMessage());
        }
    }

    @Override
    public MemberResponseDTO.MemberLogoutDTO logout(String userEmail) {
        log.info("[MemberServiceImpl] logout");
        try {
            Member findMember = commonMethod.getMember(userEmail, "email");
            return new MemberResponseDTO.MemberLogoutDTO(findMember);
        } catch (CustomException ce){
            log.info("[CustomException] MemberServiceImpl logout");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] MemberServiceImpl logout");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] MemberServiceImpl logout : " + e.getMessage());
        }
    }

    @Override
    public MemberResponseDTO.MemberJoinDTO join(MemberRequestDTO.MemberJoinDTO memberJoinDTO) {
        log.info("[MemberServiceImpl] join");
        try {
            if (memberRepository.existsByMemberEmail(memberJoinDTO.getMemberEmail())) {
                throw new CustomException(ErrorCode.USER_EXIST);
            }

            Member member = memberJoinDTO.toEntity();
            memberRepository.save(member);

            return new MemberResponseDTO.MemberJoinDTO(member);
        } catch (CustomException ce){
            log.info("[CustomException] MemberServiceImpl join");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] MemberServiceImpl join");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] MemberServiceImpl join : " + e.getMessage());
        }
    }

    @Override
    public MemberResponseDTO.MemberDeleteDTO delete(String userEmail) {
        log.info("[MemberServiceImpl] delete");
        try {
            Member findMember = commonMethod.getMember(userEmail, "email");
            memberRepository.delete(findMember);
            return new MemberResponseDTO.MemberDeleteDTO(findMember);
        } catch (CustomException ce){
            log.info("[CustomException] MemberServiceImpl delete");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] MemberServiceImpl delete");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] MemberServiceImpl delete : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public MemberResponseDTO.MemberUpdateDTO update(MemberRequestDTO.MemberUpdateDTO memberUpdateDTO, String userEmail) {
        log.info("[MemberServiceImpl] update");
        try {
            Member findMember = commonMethod.getMember(userEmail, "email");
            return new MemberResponseDTO.MemberUpdateDTO(findMember);
        } catch (CustomException ce){
            log.info("[CustomException] MemberServiceImpl update");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] MemberServiceImpl update");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] MemberServiceImpl update : " + e.getMessage());
        }
    }

    @Override
    public MemberResponseDTO.MemberFindOneDTO findOne(String userEmail) {
        log.info("[MemberServiceImpl] findOne");
        try {
            Member findMember = commonMethod.getMember(userEmail, "email");
            return new MemberResponseDTO.MemberFindOneDTO(findMember)
        } catch (CustomException ce){
            log.info("[CustomException] MemberServiceImpl findOne");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] MemberServiceImpl findOne");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] MemberServiceImpl findOne : " + e.getMessage());
        }
    }
}
