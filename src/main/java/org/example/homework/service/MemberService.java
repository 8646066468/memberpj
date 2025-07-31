package org.example.homework.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.homework.dto.MemberRequest;
import org.example.homework.dto.MemberResponse;
import org.example.homework.entity.Member;
import org.example.homework.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor //기본생성자가 아닌 생성자를 만들어줌 생각 금지
public class MemberService {
    private final MemberRepository memberRepository;

    // 생성
    @Transactional // 작업 단위
    public MemberResponse save(MemberRequest memberRequest) {
        Member member = new Member(memberRequest.getName());
        Member savedmember = memberRepository.save(member);

        return new MemberResponse(savedmember.getId(), savedmember.getName());
    }

    // 조화
    @Transactional(readOnly = true)
    public MemberResponse getMember(long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 사람 없어요잉"));
        return new MemberResponse(
                member.getId(),
                member.getName()
        );
    }

    // 전체 조회
    @Transactional(readOnly = true)
    public List<MemberResponse> getMembers() {
        List<Member> members = memberRepository.findAll();

        List<MemberResponse> doList = new ArrayList<>();
        for (Member member : members) {
            MemberResponse memberResponse = new MemberResponse(member.getId(), member.getName());
            doList.add(memberResponse);
        }
        return doList;
    }

    //단건 업데이트
    @Transactional
    public MemberResponse updateMember(Long id, MemberRequest memberRequest) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 사람 없어요잉"));
        member.updateName(memberRequest.getName());

        return new MemberResponse(member.getId(), member.getName());
    }

    @Transactional
    public void deleteMember(long id) {M
         memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 사람 없어요잉"));
        memberRepository.deleteById(id);
    }
}
